package org.upc.examination.service.impl;


import org.springframework.stereotype.Service;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;
import org.upc.examination.mapper.ScoreMapper;
import org.upc.examination.service.AnswerInforService;
import org.upc.examination.service.ScoreService;

import javax.annotation.Resource;
import java.util.LinkedList;
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
        List<AnswerInformantion> answerInformantionList =  scoreMapper.selectAnswer(examId, studentId);
        //List<String> typeString = scoreMapper.selectedType(examId, studentId);
        List<QuestionBank> questionBankLists = scoreMapper.selectQuestionBank(examId, studentId);
        List<AnswerInformantion> answerInformantionList1 = new LinkedList<AnswerInformantion>();
        for(int i = 0;i<answerInformantionList.size();i++){
            answerInformantionList.get(i).setQuestionBank(questionBankLists.get(i));
        }
        for(int j = 0;j<answerInformantionList.size();j++){
            String typeStr = answerInformantionList.get(j).getQuestionBank().getType();
            if(!typeStr.equals("单选") && !typeStr.equals("多选") && !typeStr.equals("判断")){
                answerInformantionList1.add(answerInformantionList.get(j));
            }
        }
        /**
         * 两个列表已经回合在一起，接下来要做的工作是将answerInformantionList列表中非人工阅卷的内容给删除掉
         * 已经完成智能阅卷的功能
         * */
        return answerInformantionList;
    }

    @Override
    public List<ScoreStudent> selectStudent(int examId) {
        return scoreMapper.selectStudent(examId);
    }

    @Override
    public Double intelligent(int examId,int studentId) {
        List<AnswerInformantion> answerInformantionList = scoreMapper.selectedAnswer(examId,studentId);
        //List<String> stringType = scoreMapper.selectType(examId);
        //List<String> stringAnswer = scoreMapper.selectQuestion(examId);
        List<QuestionBank> questionBankList = scoreMapper.selectQuestionBank(examId, studentId);
        List<AnswerInformantion> answerInformantionList1 = new LinkedList<>();
        for(int i = 0; i < answerInformantionList.size();i++ ){
            //answerInformantionList.get(i).setType(stringType.get(i));
            //answerInformantionList.get(i).setCorrectAnswer(stringAnswer.get(i));
            answerInformantionList.get(i).setQuestionBank(questionBankList.get(i));
        }
        for(int j = 0;j < answerInformantionList.size();j++){
            String stringType1 = answerInformantionList.get(j).getQuestionBank().getType();
            if(stringType1.equals("单选") || stringType1.equals("多选") || stringType1.equals("判断")){
                answerInformantionList1.add(answerInformantionList.get(j));
            }
        }

        for(int k = 0;k < answerInformantionList1.size();k++){
            AnswerInformantion answerInformantion = answerInformantionList1.get(k);

            Score score1 = new Score();
            score1.setUserId(answerInformantion.getUserId());
            score1.setExamId(answerInformantion.getExamId());
            score1.setQuestionPaperId(answerInformantion.getQuestionPaperId());

            String correctAnswer = answerInformantion.getQuestionBank().getAnswer();
            String answer = answerInformantion.getAnswer();
            if(answer.equals(correctAnswer)){
                Double gradeDouble = scoreMapper.selectGrade(answerInformantion.getExamId(),answerInformantion.getQuestionPaperId());
                score1.setScore(gradeDouble);
                score1.setState(1);
            }else {
                score1.setScore(0.0);
                score1.setState(0);
            }
            scoreMapper.insert(score1);
        }
        /**
         * 实现获取在该场考试中该名考生所有客观题的总成绩
         * */
        Double sumOfScore = scoreMapper.selectSumOfScore(examId,studentId);
        Score sumScore = new Score();
        sumScore.setExamId(examId);
        sumScore.setUserId(studentId);
        sumScore.setScore(sumOfScore);
        sumScore.setState(1);
        scoreMapper.insert(sumScore);
        return sumOfScore;



    }
}
