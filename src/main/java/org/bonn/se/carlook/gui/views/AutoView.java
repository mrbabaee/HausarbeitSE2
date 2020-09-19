package org.bonn.se.carlook.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.Header;
import org.bonn.se.carlook.gui.components.HeaderMainView;
import org.bonn.se.carlook.model.factories.AutoFactory;
import org.bonn.se.carlook.model.objects.dto.AutoDTO;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.process.control.AutoControl;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.services.util.ViewHelper;

import java.util.List;

public class AutoView extends VerticalLayout implements View {

    private VerticalLayout mainLayout = new VerticalLayout();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        //ViewHelper.isUserLoggedIn();
    }

    public AutoView() {
        UserDTO loggedInUserDTO = LoginControl.getInstance().getLoggedInUserDTO();

        mainLayout.setMargin(false);

        // Header
        HorizontalLayout horizontalHeader1 = new Header();

        if (ViewHelper.isUserLoggedIn()) {
            horizontalHeader1 = new HeaderMainView();
        }

        mainLayout.addComponent(horizontalHeader1);
        mainLayout.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        HorizontalLayout innerHeader = new HorizontalLayout();
        {
            String user = ViewHelper.isUserLoggedIn() ? loggedInUserDTO.getFirstName() : "potentieller Benutzer";

            Label welcome = new Label(String.format("Hallo %s, hier kannst du nach Autos in unserem Fuhrpark suchen.", user));
            welcome.addStyleName("mytitle_Auto");
            innerHeader.addComponent(welcome);
        }
        mainLayout.addComponent(innerHeader);

        HorizontalLayout dataGrid = new HorizontalLayout();
        {
            List<AutoDTO> autos = AutoControl.getInstance().getAllAutos();
            autos.add(AutoFactory.createDemoDTO());
            autos.add(AutoFactory.createDemoDTO());
            autos.add(AutoFactory.createDemoDTO());
            autos.add(AutoFactory.createDemoDTO());

            Grid<AutoDTO> grid = new Grid<>(AutoDTO.class);
            grid.setItems(autos);

            dataGrid.addComponentsAndExpand(grid);
        }
        mainLayout.addComponent(dataGrid);

        HorizontalLayout applicationButton = new HorizontalLayout();
        {
            Button btnApplication = new Button("details sehen!");
            btnApplication.setIcon(FontAwesome.AUTOMOBILE);
            btnApplication.addStyleName("mystyle");

            btnApplication.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {


                    Window subWindow = new AutoSucheView().getWindow();
                    subWindow.setCaption("Details zum Auto");

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

