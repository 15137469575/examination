package org.upc.examination.entity;

public class ExamStudent {
    private Integer id;
    private Integer examId;
    private Integer studentId;
    private Integer examState;
    public Integer getExamState() {
        return examState;
    }

    public void setExamState(Integer examState) {
        this.examState = examState;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }




}
