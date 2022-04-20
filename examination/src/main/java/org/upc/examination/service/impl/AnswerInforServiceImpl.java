package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.mapper.AnswerInforMapper;
import org.upc.examination.service.AnswerInforService;

import javax.annotation.Resource;

@Service
public class AnswerInforServiceImpl implements AnswerInforService {
    @Resource
    private AnswerInforMapper answerInforMapper;
    @Override
    public int insert(AnswerInformantion answerInformantion) {
        if(answerInformantion.getAnswerId()==null){
            return answerInforMapper.insert2(answerInformantion);
        }else {
            return answerInforMapper.insert(answerInformantion);
        }
    }
}
