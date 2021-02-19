package com.ye.dao;

import com.ye.pojo.Book;

import java.util.List;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 20:21
 */
public interface BookDao {

    /**
     * 添加图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 通过id删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);


    public int updateBook(Book book);

    /**
     * 通过图书的id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);



    public List<Book> queryBooks();


    public int queryForPageTotalCount();


    public List<Book> queryForItems(int begin,int pageSize);

    public int queryForPageTotalCount(int min, int max);

    public List<Book> queryForPageItems(int begin,int pageSize,int min,int max);
}
