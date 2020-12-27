package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 代表这个类会被Spring接管为Bean
 * <p>
 * 此注解的类中所有方法，如果返回值是String类型
 * <p>
 * 并且有具体页面可以跳转，那么就会被视图解析器解析
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据
        model.addAttribute("msg", "你好呀呀SpringMVC!");
        return "hello";     //会被视图解析器处理
    }
}
