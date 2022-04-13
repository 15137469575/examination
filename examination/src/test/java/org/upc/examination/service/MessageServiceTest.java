package org.upc.examination.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.entity.Message;
import org.upc.examination.mapper.MessageMapper;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MessageServiceTest {

    @Resource
    private MessageMapper messageMapper;

    @Test
    void insert() {
        Message message = new Message();
        message.setExamId(103);
        message.setMsg("hello");
        int row = messageMapper.insert(message);
        System.out.println(row);
    }
}