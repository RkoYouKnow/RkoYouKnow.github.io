package com.ye.service;

import com.ye.pojo.Book;
import com.ye.pojo.Page;

import java.util.List;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 21:11
 */
public interface BookService {

    public void addBook(Book book);


    public void deleteBookById (Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo,int pageSize);

    public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);

}
