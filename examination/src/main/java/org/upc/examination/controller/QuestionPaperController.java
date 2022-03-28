package org.upc.examination.controller;

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

}
