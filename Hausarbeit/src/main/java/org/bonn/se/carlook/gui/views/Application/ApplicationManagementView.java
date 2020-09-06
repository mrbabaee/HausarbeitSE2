/*package org.bonn.se.collhbrs.gui.views.Application;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
//weitere import?

public class ApplicationManagementView extends VerticalLayout implements View {

     //Todo: Von hier aus kann ein(e) Recruiter(in) Eingehende Bewerbungen zur Verwaltung ansehen
       // __Dior_Nam__

    // vertikales Layout


    public ApplicationManagementView(){
        this.setSizeFull(); // ganzer Bildschirm benutzen

        Label verwaltungLabel = new Label("Willkommen, Recruiting Team!");

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

       // VerticalLayout  layout1 = new VerticalLayout();
        Button buttonVerwaltung = new Button("zu Bewerbungen", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonVerwaltung, GroupLayout.Alignment.CENTER);

        //Beim Klicken des Buttons, wird es zur IncomingApplication
      //  buttonVerwaltung.addClickListener(new Button.ClickListener());
        //Bewerbung.getCurrent().getNavigator().navigateTo(Bewerbung.IncomingApplication);


    }

}*/