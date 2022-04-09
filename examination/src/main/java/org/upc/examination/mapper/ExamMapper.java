package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Exam;

import java.util.List;

@Mapper
public interface ExamMapper {
/**
 * 用于插入完整的对象
 *
 */

    int insert(Exam exam);
    /**
     * 用于插入除去examId的对象
     */

    int insert2(Exam exam);
    /**
     * 查询一个考试中的试卷中的题目数量
     */
    int countAll(int examId);

    List<Integer> selectQuestion(int examId);
}
