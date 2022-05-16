package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.mapper.ScoreDisplayMapper;
import org.upc.examination.service.ScoreDisplayService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author asus
 */
@Service
public class ScoreDisplayServiceImpl implements ScoreDisplayService {
    @Resource
    private ScoreDisplayMapper scoreDisplayMapper;

    @Override
    public List<Double> getAllScores(int examId) {
        List<Integer> studentIds = scoreDisplayMapper.queryAllStudent(examId);
        List<Double> scores = scoreDisplayMapper.queryAllScore(studentIds,examId);
        return scores;
    }
}
