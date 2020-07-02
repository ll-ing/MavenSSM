/*
package com.ll.filter;

import com.ll.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

*/
/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2019/10/22
 *//*

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String URI = request.getRequestURI();
        if (URI.endsWith("login.jsp") || URI.endsWith("login")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                filterChain.doFilter(request, response);
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    */
/*   String url = request.getRequestURI();
           if (url.endsWith("/login.jsp") || url.endsWith("/login.do")) {
           filterChain.doFilter(request, response);
       } else {
           User login_user = (User) request.getSession().getAttribute("login_user");
           if (login_user != null) {
               if ("超级管理员".equals(login_user.getRole())) {
                   filterChain.doFilter(request, response);
               } else {
                   response.sendRedirect(request.getContextPath()+"/admin/error/privilege.jsp;");
               }
           }else {
               response.sendRedirect(request.getContextPath()+"/admin/error/privilege.jsp;");

           }
       }*//*

    @Override
    public void destroy() {

    }
}
*/
