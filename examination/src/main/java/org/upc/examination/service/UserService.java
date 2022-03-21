package org.upc.examination.service;

import org.upc.examination.entity.Users;

public interface UserService {

    Users login(int id, String pwd);

    int register(Users user);

}
