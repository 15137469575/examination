package org.upc.examination.service;

import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;

import java.util.List;

public interface ScoreService {

    int insert(Score score);

    List<AnswerInformantion> selectAnswer(int examId, int studentId);

    List<ScoreStudent> selectStudent(int examId);
}
