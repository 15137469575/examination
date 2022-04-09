package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Exam;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;

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

    @RequestMapping("/selectQuestion")
     public List<Integer> selectQuestion(int examId){
        return examService.selectQuestion(examId);
    }

}
