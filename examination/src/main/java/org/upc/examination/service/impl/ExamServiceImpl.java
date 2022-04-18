package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.Exam;
import org.upc.examination.mapper.ExamMapper;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.undefined;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamMapper examMapper;

    /**
     * 执行插入操作，如果前台传入的exam对象中的examId是null，那么执行if(……){……},
     *              反之，执行else{……}，
     * 返回值都是exam对象的examId
     * */
    @Override
    public int insert(Exam exam) {


        if(exam.getExamId()==null){
            int row = examMapper.insert2(exam);
            return exam.getExamId();
        }else {
            int row = examMapper.insert(exam);
            return exam.getExamId();
        }
    }
/**
 * 找出一个考试中的试卷中的题目总量
 *
 * 已弃用
 * */
    @Override
    public int countAll(int examId) {
        return examMapper.countAll(examId);
    }
    /**
     * 通过一个examId来筛选出一个试卷中所有题目的题号（是指在数据库中保存的question_paper_sort）,
     *      * 返回值是一个List列表
     *      * 是无序的
     * */
    @Override
    public List<Exam> selectQuestion(int examId) {

        return examMapper.selectQuestion(examId);

    }
    /**
     * 通过examId和questId来筛选出和四个选项和题目类型
     *       返回值是Exam，是因为在Exam中设置了questionBank的属性
     * */
    @Override
    public Exam selectQuestionIn(int examId, int questionId) {
        Exam exam = examMapper.selectQuestionIn(examId, questionId);
        return exam;
    }
    /**
     * 根据examId来查询出Exam对象
     * */
    @Override
    public Exam selectExamById(int examId) {
        return examMapper.selectExamById(examId);
    }

    @Override
    public List<Exam> selectAllByStudent(int studentId) {
        return examMapper.selectAllByStudent(studentId);
    }
}
