package org.smart4j.chapter2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Houfy on 2017/11/21.
 *
 *  创建客户
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet{

    /**
     *  进入页面 创建客户
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TODO
    }

    /**
     *  处理请求 创建客户*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TODO
    }
}
