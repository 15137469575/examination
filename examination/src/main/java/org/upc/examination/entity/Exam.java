package org.upc.examination.entity;


public class Exam {

  private Integer examId;
  private String examName;
  private Integer paperId;
  private Integer invigilatorTeacherId;
  private String examTime;
  private Double lengthExam;
  private String limTimeEntry;
  private String limTimeSub;
  private Integer examBatches;
  private String examRoomBatch;
  private String state;
  private String remark;


  public Integer getExamId() {
    return examId;
  }

  public void setExamId(Integer examId) {
    this.examId = examId;
  }


  public String getExamName() {
    return examName;
  }

  public void setExamName(String examName) {
    this.examName = examName;
  }


  public Integer getPaperId() {
    return paperId;
  }

  public void setPaperId(Integer paperId) {
    this.paperId = paperId;
  }


  public Integer getInvigilatorTeacherId() {
    return invigilatorTeacherId;
  }

  public void setInvigilatorTeacherId(Integer invigilatorTeacherId) {
    this.invigilatorTeacherId = invigilatorTeacherId;
  }


  public String getExamTime() {
    return examTime;
  }

  public void setExamTime(String examTime) {
    this.examTime = examTime;
  }


  public Double getLengthExam() {
    return lengthExam;
  }

  public void setLengthExam(Double lengthExam) {
    this.lengthExam = lengthExam;
  }


  public String getLimTimeEntry() {
    return limTimeEntry;
  }

  public void setLimTimeEntry(String limTimeEntry) {
    this.limTimeEntry = limTimeEntry;
  }


  public String getLimTimeSub() {
    return limTimeSub;
  }

  public void setLimTimeSub(String limTimeSub) {
    this.limTimeSub = limTimeSub;
  }


  public Integer getExamBatches() {
    return examBatches;
  }

  public void setExamBatches(Integer examBatches) {
    this.examBatches = examBatches;
  }


  public String getExamRoomBatch() {
    return examRoomBatch;
  }

  public void setExamRoomBatch(String examRoomBatch) {
    this.examRoomBatch = examRoomBatch;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
