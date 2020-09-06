package org.bonn.se.carlook.gui.views;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.Footer;
import org.bonn.se.carlook.gui.components.Header;
import org.bonn.se.carlook.model.objects.dto.KundeDTO;
import org.bonn.se.carlook.process.control.RegisterControl;
import org.bonn.se.carlook.process.control.exceptions.UserAlreadyRegisteredException;
import org.bonn.se.carlook.services.util.Globals;
import org.bonn.se.carlook.services.util.RegistrationResult;
import org.bonn.se.carlook.services.util.Views;
import com.vaadin.server.Page;

import java.io.File;
import java.util.List;

@Title("CarLook-Registrieren")
public class KundeRegister extends VerticalLayout implements View {


    public KundeRegister() {
       // this.setSizeFull();
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSizeFull();

        //Header
        HorizontalLayout horizontalHeader1 = new Header();
        this.addComponent(horizontalHeader1);
        this.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        //Footer
        HorizontalLayout footerLogin = new Footer();
        footerLogin.setHeightFull();

        //Layout für Formular & Bilder
        VerticalLayout verticalLayoutBody = new VerticalLayout();

        //Bild Hinzufügen
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();

        FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/image.png"));

        Image image = new Image("",resource);
        image.setWidth(1300, Unit.PIXELS);
        image.setHeight(400, Unit.PIXELS);
        //image.setSizeFull();


        //Infos vor Formular
        Label label= new Label("Jetzt registrieren!");
        label.addStyleName("label_FirmaRegister");
        Label label1= new Label("Kostenlos und schnell in nur 5 minuten!");
        label1.addStyleName("label_FirmaRegister");

        Panel panel = new Panel();
        panel.addStyleName("panel_FirmaRegister_blue");

        Label label2 = new Label("Diese Plattform ermöglicht Ihnen, Ihre gewünschte Autos schneller und einfacher zu finden, ist es nicht toll??");
        label2.addStyleName("mytitle_FirmaRegister_label");
        Label label3 = new Label(" Sie können mit uns, Zeit, Geld und Nerven sparen!!");
        label3.addStyleName("mytitle_FirmaRegister_label");
        Label label4 = new Label(  "Unsere zufriedenen Kunden zeichnen uns aus!");
        label4.addStyleName("mytitle_FirmaRegister_label");

        VerticalLayout panellayout = new VerticalLayout();

        panellayout.addComponent(label2);
        panellayout.addComponent(label3);
        panellayout.addComponent(label4);

        panel.setContent(panellayout);


        verticalLayoutBody.addComponent(image);
        verticalLayoutBody.addComponent(panel);
        verticalLayoutBody.setComponentAlignment(panel,Alignment.TOP_CENTER);
        verticalLayoutBody.addComponent(label);
        verticalLayoutBody.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        verticalLayoutBody.addComponent(label1);
        verticalLayoutBody.setComponentAlignment(label1, Alignment.BOTTOM_CENTER);

        // Registrierungsformular
        FormLayout form = new FormLayout();

        TextField tf1 = new TextField("Vorname");
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);
        TextField tf2 = new TextField("Nachname");
        tf2.setRequiredIndicatorVisible(true);
        form.addComponent(tf2);
        TextField tf3 = new TextField("E-Mail");
        tf3.setRequiredIndicatorVisible(true);
        form.addComponent(tf3);
        PasswordField tf4 = new PasswordField("Passwort");
        tf4.setRequiredIndicatorVisible(true);
        form.addComponent(tf4);
        PasswordField tf5 = new PasswordField("Passwort bestätigen");
        tf5.setRequiredIndicatorVisible(true);
        form.addComponent(tf5);

        Button button = new Button("Registrieren");

        form.addComponent(button);


        //Zweites Bild
        FileResource resource1 = new FileResource(new File(basepath +
                "/WEB-INF/images/image2.png"));

        Image image1 = new Image("",resource1);
        image1.setWidth(700, Unit.PIXELS);
        image1.setHeight(290, Unit.PIXELS);

        HorizontalLayout hlayout = new HorizontalLayout();

        hlayout.addComponent(form);
        hlayout.addComponent(image1);
        //hlayout.addComponent(image);
        //hlayout.setComponentAlignment(image,Alignment.TOP_CENTER);

        //Coll@HBRS infos
        Label label5 = new Label("Über CarLook");
        label5.addStyleName("label_FirmaRegister");

        Panel panel1 = new Panel();

        //3. Bild
        FileResource resource2 = new FileResource(new File(basepath +
                "/WEB-INF/images/image3.png"));

        Image image2 = new Image("",resource2);
        image2.setWidth(900, Unit.PIXELS);
        image2.setHeight(200, Unit.PIXELS);
        //image2.setSizeFull();

        //2.Panel
        Panel panel2 = new Panel();
        panel2.addStyleName("panel_FirmaRegister_blue");



