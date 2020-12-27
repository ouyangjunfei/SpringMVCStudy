package org.example.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView模型和视图
        ModelAndView modelAndView = new ModelAndView();

        //封装对象，放在ModelAndView中
        modelAndView.addObject("msg", "你好, SpringMVC!");
        //封装要跳转的视图，放在ModelAndView中
        modelAndView.setViewName("hello");  //自动拼接成/WEB-INF/jsp/hello.jsp
        return modelAndView;
    }
}
