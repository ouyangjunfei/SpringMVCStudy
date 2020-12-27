package org.example.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //登录页面与登录请求要放行
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().contains("toLogin") || request.getRequestURI().contains("login") || request.getRequestURI().contains("logout")) {
            return true;
        }

        //放行：也就是已经登陆了
        if (session != null && session.getAttribute("userLoginInfo") != null) {
            System.out.println(session.getAttribute("userLoginInfo"));
            return true;
        }

        //判断什么情况没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
