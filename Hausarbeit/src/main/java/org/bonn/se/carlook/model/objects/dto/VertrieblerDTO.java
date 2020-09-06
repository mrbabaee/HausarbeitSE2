package org.bonn.se.carlook.model.objects.dto;

// Vertriebler
public class VertrieblerDTO extends UserDTO{

    private String VertrieblerVorname;
    private String VertrieblerNachname;
    //private String websiteUrl;
    //private String fax;
    //private String contactPerson;

    public VertrieblerDTO(){
        this.VertrieblerVorname = null;
        this.VertrieblerVorname = null;
        //this.websiteUrl = null;
        //this.fax = null;
    }

    public String getVertrieblerVorname() {
        return this.VertrieblerVorname;
    }

    public void setVertrieblerVorname(String VertrieblerVorname) {
        this.VertrieblerVorname = VertrieblerVorname;
    }

    public String getVertrieblerNachname() {
        return this.VertrieblerNachname;
    }

    public void setVertrieblerNachname(String VertrieblerNachname) {
        this.VertrieblerVorname = VertrieblerNachname;
    }

    /*public String getWebsite() {
        return this.websiteUrl;
    }

    public void setWebsite(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getFax(){
        return this.fax;
    }

    public void setFax(String fax){
        this.fax = fax;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;


    }

     */
}
