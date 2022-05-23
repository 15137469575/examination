package org.upc.examination.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.QuestionPaper;
import org.upc.examination.service.QuestionPaperService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questionPaper")
public class QuestionPaperController {

    @Resource
    private QuestionPaperService questionPaperService;
/**
 * 接收前端传来的对象，并保存为QuestionPaper，在此操作中，会实现检查数据库中是否有已重复的题目存在，若存在
 * 则返回0，若不存在，则返回1.
 * */
    @RequestMapping("/insert")
    public int doInsert(QuestionPaper questionPaper){
        return questionPaperService.doInsert(questionPaper);
    }

/**
 * 根据paperId来筛选出同一个试卷中的所有题目，所以可以使用list
 * */
    @RequestMapping("/selectByPaperID")
    public List<QuestionPaper> selectByPaperID(int paperId){
        return questionPaperService.selectByPaperId(paperId);
    }
    /**
     * 智能组卷功能
     * 返回值1，表示组卷成功
     * 返回值0，表示组卷失败
     * */
    @RequestMapping("/random")
    public int randomPaper(String subject,Integer paperId){
        int row =  questionPaperService.randomInsert(paperId,subject);
        if(row == 1){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 插入分数的功能
     *获取questionPaperId和grade
     *
     * */
    @RequestMapping("/insertGrade")
    public QuestionPaper insertGrade(int questionPaperId,Double grade){
        return questionPaperService.insertGrade(questionPaperId, grade);
    }
}
