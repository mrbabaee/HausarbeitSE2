package org.bonn.se.carlook.process.control;

import org.bonn.se.carlook.model.objects.dto.KundeDTO;
import org.bonn.se.carlook.process.control.exceptions.UserAlreadyRegisteredException;
import org.bonn.se.carlook.services.util.RegistrationResult;
import org.bonn.se.carlook.test.util.KundeDTOBuilder;
import org.junit.*;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class RegisterControlTest {

    private Logger logger;

    @Before
    public void SetUp() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @Test
    public void TestRegistrationNullFirstName() throws UserAlreadyRegisteredException {
        String firstName = null;

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO user = builder.createNewKundeDTO().withFirstName(firstName).build();

        RegistrationResult<KundeDTO> result = null;

        try{
            result = RegisterControl.getInstance().registerUser(user);
        } catch (UserAlreadyRegisteredException ex) {
            logger.log(Level.SEVERE, "TestRegistrationNullFirstName failed duo to UserAlreadyRegisteredException!", ex);
        }

        assertNull(user.getFirstName());
        assert result != null;
        assertTrue(result.getReasons().contains(RegistrationResult.FailureType.FIRSTNAME_MISSING));
    }

    @Test
    public void TestRegistrationEmptyFirstName() throws UserAlreadyRegisteredException{
        String firstName = "";

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO user = builder.createNewKundeDTO().withFirstName(firstName).build();

        RegistrationResult<KundeDTO> result = null;

        try{
            result = RegisterControl.getInstance().registerUser(user);
        } catch (UserAlreadyRegisteredException ex) {
            logger.log(Level.SEVERE, "TestRegistrationEmptyFirstName failed duo to UserAlreadyRegisteredException!", ex);
        }

        assertEquals("", user.getFirstName());
        assert result != null;
        assertTrue(result.getReasons().contains(RegistrationResult.FailureType.FIRSTNAME_MISSING));
    }

    @Test
    public void TestRegistrationNullPassword() throws UserAlreadyRegisteredException{
        String password = null;

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO user = builder.createNewKundeDTO().withPassword(password).build();
        RegistrationResult<KundeDTO> result = null;

        try{
            result = RegisterControl.getInstance().registerUser(user);
        } catch (UserAlreadyRegisteredException ex) {
            logger.log(Level.SEVERE, "TestRegistrationNullPassword failed duo to UserAlreadyRegisteredException!", ex);
        }

        assertNull(user.getPassword());
        assert result != null;
        assertTrue(result.getReasons().contains(RegistrationResult.FailureType.PASSWORD_MISSING));
    }

    @Test
    public void TestRegistrationEmptyPassword() throws UserAlreadyRegisteredException{
        String password = "";

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO user = builder.createNewKundeDTO().withPassword(password).build();
        RegistrationResult<KundeDTO> result = null;

        try{
            result = RegisterControl.getInstance().registerUser(user);
        } catch (UserAlreadyRegisteredException ex) {
            logger.log(Level.SEVERE, "TestRegistrationEmptyPassword failed duo to UserAlreadyRegisteredException!", ex);
        }

        assertEquals("", user.getPassword());
        assert result != null;
        assertTrue(result.getReasons().contains(RegistrationResult.FailureType.PASSWORD_MISSING));
    }

    @Test
    public void TestStudentAlreadyRegistered() {
        String firstName = "Mohammad";
        String lastName = "Babaee";
        String email = "mb@carlook.de";
        String password = "mb123";

        String actualMessage = "";
        String expectedMessage = "UserAlreadyRegisteredException";

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO kundeDTO = builder.createNewKundeDTO()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEMail(email)
                .withPassword(password)
                .build();

        RegistrationResult<KundeDTO> result = null;
        try {
            result = RegisterControl.getInstance().registerUser(kundeDTO);
        } catch(UserAlreadyRegisteredException e){
            actualMessage = e.getMessage();
        }

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestStudentRegistrationSuccess(){
        String firstName = "Mohammad";
        String lastName = "Babaee";
        String email = UUID.randomUUID().toString().substring(0, 15);
        String password = "mb123";

        String actualMessage = "";
        String expectedMessage = "UserAlreadyRegisteredException";

        KundeDTOBuilder builder = new KundeDTOBuilder();
        KundeDTO kundeDTO = builder.createNewKundeDTO()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEMail(email)
                .withPassword(password)
                .build();

        RegistrationResult<KundeDTO> result = null;
        try {
            result = RegisterControl.getInstance().registerUser(kundeDTO);
        } catch(UserAlreadyRegisteredException e){
            actualMessage = e.getMessage();
        }

        assertFalse(actualMessage.contains(expectedMessage));
        assert result != null;
        assertTrue(result.getResult());
    }


}
