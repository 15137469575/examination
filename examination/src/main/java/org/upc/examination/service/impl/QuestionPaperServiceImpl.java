package org.upc.examination.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.mapper.QuestionPaperMapper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionPaperServiceImpl implements QuestionPaperService {

    @Resource
    private QuestionPaperMapper questionPaperMapper;

    @Override
    public int doInsert(QuestionPaper questionPaper) {
        List<Integer> i = questionPaperMapper.isSame(questionPaper.getPaperId());


        for(int j = 0;j<i.size();j ++){
            if(questionPaper.getQuestionId() == i.get(j)){
                return 0;
            }

        }
        questionPaperMapper.insert(questionPaper);
        return 1;
    }

    @Override
    public List<QuestionPaper> selectByPaperId( int paperId) {
        List<QuestionPaper> questions = questionPaperMapper.selectByPaperId(paperId);



        return questions;
    }

    @Override
    public int randomInsert(int paperId,String subject) {
        List<Integer> ques = questionPaperMapper.randomSelectFromBank(subject);
        QuestionPaper questionPaper = new QuestionPaper();
        for(int i = 0;i<ques.size();i++){
            questionPaper.setQuestionId(ques.get(i));
            questionPaper.setPaperId(paperId);
            questionPaperMapper.insert(questionPaper);
        }
        return 1;
    }


}
