package org.bonn.se.carlook.gui.views;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.NativeSelect;

@Title("COLL@HBRS-Registrieren")
public class CreateJobView extends VerticalLayout implements View {
    // TODO: Ali

    public CreateJobView() {
        // this.setSizeFull(); // nutze kompletten Browser-Bildschirm
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSizeFull();

        //setContent(layout); in Tutorial von Alda-Tutorial ?

        // Header
        HorizontalLayout horizontalHeader = new HorizontalLayout();
        Label platzHalter = new Label("Coll@HBRS");
        horizontalHeader.addComponent(platzHalter);
        horizontalHeader.setComponentAlignment(platzHalter, Alignment.TOP_LEFT);
        layout.addComponent(horizontalHeader);
        //layout.addComponent(horizontalHeader);
        //horizontalHeader.addComponentsAndExpand(new Label ("Coll@HBRS"));


        VerticalLayout verticalLayoutBody = new VerticalLayout();

        MenuBar barmenu = new MenuBar();

        MenuBar.MenuItem mi1 = barmenu.addItem("Jobbörse");
        MenuBar.MenuItem mi2 = barmenu.addItem("Firmenprofile");
        MenuBar.MenuItem mi3 = barmenu.addItem("Profil bearbeiten");
        MenuBar.MenuItem mi4 = barmenu.addItem("Karriere");
        MenuBar.MenuItem mi5 = barmenu.addItem("Info & Kontakt");

        //Beim Clicken auf MenuItem
      /*  mi1.setCommand(new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UI.getCurrent().getNavigator().navigateTo(Views.STUDENT);
            }
        });
        mi2.setCommand(new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UI.getCurrent().getNavigator().navigateTo(Views.FIRMA);
            }
        }); */

        Label label = new Label("Informationen zur Stellenanzeige");
        label.addStyleName("mylabel");
        label.setWidth("100%");

        FormLayout form = new FormLayout();

        TextField tf1 = new TextField("Titel");
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);
        NativeSelect<String> select = new NativeSelect<>("Art der Beschäftigung");
        select.setRequiredIndicatorVisible(true);
        select.setItems("Bitte wählen", "Vollzeit", "Teilzeit" , "Befristet", "Unbefristet");
        select.setValue("Bitte wählen");
        form.addComponent(select);
        TextArea area1 = new TextArea("Beschreibung");
        area1.setRequiredIndicatorVisible(true);
        form.addComponent(area1);
        TextArea area2 = new TextArea("Anforderungsprofil");
        form.addComponent(area2);
        TextField tf2 = new TextField("Vergütung");
        form.addComponent(tf2);
        TextField tf3 = new TextField("Zeitraum der Beschäftigung");
        tf3.setRequiredIndicatorVisible(true);
        form.addComponent(tf3);

        Label label1 = new Label("Einsatzort und Kontaktdaten");
        label1.addStyleName("mylabel");
        label1.setWidth("100%");

        FormLayout form1 = new FormLayout();

        TextField tf5 = new TextField("Straße");
        tf5.setRequiredIndicatorVisible(true);
        form1.addComponent(tf5);
        TextField tf6 = new TextField("Hausnummer");
        tf6.setRequiredIndicatorVisible(true);
        form1.addComponent(tf6);
        TextField tf7 = new TextField("PLZ");
        tf7.setRequiredIndicatorVisible(true);
        form1.addComponent(tf7);
        TextField tf8 = new TextField("Ort");
        tf8.setRequiredIndicatorVisible(true);
        form1.addComponent(tf8);
        TextField tf9 = new TextField("Telefon");
        form1.addComponent(tf9);
        TextField tf10 = new TextField("Ansprechpartner");
        tf10.setRequiredIndicatorVisible(true);
        form1.addComponent(tf10);
        TextField tf11 = new TextField("Webseite");
        form1.addComponent(tf11);

        Button button = new Button("Anzeige aufgeben");


        verticalLayoutBody.addComponent(barmenu);
        verticalLayoutBody.setComponentAlignment(barmenu, Alignment.TOP_CENTER);
        verticalLayoutBody.addComponent(label);
        verticalLayoutBody.addComponent(form);
        verticalLayoutBody.addComponent(label1);
        verticalLayoutBody.addComponent(form1);
        verticalLayoutBody.addComponent(button);
        verticalLayoutBody.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        layout.addComponent(verticalLayoutBody);

        this.addComponent(layout);

    }
}