package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.dto.ApplicationDTO;
import org.bonn.se.carlook.model.objects.entities.Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ApplicationDAO extends GenericDAO<Application>{
    @Override
    public ResultSet add(Application entity) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Application entity) throws SQLException {
        return false;
    }

    @Override
    public Application select(String identifier) throws SQLException {
        return null;
    }

    @Override
    public boolean remove(Application entity) {
        return false;
    }

    public List<ApplicationDTO> selectAllApplicationsAsDTOsByCompanyId(int companyId) {
        // Rufe ApplicationDAO methode mit companyId als paramenter auf

        return null;
    }
}
