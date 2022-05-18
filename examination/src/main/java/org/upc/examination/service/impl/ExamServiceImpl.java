package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.Exam;
import org.upc.examination.entity.ExamAnswer;
import org.upc.examination.mapper.ExamMapper;
import org.upc.examination.service.ExamService;
import org.upc.examination.utils.TimeFormat;

import javax.annotation.Resource;
import java.util.List;

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
        TimeFormat timeFormat = new TimeFormat();
        String strings = timeFormat.TimeConvert(exam.getExamTime());
        exam.setExamTime(strings);

        if(exam.getExamId()==null){
            examMapper.insert2(exam);
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
    public List<Integer> selectQuestion(int examId) {

        return examMapper.selectQuestion(examId);
    }
    /**
     * 通过examId和questId来筛选出和四个选项和题目类型
     *       返回值是Exam，是因为在Exam中设置了questionBank的属性
     * */
    @Override
    public ExamAnswer selectQuestionIn(int examId, int questionId, int studentId) {
        String string = examMapper.selectAnswer(examId, questionId, studentId);
        ExamAnswer examAnswer = new ExamAnswer();
        if(string == null){
            examAnswer = examMapper.selectQuestionIn1(examId, questionId, studentId);
        }else {
            examAnswer = examMapper.selectQuestionIn(examId, questionId, studentId);
        }
        return examAnswer;
    }
    /**
     * 根据examId来查询出Exam对象
     * */
    @Override
    public Exam selectExamById(int examId) {
        Exam exam = examMapper.selectExamById(examId);
        TimeFormat timeFormat = new TimeFormat();
        String string = timeFormat.TimeConvert(exam.getExamTime());
        exam.setExamTime(string);
        return exam;
    }

    @Override
    public List<Exam> selectAllByStudent(int studentId) {
        List<Exam> examList = examMapper.selectAllByStudent(studentId);
        for(int i = 0;i<examList.size();i++){
            TimeFormat timeFormat = new TimeFormat();
            String timeStr =  examList.get(i).getExamTime();
            String stringEntry = examList.get(i).getLimTimeEntry();
            String stringSub = examList.get(i).getLimTimeSub();
             String timeFormatStr = timeFormat.TimeConvert(timeStr);
             String entryFormatStr = timeFormat.TimeConvert(stringEntry);
            String subFormatStr = timeFormat.TimeConvert(stringSub);
            examList.get(i).setExamTime(timeFormatStr);
            examList.get(i).setLimTimeEntry(entryFormatStr);
            examList.get(i).setLimTimeSub(subFormatStr);
        }
        return examList;
    }

}
