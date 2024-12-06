package model;

public class Anrede {
    private String vorname;
    private String nachname;
    private String titel;
    private String geschlecht; // auch als Enum möglich

    public Anrede (String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getTitel() {
        return titel;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    
}
