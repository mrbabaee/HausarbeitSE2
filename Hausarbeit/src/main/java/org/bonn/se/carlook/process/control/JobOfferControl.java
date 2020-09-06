package org.bonn.se.carlook.process.control;

import org.bonn.se.carlook.model.dao.JobOfferDAO;
import org.bonn.se.carlook.model.factories.JobOfferFactory;
import org.bonn.se.carlook.model.objects.dto.JobOfferDTO;
import org.bonn.se.carlook.model.objects.entities.JobOffer;

import java.util.List;

public class JobOfferControl {

    private static JobOfferControl instance = null;

    public static JobOfferControl getInstance() {
        if (instance == null) {
            instance = new JobOfferControl();
        }
        return instance;
    }

    private JobOfferControl() {
        //TODO: mapping
        //mappedJobOffers.put(userDTO, user);
    }

    public void createJobOffer(JobOfferDTO jobOfferDTO){
        JobOffer jobOffer = JobOfferFactory.createEntityFromDTO(jobOfferDTO);

        //TODO: Create jobofferdao
        //JobOfferDAO.add(jobOffer)
    }

    public void deleteJobOffer(JobOfferDTO jobOfferDTO){

    }

    public List<JobOfferDTO> getAllJobOffers(){
        return JobOfferDAO.getInstance().selectAllJobsAsDTOs();

        /*List<JobOffer> jobOfferList = JobOfferDAO.getInstance().selectAll();
        List<JobOfferDTO> jobOfferDTOList = null;

        for (JobOffer entity : jobOfferList) {
            jobOfferDTOList.add(JobOfferFactory.createDTOFromEntity(entity));
        }

        return jobOfferDTOList;*/
    }

    public List<JobOfferDTO> getAllJobOffersFiltered(/* ... */){
        return null;
    }
}
