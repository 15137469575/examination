package org.upc.examination.service;


import org.upc.examination.entity.Exam;

import java.util.List;

public interface ExamService {

    int insert(Exam exam);

    int countAll(int examId);

    List<Exam> selectQuestion(int examId);
}
