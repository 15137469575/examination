package org.upc.examination.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/questionPaper")
public class QuestionPaperController {

    @Resource
    private QuestionPaperService questionPaperService;

    @RequestMapping("/insert")
    public int doInsert(QuestionPaper questionPaper){
        return questionPaperService.doInsert(questionPaper);
    }

/**
 * 根据paperId来筛选出同一个试卷中的所有题目，所以可以使用list
 * */
    @RequestMapping("/selectByPaperID")
    public PageInfo<QuestionPaper> selectByPaperID(int pageNum,int pageSize,int paperId){
        return questionPaperService.selectByPaperId(pageNum,pageSize,paperId);
    }
}
