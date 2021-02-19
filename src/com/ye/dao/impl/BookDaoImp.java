package com.ye.dao.impl;

import com.ye.dao.BaseDao;
import com.ye.dao.BookDao;
import com.ye.pojo.Book;
import com.ye.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 20:26
 */
public class BookDaoImp extends BaseDao implements BookDao  {
    @Override
    public int addBook(Book book) {

        String sql = "INSERT INTO t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) VALUES(?,  ? , ? , ? ,? , ?);";

        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_Path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM t_book WHERE id=?;";

        return update(sql,id);

    }

    @Override
    public int updateBook(Book book) {

        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_Path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {

        String sql = "SELECT `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` FROM t_book WHERE id = ?";
        return queryForOne(Book.class, sql, id);

    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` FROM t_book";
        List<Book> books = queryForList(Book.class, sql);
        return books;

    }

    @Override
    public int queryForPageTotalCount() {
        String sql = "SELECT COUNT(*) FROM `t_book`";
        Number number = (Number) queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {

        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` FROM `t_book` LIMIT ? ,?";

        List<Book> books = queryForList(Book.class, sql, begin, pageSize);

        return books;


    }

    @Override
    public int queryForPageTotalCount(int min, int max) {
        String sql = "SELECT COUNT(*) FROM `t_book` WHERE `price` BETWEEN ? AND ?";
        Number number = (Number) queryForSingleValue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize, int min, int max) {
        System.out.println("ss");

        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` FROM `t_book` WHERE `price` BETWEEN ? AND ? order by price LIMIT ? ,?";
        List<Book> books = queryForList(Book.class, sql, min, max, begin, pageSize);
        return books;


    }
}
