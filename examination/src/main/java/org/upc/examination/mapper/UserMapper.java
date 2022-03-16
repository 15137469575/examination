package org.upc.examination.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Users;

@Mapper
public interface UserMapper {

    Users login(String id, String pwd);

    int register(Users user);

}
