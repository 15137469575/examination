package org.upc.examination.service.impl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.ExamStudent;
import org.upc.examination.mapper.AnswerInforMapper;
import org.upc.examination.mapper.ExamStudentMapper;
import org.upc.examination.service.AnswerInforService;

import javax.annotation.Resource;

@Service
public class AnswerInforServiceImpl implements AnswerInforService {
    @Resource
    private AnswerInforMapper answerInforMapper;
    @Resource
    private ExamStudentMapper examStudentMapper;
    /**
     * 插入考生回答内容
     * 首先检查数据表中是否有同一位考生在同一场考试的同一道试题是否已经存在
     *      如果不存在，那么执行插入操作
     *      如果存在，根据考生号、考试号和试题序号来执行更新操作
     * 当执行插入操作时：
     *      当answerInformantion的answer_Id是空时，执行insert2
     *                                非空时，执行insert
     * 当执行更新操作时：
     *      当同一个考生的同一场考试中的同一道题目有重复输入时，首先检查answerInformation中的answer
     *          内容是空时，那么对这条数据不执行任何操作
     *          当内容非空时，对这条数据执行更新操作
     * */
    @Override
    public void insert(AnswerInformantion answerInformantion) {
        /**
         * 根据前台传来的answerInformantion中的examId和studentId
         *      来更改exam_student中的examState为1
         *      表示：考生参加考试的状态
         * */
        ExamStudent examStudent = examStudentMapper.selectState(answerInformantion.getExamId(),answerInformantion.getUserId());
        if(examStudent.getExamState()==0){
            examStudentMapper.updateState(answerInformantion.getExamId(),answerInformantion.getUserId());
        }
        AnswerInformantion answerInformantion1 = new AnswerInformantion();
        answerInformantion1 = answerInforMapper.selectAnswerInformantion(answerInformantion.getUserId(),answerInformantion.getExamId(),answerInformantion.getQuestionPaperId());
        if(answerInformantion1 == null){
            if(answerInformantion.getAnswerId()==null){
                 answerInforMapper.insert2(answerInformantion);
            }else {
                answerInforMapper.insert(answerInformantion);
            }
        }else {
            if(answerInformantion.getAnswer()!=null){
                answerInforMapper.updateAnswerInformantion(answerInformantion);
            }

        }

    }

}