        //6. label
        Label label6 = new Label("Unser Name CarLook steht für eine freundliche und professionelle Beratung. Wir haben es uns zum Ziel gemacht unsere Kunden langfristig zu betreuen.");
        label6.addStyleName("mytitle_FirmaRegister_label");
        Label label7 = new Label("Das bedeutet, das wir für Sie in allen Fragen rund ums Automobil für Sie ein kompetenter Ansprechpartner sind.");
        label7.addStyleName("mytitle_FirmaRegister_label");
       //Label label8 = new Label("Wir haben ständig eine vielfältige Auswahl an EU-Neufahrzeugen, Jahreswagen, Gebrauchtwagen und Nutzfahrzeugen vorrätig.");
        //label8.addStyleName("mytitle_FrimaRegister_label");


        VerticalLayout panellayout2 = new VerticalLayout();
        panellayout2.addComponent(label6);
        panellayout2.addComponent(label7);
     //   panellayout2.addComponent(label8);
        panel2.setContent(panellayout2);


        //LAYOUT
        verticalLayoutBody.addComponent(hlayout);
        verticalLayoutBody.addComponent(label5);
        verticalLayoutBody.setComponentAlignment(label5, Alignment.MIDDLE_CENTER);
        verticalLayoutBody.addComponent(panel1);
        verticalLayoutBody.addComponent(image2);
        verticalLayoutBody.setComponentAlignment(image2,Alignment.MIDDLE_CENTER);
        verticalLayoutBody.addComponent(panel2);
        verticalLayoutBody.setComponentAlignment(panel2, Alignment.MIDDLE_CENTER);


        layout.addComponent(verticalLayoutBody);

        this.addComponent(layout);

        //Button Implementierung

         button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                RegisterControl reg = RegisterControl.getInstance();
                KundeDTO kunde = new KundeDTO();

                kunde.setFirstName(tf1.getValue());
                kunde.setLastName(tf2.getValue());
                kunde.setEMail(tf3.getValue());
                kunde.setPassword(tf4.getValue());
                kunde.setPassword(tf5.getValue());

                if (!tf5.getValue().equals(tf4.getValue())) {
                    Notification.show("Das Passwort muss identisch sein! ", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                RegistrationResult<KundeDTO> result = null;

                try{
                    result = reg.registerUser(kunde);
                } catch (UserAlreadyRegisteredException e) {
                    Notification notification= new  Notification("Fehler",
                            "Dieser Benutzer ist bereits registriert!",
                            Notification.Type.ERROR_MESSAGE);
                    notification.setDelayMsec(5000);
                    notification.show(Page.getCurrent());

                    tf1.clear(); tf2.clear(); tf3.clear(); tf4.clear(); tf5.clear();

                    return;
                }



                String fehler = "";

                if(result.getResult()) {
                    Notification notification= new  Notification("Erfolg",
                            "Die Registration war erfolgreich!", Notification.Type.HUMANIZED_MESSAGE);
                    notification.setDelayMsec(5000);
                    notification.show(Page.getCurrent());

                    UI.getCurrent().getSession().setAttribute(Globals.CURRENT_USER,
                            result.getRegisteredUserDTO());

                    UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
                }
                else{
                   List<RegistrationResult.FailureType> failList = result.getReasons();
                   for (RegistrationResult.FailureType item : failList) {
                       System.out.println(item);

                    /*   if(failList.contains(RegistrationResult.FailureType.FIRSTNAME_MISSING) ){
                           fehler = "Nachname fehlt";
                       } if(failList.contains( RegistrationResult.FailureType.LASTNAME_MISSING)){
                               fehler+= ", Vorname fehlt";
                       } if(failList.contains( RegistrationResult.FailureType.EMAIL_MISSING)){
                                   fehler+= ", Email fehlt";
                       }   if(failList.contains( RegistrationResult.FailureType.PASSWORD_MISSING)){
                                       fehler+= ", Passwort fehlt.";

                       }
                       else {
                           fehler="Bitte alle Feldern ausfühlen";
                       }*/
                      if (tf1.isEmpty() || tf2.isEmpty() || tf3.isEmpty() || tf4.isEmpty() ){
                           fehler="Bitte füllen Sie alle mit '*' markierten Felder aus!";
                      }

                      /*    else if(tf1.isEmpty()){
                           fehler = "Nachname fehlt";
                      }
                        else if(tf2.isEmpty()){
                           fehler = "Vorname fehlt";
                      }
                         else if (){
                             fehler = "FEHLER";
                    }*/
                      Notification notification= new  Notification(fehler, Notification.Type.ERROR_MESSAGE);
                      notification.setDelayMsec(5000);
                      notification.show(Page.getCurrent());

                   }
                  // Notification.show("Kein Erfolg!", "Nicht Erfolgreich ", Notification.Type.ERROR_MESSAGE);
                }
            }
         });

        this.addComponent(footerLogin);
        this.setComponentAlignment(footerLogin, Alignment.BOTTOM_CENTER);
    }
}