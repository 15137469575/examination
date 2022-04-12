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


    @Override
    public int insert(Message msg) {
        int row = msgMapper.insert(msg);
        return row;
    }

    @Override
    public List<String> selectByStudentId(int studentId) {
        List<String> msgs = msgMapper.selectByStudentId(studentId);
        return msgs;
    }

}
