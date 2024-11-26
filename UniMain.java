public class UniMain {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", "Musterfrau", "s0555555"),
                new Student("Bob", "Mustermann", "s0555556"),
                new Student("Max", "Mustermann", "s0555557"),
        };

        // Print out each student:
        for (int i = 0; i < students.length; i++) {
            Student currentStudent = students[i];
            currentStudent.printStudent();
        }

        // ... Or using an enhanced for-loop
        for (Student currentStudent : students) {
            currentStudent.printStudent();
        }

        String name1 = "Bob";
        String name2 = "ABC";
        Student s1 = findStudentByFirstName(students, name1);
        Student s2 = findStudentByFirstName(students, name2);

        if (s1 != null) {
            s1.printStudent();
        } else {
            System.out.println("No student with name " + name1 + " found");
        }

        if (s2 != null) {
            s2.printStudent();
        } else {
            System.out.println("No student with name " + name2 + " found");
        }
    }

    private static Student findStudentByFirstName(Student[] students, String firstNameToFind) {
        Student student = null;

        // for (int i = 0; i < students.length && student == null; i++) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstNameToFind)) {
                student = students[i];
                break;
            }
        }

        return student;
    }
}
