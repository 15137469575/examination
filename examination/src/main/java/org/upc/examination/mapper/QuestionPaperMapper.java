package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.PaperInformation;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.entity.QuestionPaper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionPaperMapper {


    int insert(QuestionPaper questionPaper);

    /**
     * 根据试卷序号来选择题目
     * */
    List<QuestionPaper> selectByPaperId(int index);
/**
 * 通过一个paperId来筛选出该试卷中中的questionId
 * */
    List<Integer>  isSame(int paperId);
/**
 * 智能组卷，限定量是20
 * */
    List<Integer> randomSelectFromBank(String subject);




}
