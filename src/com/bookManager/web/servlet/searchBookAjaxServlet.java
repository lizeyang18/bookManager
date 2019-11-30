package com.bookManager.web.servlet;

import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lizeyang on 2019/11/26.
 */
public class searchBookAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        /*获取参数*/
        String name = request.getParameter("name");
        /*处理数据*/
        BookService bs = new BookServiceImpl();
        List<Object> list = bs.searchBookByName(name);

        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                str += ",";
            }
            str += list.get(i);
        }
        /*分发转向*/
        response.getWriter().write(str);
    }
}
