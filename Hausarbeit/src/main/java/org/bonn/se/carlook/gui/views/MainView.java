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


        Label welcome = new Label("Willkommen zu deinem Profil !"); //+ loggedInUserDTO.getFirstName());


        bodylayout.addComponent(welcome);

        Button btnShowJobOffers = new Button("Stellenausschreibungen");
        btnShowJobOffers.setIcon(FontAwesome.USERS);
        btnShowJobOffers.addStyleName("mystyle");

        btnShowJobOffers.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.JOBOFFER);
            }
        });

        //Stellenanzeige erstellen Button
        Button btnCreateJob = new Button("Stellenanzeige erstellen");
        btnCreateJob.setIcon(FontAwesome.WINDOWS);
        btnCreateJob.addStyleName("mystyle");

        btnCreateJob.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.CREATEJOB);
            }
        });



        /*buttonLayout.addComponent(btnShowJobOffers);
        buttonLayout.addComponent(btnCreateJob);
*/
        bodylayout.addComponent(btnShowJobOffers);

        layout.addComponent(bodylayout);

        this.addComponent(layout);
        this.addComponent(footerLogin);
        this.setComponentAlignment(footerLogin, Alignment.BOTTOM_CENTER);
    }




    // Main-View für personalisierten Bereich nach erfolgreichem Login
}
