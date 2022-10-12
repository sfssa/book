package com.pzx.web;

import com.pzx.pojo.Cart;
import com.pzx.pojo.User;
import com.pzx.service.BookService;
import com.pzx.service.OrderService;
import com.pzx.service.impl.OrderServiceImpl;
import com.pzx.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author panzhixin
 * @date 2022/10/11
 * @description
 */

public class OrderServlet extends BaseServlet {

    private OrderService orderService=new OrderServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}