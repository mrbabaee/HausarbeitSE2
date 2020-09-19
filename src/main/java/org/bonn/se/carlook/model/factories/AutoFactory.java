package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.AutoDTO;
import org.bonn.se.carlook.model.objects.entities.Auto;

import java.util.Date;

public class AutoFactory {

    private AutoFactory(){}

    public static Auto createEntity(){
        return new Auto();
    }

    public static AutoDTO createDTO(){ return new AutoDTO(); }

    public static Auto createEntityFromDTO(AutoDTO dto) {
        return null;
    }

    public static AutoDTO createDTOFromEntity(Auto entity) {
        AutoDTO autoDTO = new AutoDTO();

        return autoDTO;
    }

    public static AutoDTO createDemoDTO(){
        AutoDTO autoDTO = new AutoDTO();

        //for (int i=1; i<=5 ; i++){}
        autoDTO.setAutoId(1);

        autoDTO.setMarke("BMW");
        autoDTO.setBeschreibung("gepflegtes Auto, Tüv neu, Unfallfrei");
        autoDTO.setBaujahr(new Date(7985861786219l));
        autoDTO.setStatus("Verfügbar");
        autoDTO.setPreis(autoDTO.getPreis());

        return autoDTO;
    }
}
