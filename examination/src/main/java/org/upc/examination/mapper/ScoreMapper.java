package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;

import java.util.List;

@Mapper
public interface ScoreMapper {

    int insert(Score score);

    List<AnswerInformantion>  selectAnswer(int examId,int studentId);

    List<ScoreStudent> selectStudent(int examId);

}
