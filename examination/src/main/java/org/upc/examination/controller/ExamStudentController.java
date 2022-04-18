package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.ExamStudent;
import org.upc.examination.entity.ExamStudents;
import org.upc.examination.service.ExamStudentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/examStudentConller")
public class ExamStudentController {
    @Resource
    private ExamStudentService examStudentService;
    /**
     * 接收前台传来的excel表格解析后的列表，并且返回学生的数量。
     * **/
    @RequestMapping("/insert")
    int insert(ExamStudents examStudents) {

        int row = examStudentService.insert(examStudents.getExamId(), examStudents.getStudentId());

        return row;
    }
}
