package org.upc.examination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Users;
import org.upc.examination.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public Users login(int userId, String userPassword){
        return userService.login(userId,userPassword);
    }

    @PostMapping("/register")
    public int register(Users user){
        return userService.register(user);
    }

}
