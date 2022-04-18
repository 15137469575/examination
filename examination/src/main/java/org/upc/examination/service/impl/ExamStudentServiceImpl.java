package org.upc.examination.service.impl;

import org.springframework.stereotype.Service;
import org.upc.examination.entity.ExamStudent;
import org.upc.examination.mapper.ExamStudentMapper;
import org.upc.examination.service.ExamStudentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class ExamStudentServiceImpl implements ExamStudentService {
    @Resource
    private ExamStudentMapper examStudentMapper;
/**
 * 根据前台传来的examId和一个Integer类型的List的studentIds
 * 返回值是学生数量
 * */
    @Override
    public int insert(int examId, List<Integer> studentIds) {
        int count = 0;
        ExamStudent examStudent = new ExamStudent();
        examStudent.setExamId(examId);
        for(int i = 0;i < studentIds.size();i++){
            examStudent.setStudentId(studentIds.get(i));
            int row = examStudentMapper.insert(examStudent);
            if(row == 1){
                count++;
            }
        }
        return count;
    }
}
