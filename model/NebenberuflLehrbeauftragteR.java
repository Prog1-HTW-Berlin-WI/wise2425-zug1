package model;

public class NebenberuflLehrbeauftragteR extends DozentIn {
    private String hauptberuf;
    private String[] qualifikationen;
    private int stundenbasis;

    public NebenberuflLehrbeauftragteR(Anrede anrede){
        super(anrede);
    }
}
