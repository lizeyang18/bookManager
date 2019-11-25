package com.bookManager.web.servlet;

import com.bookManager.domain.PageBean;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lizeyang on 2019/11/25.
 * functionL实现分页
 */
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*参数获取*/
        int pageSize = 4;
        int currentPage = 1;
        String currPage = request.getParameter("currentPage");
        if (currPage != null) {
            currentPage = Integer.parseInt(currPage);
        }
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        PageBean pb = bs.findBooksPage(currentPage, pageSize);
        /*分发转向*/
        request.setAttribute("pb", pb);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
}
