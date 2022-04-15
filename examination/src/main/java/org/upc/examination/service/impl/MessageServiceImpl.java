package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.Message;
import org.upc.examination.mapper.MessageMapper;
import org.upc.examination.service.MessageService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper msgMapper;

/**
 * 插入通知信息
 * 返回值大概是插入的数量
 * */
    @Override
    public int insert(Message msg) {
        int row = msgMapper.insert(msg);
        return row;
    }
    /**
     * 通过studentId来找出这个学生所能够查看的通知信息，会是一个List
     * */
    @Override
    public List<String> selectByStudentId(int studentId) {
        List<String> msgs = msgMapper.selectByStudentId(studentId);
        return msgs;
    }

}
