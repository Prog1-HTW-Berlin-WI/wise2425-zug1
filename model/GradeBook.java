package model;

public interface GradeBook {
    void addGrade(double grade, String course, StudentIn studentIn);

    void updateGrade(double grade, String course, StudentIn studentIn);

    double calculateAverage(StudentIn studentIn);

    double calculateAverage(String course);

    double calculateAverage();

    void printGradeBook();
}