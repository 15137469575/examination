package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.Users;
import org.upc.examination.mapper.UserMapper;
import org.upc.examination.service.UserService;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Users login(String userId, String userPassword) {
        return userMapper.login(userId, userPassword);
    }

    @Override
    public int register(Users user) {
        return userMapper.register(user);
    }

}
