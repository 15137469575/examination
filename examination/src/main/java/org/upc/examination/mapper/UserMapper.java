package org.upc.examination.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Users;

@Mapper
public interface UserMapper {

    Users login(int userId, String userPassword);

    int register(Users user);

}
