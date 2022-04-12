package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.ExamStudent;

import java.util.List;

@Mapper
public interface ExamStudentMapper {

    int insert(ExamStudent examStudent);
}
