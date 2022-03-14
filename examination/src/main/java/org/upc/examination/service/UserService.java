package org.upc.examination.service;
import org.upc.examination.entity.User;

public interface UserService {

    User login(String id, String pwd);

    int register(User user);

}
