package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.*;

import java.util.List;

@Mapper
public interface ScoreMapper {

    int insert(Score score);
/**
 * 通过examId和studentId和question_来选择出这名学生在本次考试中的回答
 *      通过
 * */
    List<AnswerInformantion>  selectAnswer(int examId,int studentId);
    List<String> selectedType(int examId,int studentId);

    List<ScoreStudent> selectStudent(int examId);

    Double selectGradeByPaperId(int examId,int questionPaperId);

    //智能阅卷
    /**
     * 首先要从answer_informantion表中选择出examId考试中的所有回答，以及要筛选出适合的题型
     *      然后使用examId来选择出paperId进而选择出这个试卷中的所有题目即questionId
     *      然后挑选这些questionId的正确答案
     *      然后，使用这些答案来匹配回答，比较对错，对score进行修改和插入
     * */
    List<AnswerInformantion> selectedAnswer(int examId,int studentId);


    List<String> selectType(int examId);


    List<String> selectQuestion(int examId);


    List<QuestionBank> selectQuestionBank(int examId,int studentId);

    Double selectGrade(int examId,int questionId);

    Double selectSumOfScore(int examId,int studentId);

    //更新score表中的数据，主要是通过examId和studentId和questionPaperId来确定要更新的score
    //
    int updateScoreQuestionId(int examId,int studentId,int questionPaperId,Double score);

    int updateScore(int examId,int studentId,Double score);

    //通过examId,studentId,questionPaperId来选择出该名学生的分数

    Score selectAll(int examId,int studentId,int questionPaperId);

    Score selectSumScore(int examId,int studentId);

    /**
     * 向学生展示成绩功能实现
     * */
    List<ScoreToStudent> selectExamIdBySubject(String subject,int studentId);

    String selectTimeByExamID(int examId);

    Double selectScoreOfSum(int examId,int studentId);

    Integer selectState(int examId,int studentId);

    String selectTeacherName(int examId,int studentId);
}
