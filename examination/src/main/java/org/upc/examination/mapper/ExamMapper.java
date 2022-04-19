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
/**
 * 通过一个examId来筛选出一个试卷中所有题目的题号（是指在数据库中保存的question_paper_sort）,
 *      * 返回值是一个List列表
 *      * 是无序的
 * */
    List<Integer> selectQuestion(int examId);
/**
 * 通过examId和questId来筛选出和四个选项和题目类型
 *       返回值是Exam，是因为在Exam中设置了questionBank的属性
 * */
    Exam selectQuestionIn(int examId,int questionId);
    /**
     * 根据examId来查询出Exam对象
     * */
    Exam selectExamById(int examId);

    /**
     * 根据studentId来找出该学生所有的Exam对象
     * */
    List<Exam> selectAllByStudent(int studentId);


}
