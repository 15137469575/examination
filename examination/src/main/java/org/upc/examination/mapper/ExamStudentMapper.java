package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.ExamStudent;

import java.util.List;

@Mapper
public interface ExamStudentMapper {
/**
 * 插入一个examStudent对象，
 * */
    int insert(ExamStudent examStudent);

    void updateState(int examId,int studentId);
    ExamStudent selectState(int examId,int studentId);
}
