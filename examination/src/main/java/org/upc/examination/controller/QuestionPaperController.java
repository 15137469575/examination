package org.upc.examination.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/questionPaper")
public class QuestionPaperController {

    @Resource
    private QuestionPaperService questionPaperService;

    @RequestMapping("/insert")
    public int doInsert(QuestionPaper questionPaper){
        return questionPaperService.doInsert(questionPaper);
    }


    @RequestMapping("/selectByPaperID")
    public PageInfo<QuestionPaper> selectByPaperID(int pageNUm,int pageSize,int paperId){
        return questionPaperService.selectByPaperId(pageNUm, pageSize, paperId);
    }
}
