import model.Anrede;
import model.NebenberuflLehrbeauftragteR;
import model.Prof;
import model.StudentIn;

public class UniMain {
    public static void main(String[] args) {
        vorlesungOo1();
        System.out.println("----");
        vorlesungOo2();
    }

    private static void vorlesungOo1() {
        StudentIn[] students = {
                new StudentIn("Alice", "Musterfrau", "s0555555"),
                new StudentIn("Bob", "Mustermann", "s0555556"),
                new StudentIn("Max", "Mustermann", "s0555557"),
        };

        // Print out each student:
        for (int i = 0; i < students.length; i++) {
            StudentIn currentStudent = students[i];
            currentStudent.printInfo();
        }

        // ... Or using an enhanced for-loop
        for (StudentIn currentStudent : students) {
            currentStudent.printInfo();
        }

        String name1 = "Bob";
        String name2 = "ABC";
        StudentIn s1 = findStudentByFirstName(students, name1);
        StudentIn s2 = findStudentByFirstName(students, name2);

        if (s1 != null) {
            s1.printInfo();
        } else {
            System.out.println("No student with name " + name1 + " found");
        }

        if (s2 != null) {
            s2.printInfo();
        } else {
            System.out.println("No student with name " + name2 + " found");
        }
    }

    private static StudentIn findStudentByFirstName(StudentIn[] students, String firstNameToFind) {
        StudentIn student = null;

        // for (int i = 0; i < students.length && student == null; i++) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAnrede().getVorname().equals(firstNameToFind)) {
                student = students[i];
                break;
            }
        }

        return student;
    }

    private static void vorlesungOo2(){
        Prof profMustermann = new Prof(new Anrede("Max", "Mustermann"));
        NebenberuflLehrbeauftragteR nils = new NebenberuflLehrbeauftragteR(new Anrede("Nils", "Nebenberuflich"));
        StudentIn anneliese = new StudentIn("Anneliese", "Musterfrau", "123456", 2);

        profMustermann.printInfo();
        nils.printInfo();
        anneliese.printInfo();
    }
}
