package org.bonn.se.carlook.gui.views;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.HeaderMainView;
import org.bonn.se.carlook.services.util.ViewHelper;
import org.bonn.se.carlook.services.util.Views;

public class AutoSucheView extends UI {

    private VerticalLayout layout = new VerticalLayout();
    private Window subWindow = new Window("sub-window");

    @Override
    protected void init(VaadinRequest request) {
        //ViewHelper.isUserLoggedIn();
        addWindow(subWindow);
    }

    public AutoSucheView() {
        layout.setSizeFull();

        // Header
        HorizontalLayout horizontalHeader1 = new HeaderMainView();
        layout.addComponent(horizontalHeader1);
        layout.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        VerticalLayout bodylayout = new VerticalLayout();
        VerticalLayout panellayout1 = new VerticalLayout();

        Label label = new Label("Online seit:     12.08.2020 - 18:00");
        label.addStyleName("labelTitle");
        Label label1 = new Label("Auto-ID:         1-263823");
        label1.addStyleName("labelTitle");
        Label label2 = new Label("Marke:      Audi");
        label2.addStyleName("labelTitle");

        panellayout1.addComponent(label);
        panellayout1.addComponent(label1);
        panellayout1.addComponent(label2);

      /*  Label label3 = new Label("&nbsp;", ContentMode.HTML );
        panellayout1.addComponent(label3); */

        Panel panel1 = new Panel();
        bodylayout.addComponent(panel1);
        panel1.setContent(panellayout1);
      //  bodylayout.addComponent(panellayout1);

        VerticalLayout panellayout2 = new VerticalLayout();
        panellayout2.setSizeFull();

        Label label4 = new Label("Beschreibung");
        label4.addStyleName("labelStyle");
        Label label5 = new Label("gepflegtes Auto, TÜV und HU bis 2022, Unfallfrei");
        label5.setSizeFull();
        Label label6 = new Label("Nächste Wartung August 2021");
        label6.addStyleName("labelStyle");
        Label label7 = new Label("hat das Auto Ihre Intresse geweckt?!");
        label7.setSizeFull();
        Label label8 = new Label("Dann reservieren Sie es für eine persönliche Besichtigung");
        label8.addStyleName("labelStyle");
        Label label9 = new Label(" www.carlook.de/überuns wenn Sie vor Ihrer Bewerbung mehr über CarLook erfahren möchten.");

        label9.setSizeFull();
        panellayout2.addComponent(label4);
        panellayout2.addComponent(label5);
        panellayout2.addComponent(label6);
        panellayout2.addComponent(label7);
        panellayout2.addComponent(label8);
        panellayout2.addComponent(label9);


        Panel panel2 = new Panel();
        panel2.addStyleName("panel");
        bodylayout.addComponent(panel2);
        panel2.setContent(panellayout2);

        if(ViewHelper.isUserStudent()){
            Button button = new Button("Jetzt reservieren!");

            bodylayout.addComponent(button);
            bodylayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);
        } else{
            Button button = new Button("Jetzt registrieren!");
            bodylayout.addComponent(button);
            bodylayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);

            button.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    subWindow.close();
                    UI.getCurrent().getNavigator().navigateTo(Views.Kunde);
                }
            });
        }

        subWindow.setContent(bodylayout);
    }

    public Window getWindow(){
        return this.subWindow;
    }
}
