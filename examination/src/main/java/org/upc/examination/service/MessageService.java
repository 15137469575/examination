package org.upc.examination.service;

import org.upc.examination.entity.Message;

import java.util.List;

public interface MessageService {

    int insert(Message msg);

    List<String> selectByStudentId(int studentId);
}
