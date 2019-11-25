package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lizeyang on 2019/11/22.
 * function:根据Id查询书籍，再转向修改界面
 */
public class findBookByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*获取参数*/
        String id = request.getParameter("id");
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        Book book = bs.findBookById(id);
        /*分发转向*/
        request.setAttribute("book", book);
        request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
    }
}
