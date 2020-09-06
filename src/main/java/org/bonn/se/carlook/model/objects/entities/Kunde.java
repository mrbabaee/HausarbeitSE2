package org.bonn.se.carlook.model.objects.entities;

public class Kunde extends User {

    private int kundeId;
    private String introduction;


    public Kunde(){
        super();
        this.kundeId = 0;
        this.introduction = null;
    }

    public Kunde(int kundeId, String introduction, String firstName, String lastName,
                 String eMail, String password){
        super(0, null, firstName, lastName, eMail, password,
                null, null, null, null, null,
                null, null, false, null);

        this.kundeId = kundeId;
        this.introduction = introduction;
    }


    // -- START GETTERS / SETTERS

    public int getKundeId(){
        return this.kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    // -- END GETTERS / SETTERS

}
