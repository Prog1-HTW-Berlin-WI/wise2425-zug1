package model;

public class LsfMitHilfsobjekten implements GradeBook {

    private final LsfEintrag[] eintraege;
    private int eintragIndex = 0;

    public LsfMitHilfsobjekten(int size) {
        this.eintraege = new LsfEintrag[size];
    }

    @Override
    public void addGrade(double grade, String course, StudentIn studentIn) {
        final boolean isValidGrade = isValidGrade(grade);
        final LsfEintrag eintrag = findLsfEintrag(studentIn, course);

        if (isValidGrade) {
            if (this.eintragIndex == this.eintraege.length) {
                System.out.println("Keine Einträge mehr möglich");
            } else if (eintrag == null) {
                this.eintraege[eintragIndex++] = new LsfEintrag(studentIn, grade, course);
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " hinzugefügt.");
            } else {
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " bereits verbucht!");
            }
        }
    }

    @Override
    public void updateGrade(double grade, String course, StudentIn studentIn) {
        final boolean isValidGrade = isValidGrade(grade);
        final LsfEintrag eintrag = findLsfEintrag(studentIn, course);

        if (isValidGrade) {
            if (eintrag == null) {
                System.out.println("Noch keine Note für " + course + "/" + studentIn.getMatrikelNr() + " verbucht!");
            } else {
                eintrag.setGrade(grade);
                System.out.println("Note für " + course + "/" + studentIn.getMatrikelNr() + " geändert.");
            }
        }
    }

    @Override
    public double calculateAverage(StudentIn studentIn) {
        int counter = 0;
        double sum = 0;
        for (int i = 0; i < this.eintragIndex; i++) {
            if (this.eintraege[i].getStudentIn().getMatrikelNr().equals(studentIn.getMatrikelNr())) {
                counter++;
                sum += this.eintraege[i].getGrade();
            }
        }
        return sum / counter;
    }

    @Override
    public double calculateAverage(String course) {
        int counter = 0;
        double sum = 0;
        for (int i = 0; i < this.eintragIndex; i++) {
            if (this.eintraege[i].getCourse().equals(course)) {
                counter++;
                sum += this.eintraege[i].getGrade();
            }
        }
        return sum / counter;
    }

    @Override
    public double calculateAverage() {
        int counter = 0;
        double sum = 0;
        for (int i = 0; i < this.eintragIndex; i++) {
            counter++;
            sum += this.eintraege[i].getGrade();
        }
        return sum / counter;
    }

    @Override
    public void printGradeBook() {
        for (int i = 0; i < this.eintragIndex; i++) {
            final StudentIn studentIn = this.eintraege[i].getStudentIn();
            final Anrede anrede = studentIn.getAnrede();
            System.out.println(" - " + anrede.getVorname() + anrede.getNachname() + " (" + studentIn.getMatrikelNr() + ") in " + this.eintraege[i].getCourse() + ": " + this.eintraege[i].getGrade());
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

    private LsfEintrag findLsfEintrag(StudentIn studentIn, String course) {
        for (LsfEintrag eintrag : eintraege) {
            if (eintrag != null &&
                    eintrag.getCourse().equals(course) &&
                    eintrag.getStudentIn().getMatrikelNr().equals(studentIn.getMatrikelNr())
            ) {
                return eintrag;
            }
        }
        return null;
    }
}
