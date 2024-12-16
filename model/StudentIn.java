package model;

public class StudentIn extends Person {
    private final String matrikelNr;
    // private double grade;
    private String studiengang; // auch als Klasse modellierbar
    private String adresse; // auch als Klasse modellierbar
    private int semester;

    public StudentIn(String firstName, String lastName, String matrikelNr) {
        super(new Anrede(firstName, lastName));
        this.matrikelNr = matrikelNr;
    }

    public StudentIn(String firstName, String lastName, String matrikelNr, int semester) {
        super(new Anrede(firstName, lastName));
        this.matrikelNr = matrikelNr;
        this.semester = semester;
    }

    public StudentIn(String firstName, String lastName, String matrikelNr, String adresse) {
        super(new Anrede(firstName, lastName));
        this.matrikelNr = matrikelNr;
        this.adresse = adresse;
    }

    public boolean learn() {
        System.out.println(getAnrede().getVorname() + " " + getAnrede().getNachname() + ": Lernen ...");
        return false; // Boolean "hat tatsächlich gelernt" (Anregung aus dem Kurs)
    }

    @Override
    public void printInfo() {
        System.out.println(
                "StudentIn: " + getAnrede().getVorname() + " " + getAnrede().getNachname() + " (" + matrikelNr + ")");
    }

    public String getMatrikelNr() {
        return matrikelNr;
    }

    // public double getGrade() {
    //     return grade;
    // }

    // public void setGrade(double grade) {
    //     this.grade = grade;
    // }

    public String getStudiengang() {
        return studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
