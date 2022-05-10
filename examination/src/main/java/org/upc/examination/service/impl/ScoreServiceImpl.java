package org.upc.examination.service.impl;


import org.springframework.stereotype.Service;
import org.upc.examination.entity.AnswerInformantion;
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
        List<String> typeString = scoreMapper.selectedType(examId, studentId);
        List<AnswerInformantion> answerInformantionList1 = new LinkedList<AnswerInformantion>();
        for(int i = 0;i<answerInformantionList.size();i++){
            answerInformantionList.get(i).setType(typeString.get(i));
        }
        for(int j = 0;j<answerInformantionList.size();j++){
            String typeStr = answerInformantionList.get(j).getType();
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
}
