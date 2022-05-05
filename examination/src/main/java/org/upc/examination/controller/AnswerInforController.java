package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.AnswerInformantion;
import org.upc.examination.service.AnswerInforService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/answerInformation")
public class AnswerInforController {
    @Resource
    private AnswerInforService answerInforService;
    /**
     * 插入考生回答内容
     * 首先检查数据表中是否有同一位考生在同一场考试的同一道试题是否已经存在
     *      如果不存在，那么执行插入操作
     *      如果存在，根据考生号、考试号和试题序号来执行更新操作
     * 当执行插入操作时：
     *      当answerInformantion的answer_Id是空时，执行insert2
     *                                非空时，执行insert
     * 当执行更新操作时：
     *      当同一个考生的同一场考试中的同一道题目有重复输入时，首先检查answerInformation中的answer
     *          内容是空时，那么对这条数据不执行任何操作
     *          当内容非空时，对这条数据执行更新操作
     * */
    @RequestMapping("/insert")
    public void insert(AnswerInformantion answerInformantion){
        answerInforService.insert(answerInformantion);
    }


}
