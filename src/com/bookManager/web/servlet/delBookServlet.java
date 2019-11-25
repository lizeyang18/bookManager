package com.bookManager.web.servlet;

import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lizeyang on 2019/11/22.
 * function:删除一本书
 */
public class delBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        /*获取参数*/
        String id = request.getParameter("id");
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        bs.delBook(id);
        /*请求分发*/
        request.getRequestDispatcher("BookListServlet").forward(request, response);
    }
}
