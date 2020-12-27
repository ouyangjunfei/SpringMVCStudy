package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class GoController {

    @RequestMapping("/go/test")
    public String test(String msg, Model model) throws IOException {
        msg = URLDecoder.decode(msg, "UTF-8");
        model.addAttribute("msg", msg);
        System.out.println(msg);
        //可以拿到，说明Servlet的请求和响应都能使用，但是不建议使用

        return "test";
    }

    /**
     * SpringMVC中转发的写法
     *
     * @param model 一些数据
     * @return 转发后跳转的页面
     */
    @RequestMapping("/go/forward")
    public String forward(Model model) {
        model.addAttribute("msg", "经过转发跳转，查看URL");
        return "test";
    }

    /**
     * SpringMVC中重定向的写法
     *
     * @param model 一些数据
     * @return 重定向目标页面
     */
    @RequestMapping("/go/redirect")
    public String redirect(Model model) throws UnsupportedEncodingException {
        model.addAttribute("msg", URLEncoder.encode("经过重定向跳转，查看URL", "UTF-8"));
        return "redirect:/go/test";
    }
}
