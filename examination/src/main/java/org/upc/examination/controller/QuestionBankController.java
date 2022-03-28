package org.upc.examination.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.service.QuestionBankService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/question")
public class QuestionBankController {

    @Resource
    private QuestionBankService questionBankService;

    @GetMapping("/add")
    public int add(QuestionBank questionBank){
        return questionBankService.doInsert(questionBank);
    }

    @GetMapping("/findById")
    public QuestionBank findById(int index){
        return questionBankService.doQueryById(index);
    }

    @GetMapping("/findByObject")
    public PageInfo<QuestionBank> findByObject(String object, int pageNum, int pageSize){
        return questionBankService.doQuery(object,pageNum,pageSize);
    }

    @GetMapping("/findByType")
    public PageInfo<QuestionBank> findByType(String type, int pageNum, int pageSize){
        return questionBankService.doQueryByType(type,pageNum,pageSize);
    }

    @GetMapping("/update")
    public int update(QuestionBank questionBank){
        return questionBankService.update(questionBank);
    }

    @GetMapping("/delete")
    public int delete(int index){
        return questionBankService.doDelete(index);
    }

    @GetMapping("deleteArray")
    public int deleteArray(int[] list){
        return questionBankService.deDeleteArray(list);
    }

    @GetMapping("/findByObjectAndType")
    public PageInfo<QuestionBank> findByObjectAndType(String object,String type,int pageNum,int pageSize){
        return questionBankService.doQueryByObjectAndType(object, type, pageNum, pageSize);
    }

}
