package com.ye.test;

import com.ye.dao.BookDao;
import com.ye.dao.impl.BookDaoImp;
import com.ye.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 20:57
 */
public class BookDaoTest {

    private BookDao bookDao= new BookDaoImp();

    @Test
    public void addBook() {

        Book book = new Book(null,"a","b",new BigDecimal(20),2,2,null);

        bookDao.addBook(book);

    }

    @Test
    public void deleteBookById() {

        bookDao.deleteBookById(21);

    }

    @Test
    public void updateBook() {

        bookDao.updateBook(new Book(22,"ye","java",new BigDecimal(20),2,2,null));

    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(22);
        System.out.println(book);

    }

    @Test
    public void queryBooks() {

        List<Book> books = bookDao.queryBooks();

        for (Book b:books
             ) {
            System.out.println(b);
        }

    }


    /**
     *
     */
    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    /**
     *
     */
    @Test
    public void queryForItems(){
        List<Book> books = bookDao.queryForItems(0, 4);
        for (Book b:books
             ) {
            System.out.println(b);
        }

    }


    @Test
    public void queryForPageTotalCount2(){

        System.out.println(bookDao.queryForPageTotalCount(1,50));
    }

    @Test
    public void queryForPageItems() {

        List<Book> books = bookDao.queryForPageItems(1, 4, 1, 50);

        for (Book b:books
             ) {
            System.out.println(b.toString());
        }
    }




    }