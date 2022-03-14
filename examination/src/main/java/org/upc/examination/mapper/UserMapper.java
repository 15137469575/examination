package org.upc.examination.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.User;

@Mapper
public interface UserMapper {

    User login(String id,String pwd);

    int register(User user);

}
