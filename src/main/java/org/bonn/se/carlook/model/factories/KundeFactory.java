package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.KundeDTO;
import org.bonn.se.carlook.model.objects.entities.Kunde;

public class KundeFactory {


    private KundeFactory(){}

    public static Kunde createEntity(){
        return new Kunde();
    }

    public static KundeDTO createDTO(){
        return new KundeDTO();
    }

    public static Kunde createEntityFromDTO(KundeDTO dto) {
        Kunde kunde = new Kunde();
        kunde.setFirstName(dto.getFirstName());
        kunde.setLastName(dto.getLastName());
        kunde.setEMail(dto.getEMail());
        kunde.setPassword(dto.getPassword());
        kunde.setPhone(dto.getPhone());
        kunde.setPostalCode(dto.getPostalCode());
        kunde.setStreet(dto.getStreet());
        kunde.setStreetNumber(dto.getStreetNumber());
        kunde.setPostalCodeArea(dto.getPostalCodeArea());

        return kunde;
    }

    public static KundeDTO createDTOFromEntity(Kunde entity) {
        return null;
    }
}
