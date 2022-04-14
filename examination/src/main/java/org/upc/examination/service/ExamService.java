package org.upc.examination.service;


import org.upc.examination.entity.Exam;

import java.util.List;

public interface ExamService {

    int insert(Exam exam);

    int countAll(int examId);

    List<Exam> selectQuestion(int examId);

    Exam selectQuestionIn(int examId,int questionId);
    /**
     * 根据examId来查询出Exam对象,用于向学生展示考试信息
     * */
    Exam selectExamById(int examId);
}
