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
    @RequestMapping("/insert")
    public int doInsert(PaperInformation paperInformation){
        return paperInformationService.doInsert(paperInformation);
        //return 1;
    }

    @RequestMapping("/selectById")
    public PaperInformation selectByID(int index){
        return paperInformationService.selectById(index);
    }
}
