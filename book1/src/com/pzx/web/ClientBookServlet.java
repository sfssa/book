package com.pzx.web;

import com.pzx.pojo.Book;
import com.pzx.pojo.Page;
import com.pzx.service.BookService;
import com.pzx.service.impl.BookServiceImpl;
import com.pzx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author panzhixin
 * @date 2022/10/5
 * @description
 */

public class ClientBookServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/clientBookServlet?action=page");
        req.setAttribute("page",page);
        //resp.sendRedirect(req.getContextPath() + "/pages/client/index.jsp");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder stringBuilder = new StringBuilder("client/clientBookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        //resp.sendRedirect(req.getContextPath() + "/pages/client/index.jsp");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}