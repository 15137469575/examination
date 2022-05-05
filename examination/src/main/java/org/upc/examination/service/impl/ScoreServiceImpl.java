package org.upc.examination.service.impl;


import org.springframework.stereotype.Service;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;
import org.upc.examination.mapper.ScoreMapper;
import org.upc.examination.service.AnswerInforService;
import org.upc.examination.service.ScoreService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;
    @Override
    public int insert(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public List<AnswerInformantion> selectAnswer(int examId, int studentId) {
        return scoreMapper.selectAnswer(examId, studentId);
    }

    @Override
    public List<ScoreStudent> selectStudent(int examId) {
        return scoreMapper.selectStudent(examId);
    }
}
