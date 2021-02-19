package com.ye.web;

import com.ye.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-09 22:31
 */
@Deprecated
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ss");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            students.add(new Student(t,"name"+t,18,"13812345678"));
        }

        request.setAttribute("students",students);

        request.getRequestDispatcher("/test/test2.jsp").forward(request,response);
    }
}
