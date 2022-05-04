package org.upc.examination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.service.UserFaceInfoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/face")
public class FaceController {

    @Autowired
    private UserFaceInfoService userFaceInfoService;

    @PostMapping("/faceRegister")
    public String faceRegister(MultipartFile img, int id) {
        return userFaceInfoService.register(img, id) == 1 ? "success" : "fail";
    }

    @PostMapping("/compare")
    public String compare(MultipartFile img, int index) {
        return userFaceInfoService.compareFaceFeature(img, index) > 0.8 ? "success" : "fail";
    }

    @PostMapping("/sliceUpload")
    public int sliceUpload(MultipartFile file, String fileName) throws IOException {
        return userFaceInfoService.sliceUpload(file, fileName);
    }

    @PostMapping("/mergeFile")
    public boolean mergeFile(String fileName, int size) {
        return userFaceInfoService.mergeFile(fileName,size);
    }

    @PostMapping("/compressRegister")
    public List<String> compressRegister(String fileName) {
        return userFaceInfoService.compressRegister(fileName.split("\\.")[0]);
    }

}
