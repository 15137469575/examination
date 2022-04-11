package org.upc.examination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Exam;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Resource
    private ExamService examService;

    @RequestMapping("/insert")
    int insert(Exam exam){
        return examService.insert(exam);
    }

    @RequestMapping("/countAll")
    public int countAll(int examId){
        return examService.countAll(examId);
    }

    @RequestMapping("/selectQuestSort")
    //public List<Integer> selectQuestSort(int examId){
    public int selectQuestSort(int examId){
        //List<Exam> row = examService.selectQuestion(examId);
        //List<Integer> list = new ArrayList<Integer>();

        //for(int i= 0;i<row.size();i++){
            //list.add(row.get(i).getQuestionPaper().getQuestionPaperSort()) ;
        //}

        //return list;
        return examId;
    }
    @RequestMapping("/selectQuestionIn")
    public Exam selectQuestionIn(int examId,int questionId){
        return examService.selectQuestionIn(examId, questionId);
    }

}
