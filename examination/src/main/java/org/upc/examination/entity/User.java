package org.upc.examination.entity;

public class User {

  private String id;
  private String pwd;
  private Integer role;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

}
