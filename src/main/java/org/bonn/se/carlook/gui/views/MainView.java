package org.bonn.se.carlook.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.Footer;
import org.bonn.se.carlook.gui.components.HeaderMainView;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.services.util.Views;

public class MainView extends VerticalLayout implements View {


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        UserDTO loggedInUserDTO = LoginControl.getInstance().getLoggedInUserDTO();

        this.setSizeFull();
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

        HorizontalLayout horizontalHeader1 = new HeaderMainView();
        layout.addComponent(horizontalHeader1);
        layout.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        HorizontalLayout footerLogin = new Footer();
        footerLogin.setHeightFull();

        VerticalLayout bodylayout = new VerticalLayout();


      //  HorizontalLayout buttonLayout = new HorizontalLayout();


        Label welcome = new Label("Willkommen zu deinem Profil " + loggedInUserDTO.getFirstName() + "!");


        bodylayout.addComponent(welcome);

        Button btnShowAutos = new Button("Auto Suchen");
        btnShowAutos.setIcon(FontAwesome.SEARCH);
        btnShowAutos.addStyleName("mystyle");

        btnShowAutos.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.AutoSuche);
            }
        });

        //Auto eintragen Button
        Button btnAddAuto = new Button("Neues Auto eintragen");
        btnAddAuto.setIcon(FontAwesome.WINDOWS);
        btnAddAuto.addStyleName("mystyle");

        btnAddAuto.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.AddAuto);
            }
        });


        bodylayout.addComponent(btnShowAutos);

        layout.addComponent(bodylayout);

        this.addComponent(layout);
        this.addComponent(footerLogin);
        this.setComponentAlignment(footerLogin, Alignment.BOTTOM_CENTER);
    }

}
