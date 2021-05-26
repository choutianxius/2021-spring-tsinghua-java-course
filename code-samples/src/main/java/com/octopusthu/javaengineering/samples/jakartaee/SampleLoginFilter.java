package com.octopusthu.javaengineering.samples.jakartaee;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录 Filter 示例，仅供教学演示。
 *
 * @author octopusthu@gmail.com
 */
public class SampleLoginFilter implements Filter {
    public static final String FILTER_PROCESSING_URL = "/login";
    public static final String TOKEN_PARAM_NAME = "token";
    public static final String TOKEN_PARAM_VALUE = "secretValue";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (!FILTER_PROCESSING_URL.equals(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        String token = req.getParameter(TOKEN_PARAM_NAME);
        if (TOKEN_PARAM_VALUE.equals(token)) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.getWriter().println("Login successful");
            Cookie cookie = new Cookie("random", "randomValue");
            res.addCookie(cookie);
            return;
        }
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.getWriter().println("Login failed. Wrong token: " + token);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
