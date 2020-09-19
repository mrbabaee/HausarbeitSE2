package org.bonn.se.carlook.MockitoTest;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.process.control.exceptions.NoSuchUserOrPassword;
import org.bonn.se.carlook.services.util.Views;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

public class MockitoLogin {

    @Mock
    private UI myui; // erzeuge und injiziere ein „UI-Objekt“

    @Mock
    private VaadinSession session;
    private String mohammad;
    private String ab;

    @RunWith(MockitoJUnitRunner.class)
    public class LoginControlTest {

        @Before
        public void setUp()  {

            // Füge simuliertes UI-Object in die UI-Klasse (Test Context) ein
            UI.setCurrent(myui);
            // Wenn Aufruf auf getSession erfolgt, dann liefer das simulierte Objekt
            when(myui.getSession()).thenReturn(session);

            myui.getNavigator().navigateTo(Views.LOGIN);
        }

        @Test
        public boolean testLogin() throws NoSuchUserOrPassword { // Führe Test durch mit den simulierten Objekten

            LoginControl.getInstance().checkAuthentication(mohammad, ab);

            return true;
        }
    }
}


