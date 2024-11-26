public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String studentNr;
    private double grade;
    private String major; // could also be a class
    private String address; // could also be a class
    private int semester;

    public Student(String firstName, String lastName, String studentNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNr = studentNr;
    }

    public boolean learn(){
        System.out.println(firstName + " " + lastName + ": Learn ...");
        return false; // students learns or doesn‘t learn 
    }

    public void printStudent() {
        System.out.println("Student: " + firstName + " " + lastName + " ("+studentNr+")");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNr() {
        return studentNr;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
