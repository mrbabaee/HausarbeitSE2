package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.AutoReserviertDTO;

public class AutoReserviertFactory {


    private AutoReserviertFactory(){}


    public static AutoReserviertDTO createAutoReserviertDTO(){
        return new AutoReserviertDTO();
    }
}
