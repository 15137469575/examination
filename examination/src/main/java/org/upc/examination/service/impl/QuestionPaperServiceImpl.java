package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.mapper.QuestionPaperMapper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;

@Service
public class QuestionPaperServiceImpl implements QuestionPaperService {

    @Resource
    private QuestionPaperMapper questionPaperMapper;

    @Override
    public int doInsert(QuestionPaper questionPaper) {
        return questionPaperMapper.insert(questionPaper);
    }
}
