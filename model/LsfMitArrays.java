package model;

public class LsfMitArrays implements GradeBook {

    private double[][] grades;
    private String[] courses;
    private StudentIn[] students;

    public LsfMitArrays(String[] courses, StudentIn[] students) {
        this.courses = courses;
        this.students = students;
        this.grades = new double[courses.length][students.length];
    }

    @Override
    public void addGrade(double grade, String course, StudentIn studentIn) {
        final int studentIndex = findStudentIndex(studentIn);
        final int courseIndex = findCourseIndex(course);
        final boolean isValidGrade = isValidGrade(grade);

        if (studentIndex >= 0 && courseIndex >= 0 && isValidGrade) {
            if (this.grades[courseIndex][studentIndex] == 0) {
                this.grades[courseIndex][studentIndex] = grade;
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " hinzugefügt.");
            } else {
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " bereits verbucht!");
            }
        }
    }

    @Override
    public void updateGrade(double grade, String course, StudentIn studentIn) {
        final int studentIndex = findStudentIndex(studentIn);
        final int courseIndex = findCourseIndex(course);
        final boolean isValidGrade = isValidGrade(grade);

        if (studentIndex >= 0 && courseIndex >= 0 && isValidGrade) {
            if (this.grades[courseIndex][studentIndex] == 0) {
                System.out.println("Noch keine Note für " + course + "/" + studentIn.getMatrikelNr() + " verbucht!");
            } else {
                this.grades[courseIndex][studentIndex] = grade;
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " geändert.");
            }
        }
    }

    @Override
    public double calculateAverage(StudentIn studentIn) {
        int counter = 0;
        double sum = 0;
        final int studentIndex = findStudentIndex(studentIn);
        if (studentIndex >= 0) {
            for (double[] courseGrades : this.grades) {
                if (courseGrades[studentIndex] != 0) {
                    counter++;
                    sum += courseGrades[studentIndex];

                }
            }
        }
        return sum / counter;
    }

    @Override
    public double calculateAverage(String course) {
        int counter = 0;
        double sum = 0;
        final int courseIndex = findCourseIndex(course);
        if (courseIndex >= 0) {
            for (double grade : this.grades[courseIndex]) {
                if (grade != 0) {
                    counter++;
                    sum += grade;

                }
            }
        }
        return sum / counter;
    }

    @Override
    public double calculateAverage() {
        int counter = 0;
        double sum = 0;
        for (double[] courseGrades : this.grades) {
            for (double grade : courseGrades) {
                if (grade != 0) {
                    counter++;
                    sum += grade;
                }
            }
        }
        return sum / counter;
    }

    @Override
    public void printGradeBook() {
        for (int i = 0; i < this.courses.length; i++) {
            System.out.println("## " + this.courses[i] + " ##");
            for (int j = 0; j < this.students.length; j++) {
                final Anrede anrede = students[i].getAnrede();
                System.out.print(" - " + anrede.getVorname() + " " + anrede.getNachname() + " (" + students[i].getMatrikelNr() + "): ");
                System.out.println(grades[i][j] == 0 ? "-" : grades[i][j]);
            }
        }
    }

    private boolean isValidGrade(double grade) {
        final double[] validGrades = {1, 1.3, 1.7, 2, 2.3, 2.7, 3, 3.3, 4, 5};
        for (double valid : validGrades) {
            if (valid == grade) {
                return true;
            }
        }
        System.out.println(grade + " ist keine gültige Note!");
        return false;
    }

    private int findCourseIndex(String course) {
        for (int i = 0; i < this.courses.length; i++) {
            if (course.equals(this.courses[i])) {
                return i;
            }
        }
        System.out.println("Kurs " + course + " nicht gefunden!");
        return -1; // Wird nur zurückgegeben, wenn kein Kurs gefunden wurde
    }

    private int findStudentIndex(StudentIn studentIn) {
        for (int i = 0; i < this.students.length; i++) {
            if (studentIn.getMatrikelNr().equals(this.students[i].getMatrikelNr())) {
                return i;
            }
        }
        System.out.println("Student:in mit Matrikelnr. " + studentIn.getMatrikelNr() + " nicht gefunden!");
        return -1; // Wird nur zurückgegeben, wenn keine Person gefunden wurde
    }
}
