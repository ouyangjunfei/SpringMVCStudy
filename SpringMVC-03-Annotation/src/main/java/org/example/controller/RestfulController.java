package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestfulController {

    /**
     * http://localhost:8079/add?a=2&b=6
     * <p>
     * 通过URL计算两个数的和并显示在新页面上
     *
     * @param a     参数1
     * @param b     参数2
     * @param model 数据
     * @return JSP页面名称
     */
    @RequestMapping(value = "/old/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(int a, int b, Model model) {
        model.addAttribute("msg", "结果为" + (a + b));
        return "test";
    }

    //@RequestMapping(value = "/new/add/{a}/{b}", method = RequestMethod.GET)
    //等价于下面的注解，只支持一种方式注解

    /**
     * Restful风格的url
     * <p>
     * 等价于@RequestMappin(value = "/new/add/{a}/{b}", method = RequestMethod.GET)
     * <p>
     * 等价于下面的注解，只支持一种方式注解
     *
     * @param a     参数1
     * @param b     参数2
     * @param model 数据
     * @return JSP页面名称
     */
    @GetMapping("/new/add/{a}/{b}")
    public String add2(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("msg", "结果为" + (a + b));
        return "test";
    }


}
