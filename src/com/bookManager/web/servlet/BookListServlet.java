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
import java.util.List;

/**
 * Created by lizeyang on 2019/11/22.
 * function:查询所有书籍
 */
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        /*获得参数-这里不需要获取，只是查询*/
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        List<Book> list = bs.findAllBooks();
        /*分发转向*/
        if (list != null) {
            request.setAttribute("books", list);
            request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
        }
    }
}
