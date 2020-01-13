package com.psysoft.config.annocation;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/hello")
@Order(2)
public class WebMyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPut(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet 开始处理 GET 方法");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello Servlet");
        writer.flush();
        writer.close();
    }



    @Override
    public void init() throws ServletException {
        System.out.println("初始化servlet");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlert");
        super.destroy();
    }
}
