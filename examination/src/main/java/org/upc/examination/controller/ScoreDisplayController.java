package org.upc.examination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upc.examination.service.ScoreDisplayService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author asus
 */
@RestController
@RequestMapping("/scoreDisplay")
public class ScoreDisplayController {

    @Resource
    private ScoreDisplayService scoreDisplayService;

    @RequestMapping("/getAllScores")
    public List<Double> getAllScores(int examId){
        return scoreDisplayService.getAllScores(examId);
    }

}
