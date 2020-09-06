package org.bonn.se.carlook.test.util;


import org.bonn.se.carlook.model.factories.VertrieblerFactory;
import org.bonn.se.carlook.model.objects.dto.VertrieblerDTO;

public class VertrieblerDTOBuilder {

    private VertrieblerDTO vertrieblerDTO = null;

    public VertrieblerDTOBuilder createNewBusinessman() {
        vertrieblerDTO = VertrieblerFactory.createDTO();
        return this;
    }

    public VertrieblerDTOBuilder withFirstName(String name) {
        vertrieblerDTO.setFirstName(name);
        return this;
    }

    public VertrieblerDTOBuilder withLastName(String name) {
        vertrieblerDTO.setLastName(name);
        return this;
    }

    public VertrieblerDTOBuilder withEMail(String email) {
        vertrieblerDTO.setEMail(email);
        return this;
    }

    public VertrieblerDTOBuilder withPassword(String pw) {
        vertrieblerDTO.setPassword(pw);
        return this;
    }

    /*public VertrieblerDTOBuilder withStreet(String street) {
        vertrieblerDTO.setStreet(street);
        return this;
    }

    public VertrieblerDTOBuilder withStreetNumber(String streetNumber) {
        vertrieblerDTO.setStreetNumber(streetNumber);
        return this;
    }

    public VertrieblerDTOBuilder withPostalCode(String postalCode) {
        vertrieblerDTO.setPostalCode(postalCode);
        return this;
    }

    public VertrieblerDTOBuilder withPostalCodeArea(String postalCodeArea) {
        vertrieblerDTO.setPostalCodeArea(postalCodeArea);
        return this;
    }

    public VertrieblerDTOBuilder withPhone(String phone) {
        vertrieblerDTO.setPhone(phone);
        return this;
    }

    public VertrieblerDTOBuilder withFax(String fax) {
        vertrieblerDTO.setFax(fax);
        return this;
    }

    public VertrieblerDTOBuilder withWebsite(String website) {
        vertrieblerDTO.setWebsite(website);
        return this;
    }

    public VertrieblerDTO build() {
        return vertrieblerDTO;
    }

     */
}


