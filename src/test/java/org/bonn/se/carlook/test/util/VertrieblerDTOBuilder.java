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

}


