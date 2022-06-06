package org.upc.examination.entity;

public class ScoreToStudent {
    private Integer examId;
    private String teacherName;
    private String examStartTime;
    private Integer studentStatement;

    //总成绩
    private Double scoreOfSum;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Integer getStudentStatement() {
        return studentStatement;
    }

    public void setStudentStatement(Integer studentStatement) {
        this.studentStatement = studentStatement;
    }



    public Double getScoreOfSum() {
        return scoreOfSum;
    }

    public void setScoreOfSum(Double scoreOfSum) {
        this.scoreOfSum = scoreOfSum;
    }

    @Override
    public String toString() {
        return "ScoreToStudent{" +
                "examId=" + examId +
                ", teacherName='" + teacherName + '\'' +
                ", examStartTime='" + examStartTime + '\'' +
                ", studentStatement=" + studentStatement +

                ", scoreOfSum=" + scoreOfSum +
                '}';
    }
}
