package org.upc.examination.entity;


public class Photo {

  private Integer photoId;
  private String photoName;
  private String photo;
  private Integer userId;
  private Integer examId;
  private String time;
  private String remark;


  public Integer getPhotoId() {
    return photoId;
  }

  public void setPhotoId(Integer photoId) {
    this.photoId = photoId;
  }


  public String getPhotoName() {
    return photoName;
  }

  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getExamId() {
    return examId;
  }

  public void setExamId(Integer examId) {
    this.examId = examId;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
