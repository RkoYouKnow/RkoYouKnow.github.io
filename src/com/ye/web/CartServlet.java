package com.ye.web;

import com.ye.pojo.Book;
import com.ye.pojo.Cart;
import com.ye.pojo.CartItem;
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
 * @create 2021-02-14 20:48
 */
public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImp();

    public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String bookId = request.getParameter("bookId");

        Book book = bookService.queryBookById(WebUtils.parseInt(bookId, 0));

        //把book转换为CartItem
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart)request.getSession().getAttribute("cart");


        if (cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }

        cart.addItems(cartItem);

        System.out.println(cart);

        request.getSession().setAttribute("lastName",cartItem.getName());

       response.sendRedirect(request.getHeader("Referer"));

    }

    public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");


        Cart cart = (Cart)request.getSession().getAttribute("cart");


        if (cart!=null){
            cart.deleteItems(WebUtils.parseInt(id,0));

        }
        response.sendRedirect(request.getHeader("Referer"));


    }

    public void clear(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Cart cart = (Cart)request.getSession().getAttribute("cart");

        if (cart!=null){
            cart.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));



    }

    public void updateCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String count = request.getParameter("count");

        int idint = WebUtils.parseInt(id, 0);
        int countint = WebUtils.parseInt(count, 0);

        Cart cart = (Cart)request.getSession().getAttribute("cart");

        if (cart!=null){
            cart.updateCount(idint,countint);
        }
        response.sendRedirect(request.getHeader("Referer"));


    }


}
