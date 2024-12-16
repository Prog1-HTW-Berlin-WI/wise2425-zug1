package model;

public class LsfEintrag {

    private final String course;
    private final StudentIn studentIn;
    private double grade;

    public LsfEintrag(StudentIn studentIn, double grade, String course) {
        this.studentIn = studentIn;
        this.grade = grade;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public StudentIn getStudentIn() {
        return studentIn;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}