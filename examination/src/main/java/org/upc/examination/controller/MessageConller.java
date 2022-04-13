package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Message;
import org.upc.examination.service.MessageService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageConller {
    @Resource
    private MessageService msgService;
    @RequestMapping("/insert")
    int insert(Message msg){
        int row = msgService.insert(msg);
        return row;
    }
    @RequestMapping("/selectByStudentId")
    List<String> selectByStudentId(int studentId){
        return msgService.selectByStudentId(studentId);
    }
}
