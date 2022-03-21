package org.upc.examination.entity;


public class QuestionPaper {

  private Integer questionPaperId;
  private Integer paperId;
  private Integer questionId;
  private Integer questionPaperSort;
  private String remark;


  public Integer getQuestionPaperId() {
    return questionPaperId;
  }

  public void setQuestionPaperId(Integer questionPaperId) {
    this.questionPaperId = questionPaperId;
  }


  public Integer getPaperId() {
    return paperId;
  }

  public void setPaperId(Integer paperId) {
    this.paperId = paperId;
  }


  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }


  public Integer getQuestionPaperSort() {
    return questionPaperSort;
  }

  public void setQuestionPaperSort(Integer questionPaperSort) {
    this.questionPaperSort = questionPaperSort;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
