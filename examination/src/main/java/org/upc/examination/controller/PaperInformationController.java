package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.entity.PaperInformation;
import org.upc.examination.service.PaperInformationService;

import javax.annotation.Resource;


@RestController
@RequestMapping("/paperInformation")
public class PaperInformationController {

    @Resource
    private PaperInformationService paperInformationService;

    /**
     * 插入试卷信息，创建信息
     * 返回值是paperId
     * */
    @RequestMapping("/insert")
    public int doInsert(PaperInformation paperInformation){
        return paperInformationService.doInsert(paperInformation);
        //return 1;
    }
/**
 * 通过一个试卷Id,来获得该Id的试卷信息
 * */
    @RequestMapping("/selectById")
    public PaperInformation selectByID(int index){
        return paperInformationService.selectById(index);
    }
}
