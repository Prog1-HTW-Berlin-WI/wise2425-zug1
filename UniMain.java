import model.*;

public class UniMain {
    public static void main(String[] args) {
        vorlesungOo1();
        System.out.println("----");
        vorlesungOo2();
        System.out.println("----");
        vorlesungOo3();
        System.out.println("----");
        interfaceImplementationExample();
        System.out.println("----");
        vorlesungOo4();
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

    private static void vorlesungOo2() {
        Prof profMustermann = new Prof(new Anrede("Max", "Mustermann"));
        NebenberuflLehrbeauftragteR nils = new NebenberuflLehrbeauftragteR(new Anrede("Nils", "Nebenberuflich"));
        StudentIn anneliese = new StudentIn("Anneliese", "Musterfrau", "123456", 2);

        profMustermann.printInfo();
        nils.printInfo();
        anneliese.printInfo();
    }

    private static void vorlesungOo3() {

        final StudentIn[] studierende = {
                new StudentIn("Alice", "A.", "1"),
                new StudentIn("Bob", "B.", "2"),
                new StudentIn("Claus", "C.", "3"),
        };

        printCourseData("Prog1", studierende);
        printCourseData("GSE", 5);
        printCourseData(studierende, "Prog1"); // Gaunertrick
        long kursgroesse = 123;
        printCourseData("GSE", kursgroesse); // Gaunertrick
    }

    private static void printCourseData(String kursName, StudentIn[] studierende) {
        System.out.println("## Kurs \"" + kursName + "\"");
        for (int i = 0; i < studierende.length; i++) {
            studierende[i].printInfo();
        }
    }

    private static void printCourseData(String kursName, int ects) {
        System.out.println("## Kurs \"" + kursName + "\" (" + ects + " ECTS)");
    }

    private static void printCourseData(StudentIn[] studierende, String kursName) {
        final int countedStudents = countStudents(studierende);
        System.out.println("## Kurs \"" + kursName + "\" (" + countedStudents + ")");

    }

    private static void printCourseData(String kursName, long kursgroesse) {
        System.out.println("Beispiel ...");
    }

    private static int countStudents(StudentIn[] studierende) {
        int counter = studierende.length;
        for (StudentIn studentIn : studierende) {
            if (studentIn == null) {
                counter--;
            }
        }
        return counter;
    }

    private static void interfaceImplementationExample() {
        final StudentIn[] studierende = {
                new StudentIn("Alice", "A", "s001"),
                new StudentIn("Bob", "B", "s002"),
                new StudentIn("Claus", "C", "s003"),
                new StudentIn("Dora", "D", "s004"),
        };
        final String[] kurse = {"Prog1", "GSE"};

        final LsfMitArrays lsf = new LsfMitArrays(kurse, studierende);
        final LsfMitHilfsobjekten lsf2 = new LsfMitHilfsobjekten(20);

        lsfImplementationLogic(lsf, studierende);
        System.out.println("---");
        lsfImplementationLogic(lsf2, studierende);

    }

    private static void lsfImplementationLogic(GradeBook lsf, StudentIn[] studierende) {
        lsf.addGrade(123, "BEISPIEL", new StudentIn("Emil", "E", "s005"));
        lsf.addGrade(2, "GSE", studierende[0]);
        lsf.addGrade(2, "GSE", studierende[0]);
        lsf.updateGrade(1.3, "GSE", studierende[0]);

        lsf.addGrade(1.7, "Prog1", studierende[0]);
        lsf.addGrade(2.3, "Prog1", studierende[1]);
        lsf.addGrade(1.3, "Prog1", studierende[2]);
        lsf.addGrade(1, "Prog1", studierende[3]);

        System.out.println("Durchschnitt (alle Kurse, alle Studierenden): " + lsf.calculateAverage());
        System.out.println("Durchschnitt (nur Prog1): " + lsf.calculateAverage("Prog1"));
        System.out.println("Durchschnitt (nur s001): " + lsf.calculateAverage(studierende[0]));

        lsf.printGradeBook();
    }

    private static void vorlesungOo4() {
        Hochschule htw = new Hochschule("HTW");
        htw.setAnzahlStudierende(14000);
        htw.printUni();

        htw.setAnzahlStudierende(14222);
        htw.printUni();

        System.out.println("---");
        System.out.println("Beispiel für eine static-Methode: Math.floor");
        final double d = 12.123123;
        System.out.println(Math.floor(d));
    }
}
