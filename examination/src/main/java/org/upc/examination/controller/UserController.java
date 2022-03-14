package org.upc.examination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.User;
import org.upc.examination.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public User login(String id, String pwd){
        return userService.login(id,pwd);
    }

    @PostMapping("/register")
    public int register(User user){
        return userService.register(user);
    }

    @GetMapping("/test")
    public String msg(){
        return "得到信息第二次";
    }
}
