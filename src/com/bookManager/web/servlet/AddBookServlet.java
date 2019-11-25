package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;
import com.bookManager.utils.UUIDUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by lizeyang on 2019/11/22.
 */
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        /*获取参数*/
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            book.setId(UUIDUtil.getUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*处理数据*/
        BookService bs = new BookServiceImpl();
        bs.addBook(book);
        /*请求分发*/
        request.getRequestDispatcher("BookListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
