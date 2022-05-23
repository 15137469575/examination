package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.QuestionPaper;

import java.util.List;

public interface QuestionPaperService {
    /**
     * 首先，先找出从前台传来的questionPaper中的paperId中的questionId，
     * 然后比较从前台传来的questionPaper中的questionId是否有重复的，
     * 如果有重复的那么直接返回0
     * 否则返回1
     *
     * */
    int doInsert(QuestionPaper questionPaper);

/**
 * 根据paperId来筛选出题目，
 * */
    List<QuestionPaper> selectByPaperId( int paperId);
    /**
     * 智能组卷，
     * */
    int randomInsert(int paperId,String subject);

    /**
     * 添加试题功能的实现
     * */
    QuestionPaper insertGrade(int questionPaperId,Double grade);
}
