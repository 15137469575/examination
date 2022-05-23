package org.upc.examination.service.impl;


import org.springframework.stereotype.Service;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.mapper.QuestionPaperMapper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionPaperServiceImpl implements QuestionPaperService {

    @Resource
    private QuestionPaperMapper questionPaperMapper;
/**
 * 首先，先找出从前台传来的questionPaper中的paperId中的questionId，
 * 然后比较从前台传来的questionPaper中的questionId是否有重复的，
 * 如果有重复的那么直接返回0
 * 否则返回1
 *
 * */
    @Override
    public int doInsert(QuestionPaper questionPaper) {
        List<Integer> i = questionPaperMapper.isSame(questionPaper.getPaperId());
        for(int j = 0;j<i.size();j ++){
            if(questionPaper.getQuestionId().equals(i.get(j))){
                return 0;
            }
        }
        List<Integer> questionPaperSorted = questionPaperMapper.selectQuestionPaperSortList(questionPaper.getPaperId());


        questionPaperMapper.insert(questionPaper);
        int sort = 0;
        QuestionPaper questionPaper1 = questionPaperMapper.selectQuestionPaper(questionPaper.getQuestionPaperId());
        if(questionPaperSorted.size() == 0){
            sort = 1;
            questionPaperMapper.updateQuestionPaperSortInt(questionPaper1.getQuestionPaperId(),sort);
        }else {
            Integer temp = questionPaperSorted.get(0);
            sort = temp+1;
            questionPaperMapper.updateQuestionPaperSortInt(questionPaper1.getQuestionPaperId(),sort);
        }
        return 1;
    }

    @Override
    public List<QuestionPaper> selectByPaperId( int paperId) {
        List<QuestionPaper> questions = questionPaperMapper.selectByPaperId(paperId);

        return questions;
    }
/**
 * 智能组卷，
 * */
    @Override
    public int randomInsert(int paperId,String subject) {
        List<Integer> ques = questionPaperMapper.randomSelectFromBank(subject);
        QuestionPaper questionPaper = new QuestionPaper();
        for(int i = 0;i<ques.size();i++){
            questionPaper.setQuestionId(ques.get(i));
            questionPaper.setPaperId(paperId);
            questionPaper.setQuestionPaperSort(i+1);
            questionPaperMapper.insert(questionPaper);
        }
        return 1;
    }

    @Override
    public QuestionPaper insertGrade(int questionPaperId, Double grade) {
        questionPaperMapper.updateGradeByQuestionPaperIdInt(questionPaperId, grade);
        return questionPaperMapper.selectQuestionPaper(questionPaperId);

    }


}
