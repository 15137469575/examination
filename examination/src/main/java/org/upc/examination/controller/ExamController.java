package org.upc.examination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.Exam;
import org.upc.examination.service.ExamService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Resource
    private ExamService examService;
/**
 * 从前台接收创建的Exam对象，并且将对象保存在数据库中
 * */
    @RequestMapping("/insert")
    int insert(Exam exam){
        return examService.insert(exam);
    }

    /**
     * 输入值是examId，通过一个examId来筛选出一个试卷中的题目数量
     * 返回值是一个int的数值
     * 已弃用
     * **/
    @RequestMapping("/countAll")
    public int countAll(int examId){
        return examService.countAll(examId);
    }

    /**
     * 通过一个examId来筛选出一个试卷中所有题目的题号（是指在数据库中保存的question_paper_sort）,
     * 返回值是一个List列表
     * 是无序的
     * **/
    @RequestMapping("/selectQuestSort")
    public List<Integer> selectQuestSort(int examId){

        List<Exam> row = examService.selectQuestion(examId);
        List<Integer> list = new ArrayList<Integer>();

        for(int i= 0;i<row.size();i++){
            list.add(row.get(i).getQuestionPaper().getQuestionPaperSort()) ;
        }

        return list;

    }
    /**
     * 通过examId和questId来筛选出和四个选项和题目类型
     * 返回值是Exam，是因为在Exam中设置了questionBank的属性
     * **/
    @RequestMapping("/selectQuestionIn")
    public Exam selectQuestionIn(int examId,int questionId){
        return examService.selectQuestionIn(examId, questionId);
    }

    /**
     * 和下面的selectExamById()配套，实现考试发布功能
     * 考试发布：教师选择考试发布
     * */
    //@RequestMapping("/reselve")
    //public void reselve(int examId){
      //   int temp = examId;
    //}
    /**
     * 根据examId来查询出Exam对象,用于向学生展示考试信息
     * */
    @RequestMapping("/selectExamById")
    public Exam selectExamById(int examId){

        return examService.selectExamById(examId);
    }


    @RequestMapping("/selectAllByStudent")
    public List<Exam> selectAllByStudent(int studentId){
        return examService.selectAllByStudent(studentId);
    }
}
