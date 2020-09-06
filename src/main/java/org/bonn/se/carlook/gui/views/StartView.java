package org.bonn.se.carlook.gui.views;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.bonn.se.carlook.services.util.Views;
import org.bonn.se.carlook.gui.components.Header;




@Title("CarLook-Home")
public class StartView extends VerticalLayout implements View {


    public StartView(){
        this.setWidthFull();
        VerticalLayout layout = new VerticalLayout();
        //layout.setMargin(true);



        HorizontalLayout horizontalHeader1 = new Header();
        this.addComponent(horizontalHeader1);
        this.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        //horizontalHeader1.addComponentsAndExpand(header);

        //horizontalHeader1.setComponentAlignment(header, Alignment.TOP_RIGHT);

        //layout.addComponent(horizontalHeader1);
        //

        // Horizontale-Section für Logo
        HorizontalLayout horizontalHeader = new HorizontalLayout();
        //Horizontale-Section Für Text etc.
        HorizontalLayout horizontalBody = new HorizontalLayout();
        // Horizontale-Section für 2-Buttons Login & Registrieren
        HorizontalLayout horizontalLayoutFooter = new HorizontalLayout();

        //Komponenten erstellen:
        Label labelBegrüssung = new Label ("Herzlich Willkommen auf CarLook!");

        // Buttons sollen zur LoginView & RegisterView navigieren

        Button buttonRegister = new Button("Registrieren", FontAwesome.SIGN_IN);



        buttonRegister.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.Kunde);
            }
        });


        horizontalBody.addComponent(labelBegrüssung);



        horizontalLayoutFooter.addComponent(buttonRegister);
        horizontalLayoutFooter.setComponentAlignment(buttonRegister, Alignment.MIDDLE_CENTER);

        //Als letztes Ausgeführt
        //Nacheinander in layout einfügen für Aufbau
        layout.addComponent(horizontalHeader);
        layout.setComponentAlignment(horizontalHeader, Alignment.TOP_LEFT);

        layout.addComponent(horizontalBody);
        layout.setComponentAlignment(horizontalBody, Alignment.MIDDLE_CENTER);

        layout.addComponent(horizontalLayoutFooter);
        layout.setComponentAlignment(horizontalLayoutFooter, Alignment.MIDDLE_CENTER);

        this.addComponent(layout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Will be called upon entering the site

    }
}
