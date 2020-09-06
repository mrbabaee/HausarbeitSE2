package org.bonn.se.carlook.model.objects.dto;

// Kunde
public class KundeDTO extends UserDTO {

    private String introduction;

    public KundeDTO(){
        this.title = null;
        this.firstName = null;
        this.lastName = null;
        this.eMail = null;
        this.street = null;
        this.streetNumber = null;
        this.postalCode = null;
        this.postalCodeArea = null;
        this.phone = null;
        this.dateOfBirth = null;
        this.picture = null;
        this.role = null;
    }

    public String getIntroduction(){
        return this.introduction;
    }

    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

}
