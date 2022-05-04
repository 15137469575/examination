package org.upc.examination.service;

import org.upc.examination.entity.Message;

import java.util.List;

public interface MessageService {
    /**
     * 插入通知信息
     * 返回值大概是插入的数量
     * */
    int insert(Message msg);
    /**
     * 通过studentId来找出这个学生所能够查看的通知信息，会是一个List
     * */
    List<String> selectByStudentId(int studentId);
}
