package org.bonn.se.carlook.gui.components;


import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.services.util.Views;
import java.io.File;

public class HeaderMainView extends HorizontalLayout {

    public HeaderMainView(){
        //Style
        //logo
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
        FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/logo.png"));
        Image logo = new Image("",resource);
        logo.setWidth(500, Unit.PIXELS);
        logo.setHeight(120, Unit.PIXELS);

        //Auf Logo drücken um auf StartSeite zu gelangen
        logo.addClickListener(e ->{
            UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
        });


        final VerticalLayout vertLayout = new VerticalLayout();
        //Layout für Logo
        HorizontalLayout horLayout = new HorizontalLayout();
        //Layout für Menü & Button
        HorizontalLayout horLayout1 = new HorizontalLayout();

        //Menubar/Header
        MenuBar bar = new MenuBar();
        bar.addStyleName("mytitle");
        MenuItem item1 = bar.addItem("Profil bearbeiten");
        MenuItem item2 = bar.addItem("Meine Reservierungen");
        MenuItem item3 = bar.addItem("Dienste");
        MenuItem item4 = bar.addItem("Hilfe");
        MenuItem item5 = bar.addItem("Kontakt");


        item3.setCommand(new MenuBar.Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                UI.getCurrent().getNavigator().navigateTo(Views.AutoSuche);
            }
        });

        //Button für ausloggen
        Button buttonLogout = new Button("Ausloggen", FontAwesome.SIGN_OUT);
        buttonLogout.addStyleName("button_login_out");
        buttonLogout.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                LoginControl.getInstance().logOut();
                UI.getCurrent().getNavigator().navigateTo(Views.Kunde);
            }
        });

        //add logo
        horLayout.addComponent(logo);
        horLayout.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        horLayout1.setSpacing(true);
        //add bar & button
        horLayout1.addComponent(bar);
        horLayout1.setComponentAlignment(bar, Alignment.TOP_CENTER);
        horLayout1.addComponent(buttonLogout);
        horLayout1.setComponentAlignment(buttonLogout, Alignment.TOP_RIGHT);
        //beide horLayouts dem vertikalen Layout hinzufügen
        vertLayout.addComponent(horLayout);
        vertLayout.addComponent(horLayout1);
        vertLayout.setComponentAlignment(horLayout, Alignment.TOP_CENTER);
        vertLayout.setComponentAlignment(horLayout1, Alignment.MIDDLE_CENTER);
        // Verlayout der Seite hinzufügen
        this.addComponent(vertLayout);
    }
}


