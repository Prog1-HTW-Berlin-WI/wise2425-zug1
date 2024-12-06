package model;

public abstract class DozentIn extends Person {
    
    private static int counter = 1;

    private int mitarbeitendenNr;
    private String[] lehrveranstaltungen;

    public DozentIn (Anrede anrede) {
        super(anrede);
        this.mitarbeitendenNr = counter++;
    }

    public int getMitarbeitendenNr() {
        return mitarbeitendenNr;
    }
}
