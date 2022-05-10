package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.entity.Score;
import org.upc.examination.entity.ScoreStudent;
import org.upc.examination.service.ScoreService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;
    /**
     * 传入参数有：
     *          userId:学生学号
     *          examId:考试序号
     *          questionPaperId:试卷中的题号
     *          score:分数
     *          state:题目状态，即表示题目对与错，用0和1表示，0表示题目回答错误，1表示题目回答正确
     *          teacherId:阅卷教师号，
     *          remark:备注，阅卷教师可在此备注框中写下错误原因
     * */
    @RequestMapping("/insert")
    int insert(Score score){
        return scoreService.insert(score);
    }
    /**
     * 根据examId和studentId来选择出一场考试中一名考生的所有回答
     * */
    @RequestMapping("/selectAnswer")
    public List<AnswerInformantion> selectAnswer(int examId, int studentId) {
        return scoreService.selectAnswer(examId, studentId);
    }
    /**
     * 通过此方法可以实现返回：studentId\studentName\和考生参加考试状态
     * */
    @RequestMapping("/selectStudent")
    public List<ScoreStudent> selectStudent(int examId) {
        return scoreService.selectStudent(examId);
    }
    //智能阅卷，需要一个examId参数
    @RequestMapping("/intelligent")
    public void intelligent(int examId){
        scoreService.intelligent(examId);
    }
}
