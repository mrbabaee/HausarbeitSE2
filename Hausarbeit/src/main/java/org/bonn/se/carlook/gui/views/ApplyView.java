package org.bonn.se.carlook.gui.views;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.HeaderMainView;
import org.bonn.se.carlook.services.util.ViewHelper;
import org.bonn.se.carlook.services.util.Views;

public class ApplyView extends UI {

    private VerticalLayout layout = new VerticalLayout();
    private Window subWindow = new Window("sub-window");

    @Override
    protected void init(VaadinRequest request) {
        //ViewHelper.isUserLoggedIn();
        addWindow(subWindow);
    }

    public ApplyView() {
        layout.setSizeFull();

        // Header
        HorizontalLayout horizontalHeader1 = new HeaderMainView();
        layout.addComponent(horizontalHeader1);
        layout.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        VerticalLayout bodylayout = new VerticalLayout();
        VerticalLayout panellayout1 = new VerticalLayout();

        Label label = new Label("Online seit:     25.06.2020 - 09:45");
        label.addStyleName("labelTitle");
        Label label1 = new Label("Job-ID:         SW-2020-05-1-3877395");
        label1.addStyleName("labelTitle");
        Label label2 = new Label("Kategorie:      Festanstellung");
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

        Label label4 = new Label("Job-Beschreibung");
        label4.addStyleName("labelStyle");
        Label label5 = new Label("Gemeinsam machen wir den Unterschied Siemens Mobility ist ein eigenständig geführtes Unternehmen der Siemens AG. Siemens Mobility ist seit über 160 Jahren ein führender Anbieter im Bereich Transportlösungen und entwickelt sein Portfolio durch Innovationen ständig weiter. Zum Kerngeschäft gehören Schienenfahrzeuge, Bahnautomatisierungs- und Elektrifizierungslösungen, schlüsselfertige Systeme, intelligente Straßenverkehrstechnik sowie die dazugehörigen Serviceleistungen. Mit der Digitalisierung ermöglicht Siemens Mobility Mobilitätsbetreibern auf der ganzen Welt, ihre Infrastruktur intelligent zu machen, eine nachhaltige Wertsteigerung über den gesamten Lebenszyklus sicherzustellen, den Fahrgastkomfort zu verbessern sowie Verfügbarkeit zu garantieren. Im Geschäftsjahr 2019, das am 30. September 2019 endete, hat die ehemalige Siemens-Division Mobility einen Umsatz von 8,9 Milliarden Euro ausgewiesen und rund 36.800 Mitarbeiter weltweit beschäftigt. Unsere Tochtergesellschaft HaCon Ingenieurgesellschaft GmbH sorgt mit innovativen Softwarelösungen dafür, dass der Verkehr reibungslos läuft und Millionen Fahrgäste optimal informiert sind. HaCons Software- und Mobilitätsspezialisten erarbeiten passgenaue Lösungen für Planungs-, Dispositions- und mobile Informationssysteme für Verkehrsunternehmen. Die preisgekrönten mobilen Informationssysteme wie z.B. der DB Navigator gehören zu den erfolgreichsten europäischen Apps und sind auf allen gängigen Plattformen vertreten. Als Teil des Siemens-Konzerns vereint HaCon die Stärken eines weltweit agierenden Unternehmens mit der Flexibilität und den Teamgeist eines innovativen Mittelständlers.Eine Einstellung erfolgt direkt bei HaCon.");
        label5.setSizeFull();
        Label label6 = new Label("Ihre Qualifikationen – fundiert und adäquat");
        label6.addStyleName("labelStyle");
        Label label7 = new Label(" Sie verfügen über einen Hochschulabschluss in Informatik oder einem vergleichbaren Studiengang. Zudem überzeugen Sie mit adäquater Berufserfahrung in der Web- oder Backendentwicklung. Sie weisen fundierte Kenntnisse im Bereich Java, Web-Service-Technologien (SOAP, ReST, WebSockets) und Parallelisierung auf. Ferner besitzen Sie Praxiserfahrung mit gängigen Frameworks und APIs wie Spring, Apache CXF, Apache Camel. Idealerweise haben Sie Erfahrungen mit Netty und mindestens einer Skriptsprache (Python, Groovy) Sie zeichnen sich durch Kenntnisse in ash sowie Linux-Standardbefehlen aus und gehen sicher mit Entwicklungsumgebungen und Tools um (Eclipse oder IntelliJ Maven, Jenkins, Git). Sie besitzen die Fähigkeit komplexe Problemstellungen zu erfassen und vielfältige Anforderungen in effiziente und modulare Standardprodukte umzusetzen.");
        label7.setSizeFull();
        Label label8 = new Label("So treten Sie mit uns in Kontakt – einfach und direkt");
        label8.addStyleName("labelStyle");
        Label label9 = new Label(" www.siemens.de/mobility wenn Sie vor Ihrer Bewerbung mehr über Siemens erfahren möchten. +49 (9131) 17- 52430 wenn Sie erste Fragen mit unserem Recruiting Team klären möchten. Ansprechpartner dieser Stellenausschreibung ist Karl-Christian Gerbaulet. www.siemens.de/karriere wenn Sie mehr Informationen zu Jobs & Karriere bei Siemens erhalten möchten. Wir legen Wert auf Chancengleichheit und freuen uns über Bewerbungen von Menschen mit Behinderung. Organisation: Siemens Mobility Unternehmen: HaCon Ingenieurgesellschaft mbH Erfahrungsniveau: Early Professional Jobtyp: Beides");

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
            Button button = new Button("Jetzt bewerben!");

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
