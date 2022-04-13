package org.upc.examination.service.impl;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.entity.UserFaceInfo;
import org.upc.examination.mapper.UserFaceInfoMapper;
import org.upc.examination.service.UserFaceInfoService;
import org.upc.examination.utils.FaceUtils;
import org.upc.examination.utils.FileUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;

@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {

    @Value("${config.arcface-sdk.sdk-lib-path}")
    public String sdkLibPath;
    @Value("${config.arcface-sdk.app-id}")
    public String appId;
    @Value("${config.arcface-sdk.sdk-key}")
    public String sdkKey;
    int errorCode;
    String baseDir = "D:\\img\\temp";

    @Resource
    private UserFaceInfoMapper userFaceInfoMapper;
    private FaceEngine faceEngine;

    @PostConstruct
    public void init() {
        faceEngine = new FaceEngine(sdkLibPath);
        errorCode = faceEngine.activeOnline(appId,sdkKey);
        if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("引擎激活失败");
        }
        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);
        engineConfiguration.setDetectFaceScaleVal(16);

        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);

        errorCode = faceEngine.init(engineConfiguration);
    }

    @Override
    public UserFaceInfo doQuery(int id)
    {
        return userFaceInfoMapper.query(id);
    }

    @Override
    public int register(MultipartFile img,int id) {
        String path = FileUtils.downLoad(img,baseDir);
        UserFaceInfo userFaceInfo = FaceUtils.detectFaces(path,faceEngine,id);
        File file = new File(path);
        file.delete();
        return userFaceInfoMapper.UserFaceRegister(userFaceInfo);
    }

    @Override
    public double compareFaceFeature(MultipartFile img, int targetId) {
        UserFaceInfo targetFaceInfo = userFaceInfoMapper.query(targetId);
        byte[] targetFeature = targetFaceInfo.getFaceFeature();

        String path = FileUtils.downLoad(img,baseDir);
        UserFaceInfo sourceFaceInfo = FaceUtils.detectFaces(path,faceEngine);
        File file = new File(path);
        file.delete();
        byte[] sourceFeature = sourceFaceInfo.getFaceFeature();

        FaceFeature sourceFaceFeature = new FaceFeature();
        FaceFeature targetFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(sourceFeature);
        targetFaceFeature.setFeatureData(targetFeature);

        FaceSimilar faceSimilar = new FaceSimilar();
        errorCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);

        return faceSimilar.getScore();
    }
}
