package org.upc.examination.entity;


public class Score {

  private Integer scoreId;
  private Integer userId;
  private Integer examId;
  private Integer paperId;
  private Integer questionPaperId;
  private Double score;



  private Integer state;
  private Integer teacherId;
  private String remark;

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }
  public Integer getScoreId() {
    return scoreId;
  }

  public void setScoreId(Integer scoreId) {
    this.scoreId = scoreId;
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


  public Integer getPaperId() {
    return paperId;
  }

  public void setPaperId(Integer paperId) {
    this.paperId = paperId;
  }


  public Integer getQuestionPaperId() {
    return questionPaperId;
  }

  public void setQuestionPaperId(Integer questionPaperId) {
    this.questionPaperId = questionPaperId;
  }


  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }


  public Integer getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Integer teacherId) {
    this.teacherId = teacherId;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
