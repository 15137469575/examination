package org.upc.examination.entity;


public class PaperInformation {

  private Integer paperId;
  private String subject;
  private Integer questionNum;
  private Integer paperTeacherId;
  private String remark;


  public Integer getPaperId() {
    return paperId;
  }

  public void setPaperId(Integer paperId) {
    this.paperId = paperId;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  public Integer getQuestionNum() {
    return questionNum;
  }

  public void setQuestionNum(Integer questionNum) {
    this.questionNum = questionNum;
  }


  public Integer getPaperTeacherId() {
    return paperTeacherId;
  }

  public void setPaperTeacherId(Integer paperTeacherId) {
    this.paperTeacherId = paperTeacherId;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
