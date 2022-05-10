package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Exam;
import org.upc.examination.entity.ExamAnswer;

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

/**
 * 通过examId、question_paper_Id和studentId来定位这名
 *
 * 想法：能不能通过前台的点击次数，来调用不同的接口，其中一个接口是第一次点击，只接收examId和questionId
 *                                          另一个方式是接收examId、questionId和studentId
 *                                          第二种方式最好是选择题也要在回答是空的时候也向后台传送数据
 *
 * */
    ExamAnswer selectQuestionIn(int examId, int questionId , int studentId);
    /**
     * 使用int examId,int questionId,int studentId来从表中是否有该名学生在该场考试中
     *      该题中是否有回答，如果没有，那么返回是空
     * */
    String selectAnswer(int examId,int questionId,int studentId);
    ExamAnswer  selectQuestionIn1(int examId, int questionId , int studentId);

    /**
     * 根据examId来查询出Exam对象
     * */
    Exam selectExamById(int examId);

    /**
     * 根据studentId来找出该学生所有的Exam对象
     * */
    List<Exam> selectAllByStudent(int studentId);



}
