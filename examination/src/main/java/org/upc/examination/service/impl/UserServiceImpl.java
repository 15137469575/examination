package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.User;
import org.upc.examination.mapper.UserMapper;
import org.upc.examination.service.UserService;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String id, String pwd) {
        return userMapper.login(id, pwd);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

}
