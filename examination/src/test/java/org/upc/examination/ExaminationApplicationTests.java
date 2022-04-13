package org.upc.examination;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.mapper.UserMapper;

import javax.annotation.Resource;

@SpringBootTest
class ExaminationApplicationTests {

    @Resource
    private UserMapper userMapper;
    String path = "C:\\Users\\asus\\Desktop\\3.jpg";

    @Test
    void says(){
        System.out.println(path);
    }
}
