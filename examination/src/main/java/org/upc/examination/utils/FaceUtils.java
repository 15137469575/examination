package org.upc.examination.utils;

import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import org.upc.examination.entity.UserFaceInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

public class FaceUtils {

    public static UserFaceInfo detectFaces(String path, FaceEngine faceEngine,int id){
        UserFaceInfo userFaceInfo = null;
        try {
            ImageInfo imageInfo = getRGBData(new File(path));
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            faceEngine.detectFaces(imageInfo.getImageData(),
                    imageInfo.getWidth(),
                    imageInfo.getHeight(),
                    imageInfo.getImageFormat(),
                    faceInfoList);
            if (faceInfoList.size() == 1){
                //特征提取
                FaceFeature faceFeature = new FaceFeature();
                faceEngine.extractFaceFeature(imageInfo.getImageData(),
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        imageInfo.getImageFormat(),
                        faceInfoList.get(0),
                        faceFeature);
                userFaceInfo = new UserFaceInfo(id,faceFeature.getFeatureData());
                return userFaceInfo;
            } else {
                return userFaceInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userFaceInfo;
    }

    public static UserFaceInfo detectFaces(String path, FaceEngine faceEngine){
        UserFaceInfo userFaceInfo = null;
        try {
            ImageInfo imageInfo = getRGBData(new File(path));
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            faceEngine.detectFaces(imageInfo.getImageData(),
                    imageInfo.getWidth(),
                    imageInfo.getHeight(),
                    imageInfo.getImageFormat(),
                    faceInfoList);
            if (faceInfoList.size() == 1){
                //特征提取
                FaceFeature faceFeature = new FaceFeature();
                faceEngine.extractFaceFeature(imageInfo.getImageData(),
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        imageInfo.getImageFormat(),
                        faceInfoList.get(0),
                        faceFeature);
                userFaceInfo = new UserFaceInfo();
                userFaceInfo.setFaceFeature(faceFeature.getFeatureData());
                return userFaceInfo;
            } else {
                return userFaceInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userFaceInfo;
    }

}
