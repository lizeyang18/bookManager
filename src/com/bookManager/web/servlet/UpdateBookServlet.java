package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lizeyang on 2019/11/22.
 * function:修改书籍信息
 */
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        /*获取参数*/
        Book book = new Book();
        try{
            BeanUtils.populate(book,request.getParameterMap());
        }catch(Exception e){
            e.printStackTrace();
        }

        /*数据处理*/
        BookService bs = new BookServiceImpl();
        bs.updateBook(book);
        /*分发转向*/
        request.getRequestDispatcher("BookListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
