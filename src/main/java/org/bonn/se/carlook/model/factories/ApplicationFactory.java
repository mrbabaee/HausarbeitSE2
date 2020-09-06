package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.ApplicationDTO;

public class ApplicationFactory {
    //TODO: Still in progress

    private ApplicationFactory(){}

    /*public static Application createApplication(){
        return new Application();
    }*/

    public static ApplicationDTO createApplicationDTO(){
        return new ApplicationDTO();
    }
}
