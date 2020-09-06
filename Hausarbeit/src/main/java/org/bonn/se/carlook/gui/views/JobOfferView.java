package org.bonn.se.carlook.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.Header;
import org.bonn.se.carlook.gui.components.HeaderMainView;
import org.bonn.se.carlook.model.factories.JobOfferFactory;
import org.bonn.se.carlook.model.objects.dto.JobOfferDTO;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.process.control.JobOfferControl;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.services.util.ViewHelper;

import java.util.List;

public class
JobOfferView extends VerticalLayout implements View {

    private VerticalLayout mainLayout = new VerticalLayout();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        //ViewHelper.isUserLoggedIn();
    }

    public JobOfferView() {
        UserDTO loggedInUserDTO = LoginControl.getInstance().getLoggedInUserDTO();

        mainLayout.setMargin(false);

        // Header
        HorizontalLayout horizontalHeader1 = new Header();

        if(ViewHelper.isUserLoggedIn()){
            horizontalHeader1 = new HeaderMainView();
        }

        mainLayout.addComponent(horizontalHeader1);
        mainLayout.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        HorizontalLayout innerHeader = new HorizontalLayout();
        {
            String user = ViewHelper.isUserLoggedIn() ? loggedInUserDTO.getFirstName() : "potentieller Benutzer";

            Label welcome = new Label(String.format("Hallo %s, hier kannst Du nach Stellenanzeigen suchen.", user));
            welcome.addStyleName("mytitle_joboffer");
            innerHeader.addComponent(welcome);
        }
        mainLayout.addComponent(innerHeader);

        HorizontalLayout dataGrid = new HorizontalLayout();
        {
            List<JobOfferDTO> jobs = JobOfferControl.getInstance().getAllJobOffers();
            jobs.add(JobOfferFactory.createDemoDTO());
            jobs.add(JobOfferFactory.createDemoDTO());
            jobs.add(JobOfferFactory.createDemoDTO());
            jobs.add(JobOfferFactory.createDemoDTO());

            Grid<JobOfferDTO> grid = new Grid<>(JobOfferDTO.class);
            grid.setItems(jobs);

            dataGrid.addComponentsAndExpand(grid);
        }
        mainLayout.addComponent(dataGrid);

        HorizontalLayout applicationButton = new HorizontalLayout();
        {
            Button btnApplication = new Button("Stellenanzeige öffnen!");
            btnApplication.setIcon(FontAwesome.USERS);
            btnApplication.addStyleName("mystyle");

            btnApplication.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    //TODO: Bewerbungsseite hier instantiieren

                    Window subWindow = new ApplyView().getWindow();
                    subWindow.setCaption("Beschreibung der Stellenanzeige");

                    subWindow.setWidth("75%");

                    //subWindow.setPosition(200, 50);
                    subWindow.center();

                    UI.getCurrent().addWindow(subWindow);
                }
            });

            applicationButton.addComponent(btnApplication);
            applicationButton.setComponentAlignment(btnApplication, Alignment.MIDDLE_CENTER);
        }
        mainLayout.addComponent(applicationButton);

        this.addComponent(mainLayout);


    }
}
