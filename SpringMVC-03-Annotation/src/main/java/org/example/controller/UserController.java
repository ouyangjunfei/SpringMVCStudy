package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pojo.User;
import org.example.utils.JsonUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 接收前端参数/user/name?name=${name}
     * <p>
     * 如果URL参数名不为name，可以用注解@RequestParam("targetName")替换
     * <p>
     * 建议显式写上注明这是前端传递的参数
     *
     * @param name  前端传递参数
     * @param model 传递数据
     * @return test页面
     */
    @GetMapping("/name")
    public String getName(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", "后端传递的" + name);
        return "test";
    }

    /**
     * 接收前端参数/user/user?id=${id}&name=${name}&age=${age}
     * <p>
     * 后端直接用 {@link org.example.pojo.User} 对象接收
     * <p>
     * 如果前端的字段名称不对或者没有某个字段，则对应值为null或者0
     *
     * @param user  实体类
     * @param model 传递数据
     * @return test页面
     */
    @GetMapping("/user")
    public String getUser(User user, Model model) {
        model.addAttribute("msg", user.toString());
        System.out.println(user);
        return "test";
    }

    /**
     * <b>重要</b>
     * <p>
     * <p>
     * 过滤器解决POST参数中文乱码
     *
     * @param username 前端提交的参数名
     * @param model    传递数据
     * @return test页面
     */
    @PostMapping("/encoding")
    public String getUsername(@RequestParam("username") String username, Model model) {
        System.out.println(username);
        model.addAttribute("msg", username);
        return "test";
    }

    // 不走视图解析器，直接返回字符串，也可以在类上使用@RestController
    //@ResponseBody
    // @RequestMapping(value = "/json",produces = "application/json;charset=UTF-8")
    // 可以用注解解决乱码问题，此时返回的类型是json，但是每个注解都需要配置，很麻烦
    @RequestMapping("/json")
    public String getJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(2, "欧阳", 18);
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/json/list")
    public String getJson2() throws JsonProcessingException {
        User user1 = new User(1, "欧阳1号", 18);
        User user2 = new User(2, "欧阳2号", 16);
        User user3 = new User(3, "欧阳3号", 12);
        User user4 = new User(4, "欧阳4号", 15);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return JsonUtil.getJson(userList);
    }

    @RequestMapping("/json/date")
    public String getJson3() {
        return JsonUtil.getJson(new Date());
    }

    @RequestMapping("/json/fast")
    public String getJson4() {
        User user1 = new User(1, "欧阳1号", 18);
        User user2 = new User(2, "欧阳2号", 16);
        User user3 = new User(3, "欧阳3号", 12);
        User user4 = new User(4, "欧阳4号", 15);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JSON.toJSONString(userList);
    }
}
