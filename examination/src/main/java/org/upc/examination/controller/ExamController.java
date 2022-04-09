package org.upc.examination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Exam;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
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
    public List<Exam> selectQuestSort(int examId){
        return examService.selectQuestion(examId);
    }

}
