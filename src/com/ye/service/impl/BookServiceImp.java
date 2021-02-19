package com.ye.service.impl;

import com.ye.dao.BookDao;
import com.ye.dao.impl.BookDaoImp;
import com.ye.pojo.Book;
import com.ye.pojo.Page;
import com.ye.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 21:15
 */
public class BookServiceImp implements BookService {

    BookDao bookDao = new BookDaoImp();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public  Page<Book> page(int pageNo, int pageSize) {

        Page<Book> bookPage = new Page<>();


        bookPage.setPageSize(pageSize);//设置每页显示的数量


        //设置页面的总记录数
        Integer count = bookDao.queryForPageTotalCount();
        bookPage.setPageTotalCount(count);

        //设置总页码
        Integer PageTotal = count / pageSize ;
        if (count%PageTotal>0){
            PageTotal++;
        }
        bookPage.setPageTotal(PageTotal);

        bookPage.setPageNo(pageNo);//设置当前页码

        //设置当前页面数据
        int begin = (bookPage.getPageNo() - 1) * pageSize ;
        List<Book> books = bookDao.queryForItems(begin, pageSize);
        bookPage.setItems(books);



        return bookPage;


    }

    public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max){

        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);//设置每页显示的数量

        //设置总记录数
        int count = bookDao.queryForPageTotalCount(min,max);
        bookPage.setPageTotalCount(count);

        Integer PageTotal = count / pageSize ;
        if (count%PageTotal>0){
            PageTotal++;
        }
        bookPage.setPageTotal(PageTotal);

        bookPage.setPageNo(pageNo);//设置当前页码

        //设置当前页面数据
        int begin = (bookPage.getPageNo() - 1) * pageSize ;
        List<Book> books = bookDao.queryForPageItems(begin, pageSize, min, max);
        bookPage.setItems(books);

        return bookPage;
    }

}
