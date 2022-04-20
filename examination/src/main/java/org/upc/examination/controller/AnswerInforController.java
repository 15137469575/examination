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
    @RequestMapping("/insert")
    public void insert(AnswerInformantion answerInformantion){
        answerInforService.insert(answerInformantion);
    }
}
