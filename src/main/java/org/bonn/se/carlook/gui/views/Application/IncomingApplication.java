/*package org.bonn.se.collhbrs.gui.views.Application;

public class IncomingApplication extends vertical layout implements View {

    // Todo: Der Unternehmer oder Recruiter kann alle eingegangene Bewerbungen sehen und sie Parsen(CV-Parsing),
    auf vollständigkeit prüfen, oder, Löschen und Bewerber wird benachrichtigt, oder sortieren nach A-, B- oder
    C-Bewerber und dann zum Gespräch einladen.
     //
    // verticales Layout

    public IncomingApplication() {
        this.setSizeFull(); //ganzer Bildschirm benutzen
        Label verwaltungLabel = new Label("Bewerbungspool und Bearbeitung...");
        VerticalLayout layout = new VerticalLayout();

        //Alternativ 1
        //Bewerbungspool

        //esrte Bewerbung
        Button buttonBewerbung1 = new Button("Bewerbung1", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonBewerbung1, GroupLayout.Alignment.CENTER);

        //zweite Bewerbung
        Button buttonBewerbung2 = new Button("Bewerbung2", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonBewerbung2, GroupLayout.Alignment.CENTER);

        //dritte Bewerbung
        Button buttonBewerbung3 = new Button("Bewerbung3", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonBewerbung3, GroupLayout.Alignment.CENTER);

        //nächste Bewerbung
        Button buttonBewerbungNaechste = new Button("BewerbungNächste", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonBewerbungNaechste, GroupLayout.Alignment.CENTER);

        //n-te Bewerbung
        Button buttonBewerbungN = new Button("BewerbungN", StyledEditorKit.FontSizeAction);
        layout.addComponent(buttonVerwaltung);
        layout.setComponentAlignment(buttonBewerbungN, GroupLayout.Alignment.CENTER);

        //Beim Clicken der Buttons Bewerbung(...) wird die Inhalt angezeigt Bzw ein Optionsfenster
        //wo man die o.g. Aktionen auswählen kann: Parsing oder Löschen oder Sortieren

        //Alternativ 2
        //Liste von  Bewerbungen automatisch erstellen
        Private PersonService service;

        Grid<Person> grid = new Grid<>();
        grid.addColumn(Person::userID).setCaption("UserID");
        grid.addColumn(Person::userEmail).setCaption("UserEmail");
        grid.addColumn(Person::ApplicationID).setCaption("BewerbungsID");




    }
}*/