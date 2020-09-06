package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.factories.JobOfferFactory;
import org.bonn.se.carlook.model.objects.dto.JobOfferDTO;
import org.bonn.se.carlook.model.objects.entities.JobOffer;
import org.bonn.se.carlook.services.util.Globals;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobOfferDAO extends GenericDAO<JobOffer> {

    private static JobOfferDAO jobOfferDAO = null;

    public static JobOfferDAO getInstance() {
        if (jobOfferDAO == null) {
            jobOfferDAO = new JobOfferDAO();
        }
        return jobOfferDAO;
    }

    private JobOfferDAO() {
        super.table = Globals.TABLE_JOBOFFER;
    }

    @Override
    public ResultSet add(JobOffer entity){
        return null;
    }

    @Override
    public boolean update(JobOffer entity){
        return false;
    }

    @Override
    public JobOffer select(String identifier){
        return null;
    }

    public List<JobOffer> selectAllJobsAsEntities(){
        return null;
    }

    @Override
    public boolean remove(JobOffer entity) {
        return false;
    }

    public List<JobOfferDTO> selectAllJobsAsDTOs() {

        List<JobOfferDTO> demoList = new ArrayList<JobOfferDTO>();
        JobOfferDTO jobOfferDTO = JobOfferFactory.createDemoDTO();

        demoList.add(jobOfferDTO);

        return demoList;

    }
}
