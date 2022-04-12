package org.upc.examination.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.entity.ExamStudent;

import javax.annotation.Resource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExamStudentServiceTest {
    @Resource
    private ExamStudentService examStudentService;

    @Test
    void insert() {
        List<Integer> integers = new LinkedList<Integer>();
        integers.add(1004);
        integers.add(1005);
        integers.add(1006);
        int row = examStudentService.insert(103,integers);
        System.out.println(row);
    }
}