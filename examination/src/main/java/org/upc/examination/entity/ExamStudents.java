package org.upc.examination.entity;

import java.util.List;

public class ExamStudents {
    private Integer examId;
    private List<Integer> studentId;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public List<Integer> getStudentId() {
        return studentId;
    }

    public void setStudentId(List<Integer> studentId) {
        this.studentId = studentId;
    }
}
