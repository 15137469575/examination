package org.upc.examination;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.mapper.UserMapper;

import javax.annotation.Resource;

@SpringBootTest
class ExaminationApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void says(){
        QuestionBank questionBank = new QuestionBank();
        System.out.println(questionBank.getOptionB());
    }
}
