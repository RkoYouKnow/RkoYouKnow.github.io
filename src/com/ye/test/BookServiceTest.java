package com.ye.test;

import com.ye.pojo.Book;
import com.ye.pojo.Page;
import com.ye.service.BookService;
import com.ye.service.impl.BookServiceImp;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 21:21
 */
public class BookServiceTest {

    BookService bookService = new BookServiceImp();

    @Test
    public void addBook() {
        Book book = new Book(null,"nie","nie",new BigDecimal(20),2,2,null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        Book book = new Book(22,"叶文鸿","nie",new BigDecimal(20),2,2,null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book b:books
             ) {
            System.out.println(b);
        }
    }

    /**
     *
     */
    @Test
    public void page(){
        bookService.page(4,4);
    }

    /**
     *
     */
    @Test
    public void pageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(1, 4, 0, 50);

        System.out.println(bookPage);

    }


}