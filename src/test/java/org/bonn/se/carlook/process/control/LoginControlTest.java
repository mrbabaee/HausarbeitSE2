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


}
