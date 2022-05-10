package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.AnswerInformantion;
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

    List<ScoreStudent> selectStudent(int examId);

}
