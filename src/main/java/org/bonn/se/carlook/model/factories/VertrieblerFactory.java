package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.VertrieblerDTO;
import org.bonn.se.carlook.model.objects.entities.Vertriebler;

public class VertrieblerFactory {

    private VertrieblerFactory(){}

    public static Vertriebler createEntity(){
        return new Vertriebler();
    }

    public static VertrieblerDTO createDTO(){
        return new VertrieblerDTO();
    }

    public static Vertriebler createEntityFromDTO(VertrieblerDTO dto) {
        Vertriebler vertriebler = new Vertriebler();
        vertriebler.setFirstName(dto.getFirstName());
        vertriebler.setLastName(dto.getLastName());
        vertriebler.setEMail(dto.getEMail());
        vertriebler.setPassword(dto.getPassword());
        /*vertriebler.setPhone(dto.getPhone());
        vertriebler.setPostalCode(dto.getPostalCode());
        vertriebler.setStreet(dto.getStreet());
        vertriebler.setWebsite(dto.getWebsite());
        vertriebler.setStreetNumber(dto.getStreetNumber());
        vertriebler.setPostalCodeArea(dto.getPostalCodeArea());
        vertriebler.setContactPerson(dto.getContactPerson());
        vertriebler.setCompanyName(dto.getCompanyName());

         */

        return vertriebler;
    }

    public static VertrieblerDTO createDTOFromEntity(Vertriebler entity) {
        VertrieblerDTO vertrieblerDTO = new VertrieblerDTO();
        vertrieblerDTO.setFirstName(entity.getFirstName());
        vertrieblerDTO.setLastName(entity.getLastName());
        vertrieblerDTO.setEMail(entity.getEMail());
        vertrieblerDTO.setPassword(entity.getPassword());
       /* vertrieblerDTO.setPhone(entity.getPhone());
        vertrieblerDTO.setPostalCode(entity.getPostalCode());
        vertrieblerDTO.setStreet(entity.getStreet());
        vertrieblerDTO.setWebsite(entity.getWebsite());
        vertrieblerDTO.setStreetNumber(entity.getStreetNumber());
        vertrieblerDTO.setPostalCodeArea(entity.getPostalCodeArea());
        vertrieblerDTO.setContactPerson(entity.getContactPerson());
        vertrieblerDTO.setCompanyName(entity.getCompanyName());

        */

        return vertrieblerDTO;
    }
}
