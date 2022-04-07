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
        for(Integer j:i){
            if(j==questionPaper.getQuestionId()){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public PageInfo<QuestionPaper> selectByPaperId(int pageNum, int pageSize, int paperId) {
        PageInfo<QuestionPaper> pages= null;

        PageHelper.startPage(pageNum, pageSize);
        List<QuestionPaper> questions = questionPaperMapper.selectByPaperId(paperId);

        pages = new PageInfo<>(questions,10);

        return pages;
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
