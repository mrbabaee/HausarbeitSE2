package org.bonn.se.carlook.gui.components;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.HorizontalLayout;


public class Footer extends HorizontalLayout {

    public Footer (){
        this.setStyleName("footer_main");
        HorizontalLayout hlayout = new HorizontalLayout();
        hlayout.setStyleName("footer_main_container");

        Label impressum = new Label("Impressum", ContentMode.HTML);
        impressum.addStyleName("footer_main_container_copyRight");
        hlayout.addComponent(impressum);

        Label datenschutz= new Label("Datenschutz", ContentMode.HTML);
        datenschutz.addStyleName("footer_main_container_copyRight");
        hlayout.addComponent(datenschutz);

        Label agb= new Label("AGB", ContentMode.HTML);
        agb.addStyleName("footer_main_container_copyRight");
        hlayout.addComponent(agb);

        this.addComponent(hlayout);
    }
}
