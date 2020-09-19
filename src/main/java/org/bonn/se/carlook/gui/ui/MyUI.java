package org.bonn.se.carlook.gui.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.views.*;
import org.bonn.se.carlook.services.util.Views;

import javax.servlet.annotation.WebServlet;


@Theme("mytheme")
@Title("CarLook")
public class MyUI extends UI {

    Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {


        Label welcomeLabel = new Label("Willkommen zurück!!");
         //aktuelles UI-Objekt + Container
        navigator = new Navigator( this,this );


        navigator.addView(Views.MAIN, (Class<? extends View>) MainView.class);
        navigator.addView(Views.LOGIN, (Class<? extends View>) LoginView.class);
        navigator.addView(Views.Kunde, (Class<? extends View>) KundeRegister.class);
        navigator.addView(Views.Vertriebler, (Class<? extends View>) VertrieblerRegister.class);
        navigator.addView(Views.AutoSuche, (Class<? extends View>) AutoView.class);




        UI.getCurrent().getNavigator().navigateTo(Views.Kunde);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
