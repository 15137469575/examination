package org.upc.examination.entity;


public class Users {

  private Integer userId;
  private String userName;
  private String userPassword;
  private String identidy;


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getIdentidy() {
    return identidy;
  }

  public void setIdentidy(String identidy) {
    this.identidy = identidy;
  }

}
