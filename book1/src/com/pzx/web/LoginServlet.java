package com.pzx.web;

import com.pzx.pojo.User;
import com.pzx.service.UserService;
import com.pzx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author panzhixin
 * @date 2022/10/1
 * @description
 */

public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User loginUser=userService.login(new User(null,username,password,null));
        if(loginUser==null){
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}