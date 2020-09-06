package org.bonn.se.carlook.process.control;

import com.vaadin.server.VaadinSession;

import com.vaadin.ui.UI;
import org.bonn.se.carlook.model.dao.UserDAO;
import org.bonn.se.carlook.model.factories.UserFactory;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.model.objects.entities.User;
import org.bonn.se.carlook.process.control.exceptions.NoSuchUserOrPassword;
import org.bonn.se.carlook.services.util.Globals;
import org.bonn.se.carlook.services.util.Roles;
import org.bonn.se.carlook.services.util.Views;

import java.util.HashMap;

public class LoginControl {


    HashMap<UserDTO, User> mappedUsers = null;

    private static LoginControl instance = null;

    public static LoginControl getInstance() {
        if (instance == null) {
            instance = new LoginControl();
        }
        return instance;
    }

    private LoginControl() {
        mappedUsers = new HashMap<>();
    }

    public void checkAuthentication(String email, String password) throws NoSuchUserOrPassword {
        UserDAO userDAO = UserDAO.getInstance();

        if(userDAO.login(email, password)){
            User user = userDAO.select(email);
            UserDTO userDTO = UserFactory.createDTOFromEntity(user);

            mappedUsers.put(userDTO, user);

            VaadinSession session = UI.getCurrent().getSession();
            session.setAttribute(Globals.CURRENT_USER, userDTO);
        }
        else{
            // User not registered
            throw new NoSuchUserOrPassword();
        }

        //Redirect auf Main-Page
        //Benutzer ist vorhanden

        UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
    }

    public void logOut() {
        VaadinSession.getCurrent().close();
        UI.getCurrent().getPage().setLocation("/");
        //UI.getCurrent().getNavigator().navigateTo(Views.STUDENT);
    }

    public UserDTO getLoggedInUserDTO(){
        try {
            return (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        } catch(Exception ex){
            return null;
        }
    }

    private User getLoggedInUserEntity(){
        UserDTO userDTO = getLoggedInUserDTO();

        if(userDTO != null)
            return mappedUsers.get(userDTO);
        else
            return null;
    }

    public boolean isLoggedIn(){
        if(getLoggedInUserDTO() != null)
            return true;
        else
            return false;
    }

    public boolean isStudent(){
        if(getLoggedInUserDTO() != null)
            return getLoggedInUserDTO().getRole().equals(Roles.Kunde);
        else
            return false;
    }

    public boolean isBusinessMan(){
        if(getLoggedInUserDTO() != null)
            return getLoggedInUserDTO().getRole().equals(Roles.BUSINESS);
        else
            return false;
    }
}
