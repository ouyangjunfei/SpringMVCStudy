package org.example.controller;

import org.example.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AjaxController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/get/username")
    public void getUsername(String username, HttpServletResponse resp) throws IOException {
        System.out.println(username);
        if ("欧阳".equals(username)) {
            resp.getWriter().print("true");
        } else {
            resp.getWriter().print("false");
        }
    }

    @RequestMapping("/get/user")
    public List<User> getUser() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("欧阳", 18, 'm'));
        userList.add(new User("张三", 10, 'f'));
        userList.add(new User("李四", 22, 'm'));

        return userList;
    }

    @RequestMapping("/check")
    public Map<String, String> getUsername(String username, String password) {
        Map<String, String> map = new HashMap<>();
        String message = null;
        if (username != null) {
            if ("admin".equals(username)) {
                message = "y";
            } else {
                message = "n";
            }
        }
        map.put("username", message);
        if (password != null) {
            if ("123456".equals(password)) {
                message = "y";
            } else {
                message = "n";
            }
        }
        map.put("password", message);
        return map;
    }
}
