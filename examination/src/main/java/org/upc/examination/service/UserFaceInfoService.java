package org.upc.examination.service;

import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.entity.UserFaceInfo;

import java.io.IOException;
import java.util.List;

public interface UserFaceInfoService {

    UserFaceInfo doQuery(int id);

    int register(MultipartFile img,int id);

    double compareFaceFeature(MultipartFile img,int targetId);

    int sliceUpload(MultipartFile file,String fileName) throws IOException;

    List<String> compressRegister(String fileName);

    boolean mergeFile(String fileName,int size);

}
