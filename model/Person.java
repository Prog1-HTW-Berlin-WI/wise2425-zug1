package model;

public abstract class Person {
    private final Anrede anrede;
    private int age;

    public Person(Anrede anrede) {
        this.anrede = anrede;
    }

    public void printInfo() {
        System.out.println("Person: " + getAnrede().getVorname() + " " + getAnrede().getNachname());
    }
    
    public Anrede getAnrede() {
        return anrede;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
