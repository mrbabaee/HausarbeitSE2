package org.bonn.se.carlook.test.util;

import org.bonn.se.carlook.model.factories.KundeFactory;
import org.bonn.se.carlook.model.objects.dto.KundeDTO;

public class KundeDTOBuilder {

    private KundeDTO kundeDTO = null;

    public KundeDTOBuilder createNewKundeDTO() {
        kundeDTO = KundeFactory.createDTO();
        return this;
    }

    public KundeDTOBuilder withFirstName(String name) {
        kundeDTO.setFirstName(name);
        return this;
    }

    public KundeDTOBuilder withLastName(String name) {
        kundeDTO.setLastName(name);
        return this;
    }

    public KundeDTOBuilder withEMail(String email) {
        kundeDTO.setEMail(email);
        return this;
    }

    public KundeDTOBuilder withPassword(String pw) {
        kundeDTO.setPassword(pw);
        return this;
    }

    public KundeDTOBuilder withStreet(String street) {
        kundeDTO.setStreet(street);
        return this;
    }

    public KundeDTOBuilder withStreetNumber(String streetNumber) {
        kundeDTO.setStreetNumber(streetNumber);
        return this;
    }

    public KundeDTOBuilder withPostalCode(String postalCode) {
        kundeDTO.setPostalCode(postalCode);
        return this;
    }

    public KundeDTOBuilder withPostalCodeArea(String postalCodeArea) {
        kundeDTO.setPostalCodeArea(postalCodeArea);
        return this;
    }

    public KundeDTOBuilder withPhone(String phone) {
        kundeDTO.setPhone(phone);
        return this;
    }

    public KundeDTO build() {
        return kundeDTO;
    }
}
