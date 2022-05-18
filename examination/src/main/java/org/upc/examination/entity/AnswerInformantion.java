package org.upc.examination.entity;


public class AnswerInformantion {

  private Integer answerId;
  private Integer userId;
  private Integer examId;
  private Integer paperId;
  private Integer questionPaperId;

  private String answer;
  private String remark;
  //private String type;
  //private String correctAnswer;
  private QuestionBank questionBank;
  public QuestionBank getQuestionBank() {
    return questionBank;
  }

  public void setQuestionBank(QuestionBank questionBank) {
    this.questionBank = questionBank;
  }

  /**
  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
**/


  public Integer getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Integer answerId) {
    this.answerId = answerId;
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





  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "AnswerInformantion{" +
            "answerId=" + answerId +
            ", userId=" + userId +
            ", examId=" + examId +
            ", paperId=" + paperId +
            ", questionPaperId=" + questionPaperId +
            ", answer='" + answer + '\'' +
            ", remark='" + remark + '\'' +

            '}';
  }
}
