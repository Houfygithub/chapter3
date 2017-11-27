package org.smart4j.chapter3.controller;

import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Houfy on 2017/11/21.
 *
 *  创建客户
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet{

   private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    /**
     *  进入页面 创建客户
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/customer_create.jsp").forward(req,resp);
    }

    /**
     *  处理请求 创建客户*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> fieldMap = new HashMap<>();
        String name= req.getParameter("name");
        String contact = req.getParameter("contact");

//       TODO

    }
}
