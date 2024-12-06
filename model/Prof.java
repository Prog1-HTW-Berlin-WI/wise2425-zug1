package model;

public class Prof extends DozentIn {

    private String besoldungsgruppe;

    public Prof(Anrede anrede){
        super(anrede);
    }

    public void printInfo () {
        System.out.println("Prof: " + getAnrede().getVorname() + " " + getAnrede().getNachname());
    }
}
