package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lizeyang on 2019/11/25.
 * function:分页中书籍的具体信息展示
 */
public class FindBookInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*获取参数*/
        String id = request.getParameter("id");
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        Book book = bs.findBookById(id);
        /*分发转向*/
        request.setAttribute("book", book);
        request.getRequestDispatcher("product_info.jsp").forward(request, response);
    }
}
