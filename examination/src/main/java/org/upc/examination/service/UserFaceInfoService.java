package org.upc.examination.service;

import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.entity.UserFaceInfo;

public interface UserFaceInfoService {

    UserFaceInfo doQuery(int id);

    int register(MultipartFile img,int id);

    double compareFaceFeature(MultipartFile img,int targetId);

}
