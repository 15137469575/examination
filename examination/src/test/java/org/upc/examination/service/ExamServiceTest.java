package org.upc.examination.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.entity.Exam;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExamServiceTest {
    @Resource
    private ExamService examService;

    @Test
    void selectAllByStudent() {
        List<Exam> examList = examService.selectAllByStudent(1001);
        for(int i = 0;i<examList.size();i++){
            System.out.println(examList.get(i).toString());
        }
    }
}