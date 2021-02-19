package com.ye.web;

import com.ye.pojo.Book;
import com.ye.pojo.Page;
import com.ye.service.BookService;
import com.ye.service.impl.BookServiceImp;
import com.ye.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 22:12
 */
public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImp();

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageNo = request.getParameter("pageNo");

        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//
        bookService.addBook(book);

        //request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);

        response.sendRedirect(request.getContextPath()+"//manager/bookServlet?action=page&pageNo="+(pageNo+1));
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        WebUtils.parseInt(id,-1);

        bookService.deleteBookById(Integer.valueOf(id));

        response.sendRedirect(request.getContextPath()+"//manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));

    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        List<Book> books = bookService.queryBooks();

        request.setAttribute("books",books);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }

    /**
     * 获取要修改的图书信息
     */
    public void getBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");

//        Book book = bookService.queryBookById(WebUtils.parseInt(, 0));
//
        int i = WebUtils.parseInt(id, 0);

        Book book = bookService.queryBookById(i);


        request.setAttribute("abook",book);
//        System.out.println(request.getContextPath());

        System.out.println(book);


        //注意这里不能使用重定向
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);


    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获取当前要修改的当前页数的值
        String pageNo = request.getParameter("pageNo");

        System.out.println("执行update操作");

        Map<String, String[]> map = request.getParameterMap();

        Book book = WebUtils.copyParamToBean(map, new Book());

        bookService.updateBook(book);

        System.out.println(book);

        response.sendRedirect(request.getContextPath()+"//manager/bookServlet?action=page&pageNo="+pageNo);

    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("调用page方法");

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);



        page.setUrl("manager/bookServlet?action=page");

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);


    }






}
