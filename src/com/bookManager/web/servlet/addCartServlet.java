package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizeyang on 2019/11/26.
 * function：加入购物车功能
 */
public class addCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*请求参数*/
        String id = request.getParameter("id");
        /*数据处理*/
        BookService bs = new BookServiceImpl();
        Book b = bs.findBookById(id);

        HttpSession session = request.getSession();
        Map<Book,String> cart = (Map<Book,String>)session.getAttribute("cart");
        int num = 1;
        if(cart==null){
            cart = new HashMap<Book,String>();
            System.out.println("新建一个购物车session");
        }
        if(cart.containsKey(b)){
            num= Integer.parseInt(cart.get(b))+1;
            System.out.println("商品已存在，数量为："+num);
        }
        cart.put(b,num+"");
        /*分发转向*/
        session.setAttribute("cart",cart);
        out.print("<a href = '"+request.getContextPath()+"/PageServlet'>继续购物</a>&nbsp;&nbsp;<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");
    }
}
