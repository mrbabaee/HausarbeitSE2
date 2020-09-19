package org.bonn.se.carlook.process.control;

import org.bonn.se.carlook.model.dao.AutoDAO;
import org.bonn.se.carlook.model.factories.AutoFactory;
import org.bonn.se.carlook.model.objects.dto.AutoDTO;
import org.bonn.se.carlook.model.objects.entities.Auto;

import java.util.List;

public class AutoControl {

    private static AutoControl instance = null;

    public static AutoControl getInstance() {
        if (instance == null) {
            instance = new AutoControl();
        }
        return instance;
    }

    private AutoControl() {

    }

    public void createAuto(AutoDTO autoDTO){
        Auto auto = AutoFactory.createEntityFromDTO(autoDTO);

        //AutoDAO.add(auto)
    }

    public void deleteAuto(AutoDTO autoDTO){

    }

    public List<AutoDTO> getAllAutos(){
        return AutoDAO.getInstance().selectAllAutoAsDTOs();

       /* List<AutoDAO> autoList = AutoDAO.getInstance().selectAllAutoAsDTOs();
        List<AutoDTO> autoDTOList = null;

        for (Auto entity : autoList) {
            autoDTOList.add(AutoFactory.createDTOFromEntity(entity));

        /*
        if (filterAutoMarke){
            gefilterteList = autoDTOList.stream().filter(c -> c.getAutoMarke().toLowerCase().contains(autoMarke.toLowerCase())).collect(Collectors.toList()));
         }



        return autoDTOList;

        */
    }

    public List<AutoDTO> getAllAutosFiltered(/* ... */){
        return null;
    }
}
