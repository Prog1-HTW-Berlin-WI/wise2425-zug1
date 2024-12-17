package model;

public class Hochschule {
    private String name;
    private int anzahlStudierende;

    public Hochschule(String name) {
        this.name = name;
    }

    public void setAnzahlStudierende(int anzahlStudierende) {
        this.anzahlStudierende = anzahlStudierende;
    }

    public void printUni() {
        System.out.println("An der " + name + " sind " + anzahlStudierende +" Studierende");
    }
}