package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.Exam;
import org.upc.examination.mapper.ExamMapper;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamMapper examMapper;
    @Override
    public int insert(Exam exam) {
        if(exam.getExamId()==null){
            int row = examMapper.insert2(exam);
            return row;
        }else {
            int row = examMapper.insert(exam);
            return row;
        }
    }

    @Override
    public int countAll(int examId) {
        return examMapper.countAll(examId);
    }

    @Override
    public List<Exam> selectQuestion(int examId) {

        return examMapper.selectQuestion(examId);

    }
}
