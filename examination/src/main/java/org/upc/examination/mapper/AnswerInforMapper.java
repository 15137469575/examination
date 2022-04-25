package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.AnswerInformantion;
@Mapper
public interface AnswerInforMapper {

/*
* 当answerInformation 中的answer_id存在时，当执行此方法
* */
    int insert(AnswerInformantion answerInformantion);
    /*
     * 当answerInformation 中的answer_id是空时，当执行此方法
     * */
    int insert2(AnswerInformantion answerInformantion);
    /**
     *
     * */
    AnswerInformantion selectAnswerInformantion(int userId,int examId,int questionPaperId);

}
