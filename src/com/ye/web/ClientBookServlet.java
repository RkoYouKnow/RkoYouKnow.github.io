package com.ye.web;

import com.ye.pojo.Book;
import com.ye.pojo.Page;
import com.ye.service.BookService;
import com.ye.service.impl.BookServiceImp;
import com.ye.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-13 15:01
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImp();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("调用page方法");

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        System.out.println("hh");

        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);


        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");

        if (request.getParameter("min")!=null){
            stringBuilder.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max")!=null){
            stringBuilder.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(stringBuilder.toString());

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
}
