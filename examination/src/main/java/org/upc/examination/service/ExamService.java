package org.upc.examination.service;


import org.upc.examination.entity.Exam;

import java.util.List;

public interface ExamService {

    /**
     * 执行插入操作，如果前台传入的exam对象中的examId是null，那么执行if(……){……},
     *              反之，执行else{……}，
     * 返回值都是exam对象的examId
     * */
    int insert(Exam exam);
    /**
     * 找出一个考试中的试卷中的题目总量
     *
     * 已弃用
     * */
    int countAll(int examId);
    /**
     * 通过一个examId来筛选出一个试卷中所有题目的题号（是指在数据库中保存的question_paper_sort）,
     *      * 返回值是一个List列表
     *      * 是无序的
     * */
    List<Exam> selectQuestion(int examId);
    /**
     * 通过examId和questId来筛选出和四个选项和题目类型
     *       返回值是Exam，是因为在Exam中设置了questionBank的属性
     * */
    Exam selectQuestionIn(int examId,int questionId);
    /**
     * 根据examId来查询出Exam对象,用于向学生展示考试信息
     * */
    Exam selectExamById(int examId);

    List<Exam> selectAllByStudent(int studentId);
}
