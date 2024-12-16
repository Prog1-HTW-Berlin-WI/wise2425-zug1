package model;

public class Prof extends DozentIn {

    private String besoldungsgruppe;

    public Prof(Anrede anrede){
        super(anrede);
    }

    @Override
    public void printInfo () {
        System.out.println("Prof: " + getAnrede().getVorname() + " " + getAnrede().getNachname());
    }
}
