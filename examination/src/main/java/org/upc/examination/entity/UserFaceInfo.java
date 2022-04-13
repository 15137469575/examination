package org.upc.examination.entity;

public class UserFaceInfo {

    private Integer id;
    private byte[] faceFeature;

    public UserFaceInfo(Integer id, byte[] faceFeature) {
        this.id = id;
        this.faceFeature = faceFeature;
    }

    public UserFaceInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }
}
