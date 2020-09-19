package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.factories.AutoFactory;
import org.bonn.se.carlook.model.objects.dto.AutoDTO;
import org.bonn.se.carlook.model.objects.entities.Auto;
import org.bonn.se.carlook.services.util.Globals;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO extends GenericDAO<Auto> {

    private static AutoDAO autoDAO = null;

    public static AutoDAO getInstance() {
        if (autoDAO == null) {
            autoDAO = new AutoDAO();
        }
        return autoDAO;
    }

    private AutoDAO() {
        super.table = Globals.TABLE_JOBOFFER;
    }

    @Override
    public ResultSet add(Auto entity){
        return null;
    }

    @Override
    public boolean update(Auto entity){
        return false;
    }

    @Override
    public Auto select(String identifier){
        return null;
    }

    public List<Auto> selectAllAutosAsEntities(){
        return null;
    }

    @Override
    public boolean remove(Auto entity) {
        return false;
    }

    public List<AutoDTO> selectAllAutoAsDTOs() {

        List<AutoDTO> demoList = new ArrayList<AutoDTO>();
        AutoDTO autoDTO = AutoFactory.createDemoDTO();

        demoList.add(autoDTO);

        return demoList;

    }
}
