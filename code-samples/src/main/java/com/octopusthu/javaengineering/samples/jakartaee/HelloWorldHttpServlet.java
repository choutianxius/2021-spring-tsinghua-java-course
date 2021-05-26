package com.octopusthu.javaengineering.samples.jakartaee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HTTP Servlet 示例
 *
 * @author octopusthu@gmail.com
 */
public class HelloWorldHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().println("Greetings from HelloWorldHttpServlet!");
    }
}
