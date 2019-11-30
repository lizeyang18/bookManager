package com.bookManager.web.servlet;

import com.bookManager.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lizeyang on 2019/11/26.
 * function：购物车中对商品+,-操作
 */
public class changeNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*请求数据*/
        String id = request.getParameter("id");
        String num = request.getParameter("num");
        System.out.println(id);
        System.out.println(num);
        /*数据处理*/
        Book b = new Book();
        b.setId(id);

        HttpSession session = request.getSession();
        Map<Book, String> cart = (Map<Book, String>) session.getAttribute("cart");
        if ("0".equals(num)) {
            cart.remove(b);
        }
        if (cart.containsKey(b)) {
            cart.put(b, num);
            System.out.println(cart.get(b));
        }
        /*分发转向*/
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
