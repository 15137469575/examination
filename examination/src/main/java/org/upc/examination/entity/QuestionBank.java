package org.upc.examination.entity;


public class QuestionBank {

  private Integer questionId;
  private String question;
  private String optionA;
  private String optionB;
  private String optionC;
  private String optionD;
  private String subject;
  private String type;
  private Integer degreeDifficulty;
  private String questionLabels;
  private String answer;


  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }


  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }


  public String getOptionA() {
    return optionA;
  }

  public void setOptionA(String optionA) {
    this.optionA = optionA;
  }


  public String getOptionB() {
    return optionB;
  }

  public void setOptionB(String optionB) {
    this.optionB = optionB;
  }


  public String getOptionC() {
    return optionC;
  }

  public void setOptionC(String optionC) {
    this.optionC = optionC;
  }


  public String getOptionD() {
    return optionD;
  }

  public void setOptionD(String optionD) {
    this.optionD = optionD;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public Integer getDegreeDifficulty() {
    return degreeDifficulty;
  }

  public void setDegreeDifficulty(Integer degreeDifficulty) {
    this.degreeDifficulty = degreeDifficulty;
  }


  public String getQuestionLabels() {
    return questionLabels;
  }

  public void setQuestionLabels(String questionLabels) {
    this.questionLabels = questionLabels;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

}
