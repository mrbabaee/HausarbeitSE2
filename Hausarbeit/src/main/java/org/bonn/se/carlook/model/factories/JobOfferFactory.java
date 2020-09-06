package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.JobOfferDTO;
import org.bonn.se.carlook.model.objects.entities.JobOffer;

import java.util.Date;

public class JobOfferFactory {

    private JobOfferFactory(){}

    public static JobOffer createEntity(){
        return new JobOffer();
    }

    public static JobOfferDTO createDTO(){
        return new JobOfferDTO();
    }

    public static JobOffer createEntityFromDTO(JobOfferDTO dto) {
        return null;
    }

    public static JobOfferDTO createDTOFromEntity(JobOffer entity) {
        //TODO Mapping
        JobOfferDTO jobofferDTO = new JobOfferDTO();
        //jobofferDTO.setCompanyName();
        return jobofferDTO;
    }

    public static JobOfferDTO createDemoDTO(){
        JobOfferDTO jobOfferDTO = new JobOfferDTO();

        jobOfferDTO.setCompanyId(1);
        jobOfferDTO.setCompanyName("Siemens AG");
        jobOfferDTO.setDescription("Beschreibung der Stelle");
        jobOfferDTO.setLocation("Bonn");
        jobOfferDTO.setSetupDate(new Date());
        jobOfferDTO.setStartDate(new Date(7985861786219l));
        jobOfferDTO.setStatus("Verfügbar");
        jobOfferDTO.setTitle("Senior Java Developer");
        jobOfferDTO.setType("Netter Typ");

        return jobOfferDTO;
    }
}
