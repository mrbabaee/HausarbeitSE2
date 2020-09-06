package org.bonn.se.carlook.process.control;

import org.bonn.se.carlook.model.dao.VertrieblerDAO;
import org.bonn.se.carlook.model.dao.KundeDAO;
import org.bonn.se.carlook.model.dao.UserDAO;
import org.bonn.se.carlook.model.factories.VertrieblerFactory;
import org.bonn.se.carlook.model.factories.KundeFactory;
import org.bonn.se.carlook.model.objects.dto.VertrieblerDTO;
import org.bonn.se.carlook.model.objects.dto.KundeDTO;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.model.objects.entities.Vertriebler;
import org.bonn.se.carlook.model.objects.entities.Kunde;
import org.bonn.se.carlook.model.objects.entities.User;
import org.bonn.se.carlook.process.control.exceptions.CompanyAlreadyRegisteredException;
import org.bonn.se.carlook.process.control.exceptions.UserAlreadyRegisteredException;
import org.bonn.se.carlook.services.util.RegistrationResult;
import org.bonn.se.carlook.services.util.RegistrationResult.FailureType;
import org.bonn.se.carlook.services.util.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bonn.se.carlook.services.util.GlobalHelper.StringIsEmptyOrNull;

public class RegisterControl {

    protected Logger logger;

    private List<FailureType> failures = new ArrayList<>();

    private static RegisterControl instance = null;

    public static RegisterControl getInstance() {
        if (instance == null) {
            instance = new RegisterControl();
        }
        return instance;
    }

    private RegisterControl() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public RegistrationResult<KundeDTO> registerUser(KundeDTO kundeDTO) throws UserAlreadyRegisteredException {
        RegistrationResult<KundeDTO> result = new RegistrationResult<>();

        checkStandardValues(kundeDTO);
        checkKundeValues(kundeDTO);


        if(!result.getReasons().isEmpty()) {
            result.setResult(false);
            return result;
        }
        else {
            result.setResult(true);
        }

        // Register Kunde
        UserDAO userDAO = UserDAO.getInstance();

        User user = userDAO.select(kundeDTO.getEMail());

        if(!StringIsEmptyOrNull(user.getEMail())){
            throw new UserAlreadyRegisteredException();
        }

        Kunde kunde = KundeFactory.createEntityFromDTO(kundeDTO);

        kunde.setRole(Roles.Kunde);
        kundeDTO.setRole(Roles.Kunde);
        ResultSet rs = userDAO.add(kunde);

        try {
            if (rs.next()) {
                kunde.setUserId(rs.getInt("userid"));
            } else{
                logger.log(Level.SEVERE, "RegisterControl - Error: No userid was found!");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "RegisterControl - Error: Error in registerCompany function!", ex);
        }

        KundeDAO kundeDAO = KundeDAO.getInstance();
        rs = kundeDAO.add(kunde);

        try {
            if (rs.next()) {
                kunde.setKundeId(rs.getInt("kundeid"));
            } else{
                logger.log(Level.SEVERE, "RegisterControl - Error: No kundeid was found!");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "RegisterControl - Error: Error in registerCompany function!", ex);
        }

        result.addRegisteredUserDTO(kundeDTO);
        result.setReasons(failures);

        return result;
    }

    public RegistrationResult<VertrieblerDTO> registerCompany(VertrieblerDTO vertrieblerDTO) throws UserAlreadyRegisteredException, CompanyAlreadyRegisteredException {
        RegistrationResult<VertrieblerDTO> result = new RegistrationResult<>();

        checkStandardValues(vertrieblerDTO);
        checkVertrieblerValues(vertrieblerDTO);

        if(!result.getReasons().isEmpty()) {
            result.setResult(false);
            return result;
        }
        else {
            result.setResult(true);
        }

        UserDAO userDAO = UserDAO.getInstance();

        User user = userDAO.select(vertrieblerDTO.getEMail());

        if(!StringIsEmptyOrNull(user.getEMail())){
            throw new UserAlreadyRegisteredException();
        }

        VertrieblerDAO vertrieblerDAO = VertrieblerDAO.getInstance();
        Vertriebler vertriebler = vertrieblerDAO.select(vertrieblerDTO.getVertrieblerNachname());

        if(!StringIsEmptyOrNull(vertriebler.getLastName())){
            throw new CompanyAlreadyRegisteredException();
        }

        vertriebler = VertrieblerFactory.createEntityFromDTO(vertrieblerDTO);

        vertriebler.setRole(Roles.BUSINESS);
        vertrieblerDTO.setRole(Roles.BUSINESS);
        ResultSet rs = userDAO.add(vertriebler);

        try {
            if (rs.next()) {
                vertriebler.setUserId(rs.getInt("userid"));
            } else{
                logger.log(Level.SEVERE, "RegisterControl - Error: No userid was found!");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "RegisterControl - Error: Error in vertriebler function!", ex);
        }

        vertrieblerDAO.add(vertriebler);

        result.addRegisteredUserDTO(vertrieblerDTO);
        result.setReasons(failures);

        return result;
    }

    private void checkStandardValues(UserDTO userDTO){
        checkValue(userDTO.getFirstName(), FailureType.FIRSTNAME_MISSING);
        checkValue(userDTO.getLastName(), FailureType.LASTNAME_MISSING);

        checkValue(userDTO.getEMail(), FailureType.EMAIL_MISSING);
        checkValue(userDTO.getPassword(), FailureType.PASSWORD_MISSING);
    }

    private void checkVertrieblerValues(VertrieblerDTO ep){
        checkValue(ep.getFirstName(), FailureType.FIRSTNAME_MISSING);
        checkValue(ep.getLastName(), FailureType.LASTNAME_MISSING);

        checkValue(ep.getEMail(), FailureType.EMAIL_MISSING);
        checkValue(ep.getPassword(), FailureType.PASSWORD_MISSING);


        /*checkValue(ep.getStreet(), FailureType.STREET_MISSING);
        checkValue(ep.getStreetNumber(), FailureType.STREETNUMBER_MISSING);
        checkValue(ep.getPostalCode(), FailureType.POSTALCODE_MISSING);
        checkValue(ep.getPostalCodeArea(), FailureType.POSTALCODEAREA_MISSING);

        checkValue(ep.getPhone(), FailureType.PHONE_MISSING);

        //checkValue(ep.., FailureType..);*/
    }



    private void checkKundeValues(KundeDTO kundeDTO){
        //checkValue(kunde.getFaculty(), FailureType.FACULTY_MISSING);
    }

    private void checkValue(String value, FailureType failureType){
        if(StringIsEmptyOrNull(value)) {
            failures.add(failureType);
        }
    }
}
