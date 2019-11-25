package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lizeyang on 2019/11/25.
 */
public class SearchBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        /*获取参数*/
        String id = request.getParameter("id");
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        List<Book> books = bs.searchBooks(id, category, name, minprice, maxprice);
        /*分发转向*/
        request.setAttribute("books", books);
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
