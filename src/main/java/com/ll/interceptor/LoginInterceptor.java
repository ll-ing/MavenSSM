package com.ll.interceptor;


import com.ll.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("拦截器");
        if (requestURI.indexOf("login")>0) {
            return true;
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return true;
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return false;
    }
}
