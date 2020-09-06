package org.bonn.se.carlook.process.control;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import org.bonn.se.carlook.services.util.Views;
import org.junit.*;
//import sun.rmi.runtime.Log;


import org.mockito.Mock;

import static org.mockito.Mockito.when;


public class LoginControlTest {

   // @RunWith(MockitoJUnitRunner);

    @Mock
    private UI myui; // erzeuge und injiziere ein „UI-Objekt“

    @Mock
    private VaadinSession session;
    private String rohad;
    private String abc;



    @Before
    public void setUp() throws Exception {

            // Füge simuliertes UI-Object in die UI-Klasse (Test Context) ein
            UI.setCurrent(myui);
            // Wenn Aufruf auf getSession erfolgt, dann liefer das simulierte Objekt
            when(myui.getSession()).thenReturn(session);

            myui.getNavigator().navigateTo(Views.LOGIN);
        }

      //  @Test
     //   public boolean testLogin() throws NoSuchUserOrPassword { // Führe Test durch mit den simulierten Objekten

       //     LoginControl.getInstance().checkAuthentication(rohad, abc);

         //   return true;
        // }





    /*@Test
    public void TestLoginSuccess() throws SQLException {
        String email = "dennis.baum@smail.inf.h-brs.de";
        String password = "topSecretPassword";

        String actualMessage = null;
        String expectedMessage = "NoSuchUserOrPassword";

        try {
            LoginControl.getInstance().checkAuthentication(email, password);
        } catch(NoSuchUserOrPassword ex){
            actualMessage = ex.getMessage();
        }

        assertNull(actualMessage);
    }

    @Test
    public void TestLoginFailure() throws SQLException {
        String email = "dennis.baum@smail.inf.h-brs.de";
        String password = "";

        String actualMessage = "";
        String expectedMessage = "NoSuchUserOrPassword";

        try {
            LoginControl.getInstance().checkAuthentication(email, password);
        } catch(NoSuchUserOrPassword ex){
            actualMessage = ex.getMessage();
        }

        assertTrue(actualMessage.contains(expectedMessage));
    }*/
}
