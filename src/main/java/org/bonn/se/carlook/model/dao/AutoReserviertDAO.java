package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.dto.AutoReserviertDTO;
import org.bonn.se.carlook.model.objects.entities.AutoReserviert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutoReserviertDAO extends GenericDAO<AutoReserviert>{
    @Override
    public ResultSet add(AutoReserviert entity) throws SQLException {
        return null;
    }

    @Override
    public boolean update(AutoReserviert entity) throws SQLException {
        return false;
    }

    @Override
    public AutoReserviert select(String identifier) throws SQLException {
        return null;
    }

    @Override
    public boolean remove(AutoReserviert entity) {
        return false;
    }

    public List<AutoReserviertDTO> selectAllAutosAsDTOsByAutoId(int autoid) {

        return null;
    }
}
