package org.upc.examination.entity;
/**
 * 本类
 * 应用场景：在学生考试的过程中，前台会向后台传送studentId,examId和questionId
 *          后台会向前台传送回question，optionA,optionB,optionC,optionD,type,answer
 *          在本类中，特地将以上字段封装在一个类中
 * */
public class ExamAnswer {
    private String Question;
    private String A;
    private String B;
    private String C;
    private String D;
    private String Type;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    private String Answer;

    @Override
    public String toString() {
        return "ExamAnswer{" +
                "Question='" + Question + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", Type='" + Type + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}
