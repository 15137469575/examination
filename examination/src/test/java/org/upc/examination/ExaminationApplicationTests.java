package org.upc.examination;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.entity.User;
import org.upc.examination.mapper.UserMapper;
import org.upc.examination.utils.MD5;

import javax.annotation.Resource;

@SpringBootTest
class ExaminationApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        User user = userMapper.login("123456", "123456");

        System.out.println(user.getRole());

    }

    @Test
    void MD(){
        String str1 = "1561";
        String str2 = "";
        String str3 = null;

        System.out.println(MD5.encrypt(str1) + "\n" + MD5.encrypt(str2) + "\n" + MD5.encrypt(str3));
    }

}
