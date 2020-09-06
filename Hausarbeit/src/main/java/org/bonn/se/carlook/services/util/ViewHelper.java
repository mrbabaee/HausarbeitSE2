package org.bonn.se.carlook.services.util;

import com.vaadin.ui.UI;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.process.control.exceptions.UserNotLoggedInException;

public class ViewHelper {
    private static void isUserLoggedInA() {
        String currentRole = null;

        try {
            currentRole = LoginControl.getInstance().getLoggedInUserDTO().toString();
            if (GlobalHelper.StringIsEmptyOrNull(currentRole)) {
                throw new UserNotLoggedInException();
            }
        } catch (UserNotLoggedInException ex) {
            //Notification.show("Fehler", "Bitte melden Sie sich an!", Notification.Type.ERROR_MESSAGE);
            UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);
        }
    }

    public static boolean isUserLoggedIn(){
        return LoginControl.getInstance().isLoggedIn();
    }

    public static boolean isUserStudent(){
        return LoginControl.getInstance().isStudent();
    }

    public static boolean isUserBusinessMan(){
        return LoginControl.getInstance().isBusinessMan();
    }
}
