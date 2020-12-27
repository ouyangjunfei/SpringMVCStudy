package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password) {
        //需要把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        return "main";
    }

    @RequestMapping("/toLogin")
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userLoginInfo");
        return "login";
    }
}
