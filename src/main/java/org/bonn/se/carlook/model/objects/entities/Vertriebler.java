package org.bonn.se.carlook.model.objects.entities;

public class Vertriebler extends User{

    private int vertrieblerId;
    private String vorname;
    private String nachname;
    //private String websiteUrl;
    //private String contactPerson; //?


    public Vertriebler(){
        super();
        this.vertrieblerId = 0;
        //this.vorname = null;
        //this.nachname = null;
        //this.websiteUrl = null;
        //this.contactPerson = null;
    }


    public Vertriebler(int vertirblerId, String firstName, String lastName,
                       String eMail, String password){
        super(0, null, firstName, lastName, eMail, password,
                null, null, null, null, null,
                null, null, false, null);

        this.vertrieblerId = vertirblerId;
        //this.companyName = companyName;
        //this.websiteUrl = websiteUrl;
    }


    // -- START GETTERS / SETTERS

    public int getCompanyId() {
        return this.vertrieblerId;
    }

    public void setVertrieblerId(int vertrieblerId){
        this.vertrieblerId = vertrieblerId;
    }

    /*public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return this.websiteUrl;
    }

    public void setWebsite(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    // -- END GETTERS / SETTERS

     */


}
