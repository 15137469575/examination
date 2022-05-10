package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;

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

    //智能阅卷
    /**
     * 首先要从answer_informantion表中选择出examId考试中的所有回答，以及要筛选出适合的题型
     *      然后使用examId来选择出paperId进而选择出这个试卷中的所有题目即questionId
     *      然后挑选这些questionId的正确答案
     *      然后，使用这些答案来匹配回答，比较对错，对score进行修改和插入
     * */
    List<AnswerInformantion> selectedAnswer(int examId);
    List<String> selectType(int examId);
    List<String> selectQuestion(int examId);
    Double selectGrade(int examId,int questionId);

}
