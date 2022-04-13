package org.upc.examination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.service.UserFaceInfoService;


@RestController
@RequestMapping("/face")
public class FaceController {

    @Autowired
    private UserFaceInfoService userFaceInfoService;

    @PostMapping("/faceRegister")
    public String faceRegister(MultipartFile img,int id){
        return userFaceInfoService.register(img,id) == 1 ? "成功":"失败";
    }

    @PostMapping("/compare")
    public String compare(MultipartFile img,int index){
        return userFaceInfoService.compareFaceFeature(img, index) > 0.8 ? "成功":"失败";
    }

}
