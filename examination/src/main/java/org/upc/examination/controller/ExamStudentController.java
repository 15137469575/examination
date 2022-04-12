package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.service.ExamStudentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/examStudentConller")
public class ExamStudentController {
    @Resource
    private ExamStudentService examStudentService;
    /**
     * 接收前台传来的excel表格解析后的列表，并且返回插入几条数据。
     * **/
    @RequestMapping("/insert")
    int insert(int examId, List<Integer> studentIds) {
        int row = examStudentService.insert(examId, studentIds);
        return row;
    }
}
