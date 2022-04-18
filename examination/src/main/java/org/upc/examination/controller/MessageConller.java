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
    /**
     * 创建信息
     * 如果row是1，那么是创建成功
     * 如果row是0，那么是创建失败
     * */
    @RequestMapping("/insert")
    int insert(Message msg){
        int row = msgService.insert(msg);
        return row;
    }
    /**
     * 通过studentId来找出这个学生所能够查看的通知信息，会是一个List
     * */
    @RequestMapping("/selectByStudentId")
    List<String> selectByStudentId(int studentId){
        return msgService.selectByStudentId(studentId);
    }
}
