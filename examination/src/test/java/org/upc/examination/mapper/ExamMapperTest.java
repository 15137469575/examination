package org.upc.examination.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExamMapperTest {
    @Resource
    private ExamMapper examMapper;

    @Test
    void selectAllByStudent() {
        List e = examMapper.selectAllByStudent(1001);
        for(int i = 0;i<e.size();i++){
            System.out.println(e.get(i).toString());
        }
    }
}