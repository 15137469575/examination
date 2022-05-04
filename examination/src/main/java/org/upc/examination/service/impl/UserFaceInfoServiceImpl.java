package org.upc.examination.service.impl;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.upc.examination.entity.UserFaceInfo;
import org.upc.examination.mapper.UserFaceInfoMapper;
import org.upc.examination.service.UserFaceInfoService;
import org.upc.examination.utils.FaceUtils;
import org.upc.examination.utils.FileUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

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
        if (img == null){
            return 0;
        }
        String path = FileUtils.downLoad(img,baseDir);
        UserFaceInfo userFaceInfo = FaceUtils.detectFaces(path,faceEngine,id);
        File file = new File(path);
        file.delete();
        return userFaceInfoMapper.UserFaceRegister(userFaceInfo);
    }

    @Override
    public double compareFaceFeature(MultipartFile img, int targetId) {
        if (img == null){
            return 0;
        }
        UserFaceInfo targetFaceInfo = userFaceInfoMapper.query(targetId);
        byte[] targetFeature = targetFaceInfo.getFaceFeature();

        String path = FileUtils.downLoad(img,baseDir);
        UserFaceInfo sourceFaceInfo = FaceUtils.detectFaces(path,faceEngine);
        File file = new File(path);
        file.delete();
        if (sourceFaceInfo == null){
            return 0;
        }
        byte[] sourceFeature = sourceFaceInfo.getFaceFeature();

        FaceFeature sourceFaceFeature = new FaceFeature();
        FaceFeature targetFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(sourceFeature);
        targetFaceFeature.setFeatureData(targetFeature);

        FaceSimilar faceSimilar = new FaceSimilar();
        errorCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);

        System.out.println(faceSimilar.getScore());

        return faceSimilar.getScore();
    }

    @Override
    public int sliceUpload(MultipartFile file,String fileName) throws IOException {
        if (file == null){
            return 0;
        }
        File myFile = new File(baseDir + File.separator + fileName);
        int result = FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(myFile));
        if(result != 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<String> compressRegister(String fileName) {
        List<String> failList = new ArrayList<>();
        UserFaceInfo userFaceInfo = null;
        ImageInfo imageInfo = null;
        List<FaceInfo> faceInfoList = new ArrayList<>();

        File dirFile = new File(baseDir + File.separator + fileName.split("\\.")[0]);
        File[] files = dirFile.listFiles();

        for (File file : files){
            if(file.isDirectory()){
                continue;
            }
            String name = file.getName().split("\\.")[0];
            String prefix = file.getName().split("\\.")[1];
            if(prefix.equals("png") || prefix.equals("jpg") || prefix.equals("bmp")){

            }else{
                file.delete();
                continue;
            }
            imageInfo = getRGBData(file);
            faceEngine.detectFaces(imageInfo.getImageData(),
                    imageInfo.getWidth(),
                    imageInfo.getHeight(),
                    imageInfo.getImageFormat(),
                    faceInfoList);
            if (faceInfoList.size() == 1){
                FaceFeature faceFeature = new FaceFeature();
                faceEngine.extractFaceFeature(imageInfo.getImageData(),
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        imageInfo.getImageFormat(),
                        faceInfoList.get(0),
                        faceFeature);
                userFaceInfo = new UserFaceInfo(Integer.valueOf(name),faceFeature.getFeatureData());
                file.delete();
                userFaceInfoMapper.UserFaceRegister(userFaceInfo);
            }else {
                file.delete();
                failList.add(name);
            }
        }

        dirFile.delete();

        return failList;
    }

    @Override
    public boolean mergeFile(String fileName, int size) {
        if (FileUtils.mergeFile(fileName,baseDir,size)){
            if (FileUtils.unZip(fileName,baseDir)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
