package org.bonn.se.carlook.gui.views;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import org.bonn.se.carlook.gui.components.Footer;
import org.bonn.se.carlook.gui.components.Header;
import org.bonn.se.carlook.model.objects.dto.VertrieblerDTO;
import org.bonn.se.carlook.process.control.RegisterControl;
import org.bonn.se.carlook.process.control.exceptions.CompanyAlreadyRegisteredException;
import org.bonn.se.carlook.process.control.exceptions.UserAlreadyRegisteredException;
import org.bonn.se.carlook.services.util.GlobalHelper;
import org.bonn.se.carlook.services.util.Globals;
import org.bonn.se.carlook.services.util.RegistrationResult;
import org.bonn.se.carlook.services.util.Views;

import java.io.File;

@Title("CarLook-Registrieren")
public class VertrieblerRegister extends VerticalLayout implements View {


    public VertrieblerRegister() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSizeFull();


        HorizontalLayout horizontalHeader1 = new Header();
        this.addComponent(horizontalHeader1);
        this.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        //Footer
        HorizontalLayout footerLogin = new Footer();
        footerLogin.setHeightFull();

        // Registrierungsformular
        VerticalLayout verticalLayoutBody = new VerticalLayout();

        //Bild Hinzufügen

        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();

        FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/image4.png"));

        Image image = new Image("",resource);

        image.setWidth("100%");


        //ICONS
        Label lab = new Label("So einfach geht's :");
        lab.addStyleName("label_FirmaRegister");

        HorizontalLayout iconlayout = new HorizontalLayout();

        Button button1 = new Button("Sich registrieren");
        button1.setIcon(FontAwesome.USERS);
        button1.addStyleName("mystyle");

        Button button2 = new Button("Aktuelles");
        button2.setIcon(FontAwesome.EDIT);
        button2.addStyleName("mystyle");

        Button button3 = new Button("Services");
        button3.setIcon(FontAwesome.INFO);
        button3.addStyleName("mystyle");


        iconlayout.addComponent(button1);
        iconlayout.addComponent(button2);
        iconlayout.addComponent(button3);

        iconlayout.setWidth("100%");

        Panel panel =new Panel();

       //Registrierungsformular

        Label label = new Label("Allgemein");
        label.addStyleName("panel_FirmaRegister_small");
        label.setWidth("100%");

        FormLayout form2 = new FormLayout();

        HorizontalLayout anredeLayout= new HorizontalLayout();

        Label label2 = new Label("Anrede");
        CheckBox checkbox1 = new CheckBox("Frau");
        CheckBox checkbox2 = new CheckBox("Herr");

        checkbox1.addValueChangeListener(event ->
                checkbox2.setValue(! checkbox1.getValue()));

        checkbox2.addValueChangeListener(event ->
                checkbox1.setValue(! checkbox2.getValue()));

        anredeLayout.addComponent(label2);
        anredeLayout.addComponent(checkbox1);
        anredeLayout.addComponent(checkbox2);

        form2.addComponent(anredeLayout);


        NativeSelect<String> select1 = new NativeSelect<>("Anrede");
        select1.setItems("Bitte auswählen", "Herr", "Frau");
        select1.setValue("Bitte auswählen");
        form2.addComponent(select1);

        TextField tf11 = new TextField("Nachname");
        tf11.setRequiredIndicatorVisible(true);
        form2.addComponent(tf11);
        TextField tf12 = new TextField("Vorname");
        tf12.setRequiredIndicatorVisible(true);
        form2.addComponent(tf12);

        FormLayout form = new FormLayout();
        TextField tf1 = new TextField("Email");
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);
        PasswordField tf2 = new PasswordField("Passwort");
        tf2.setRequiredIndicatorVisible(true);
        form.addComponent(tf2);
        PasswordField tf3 = new PasswordField("Passwort bestätigen");
        tf3.setRequiredIndicatorVisible(true);
        form.addComponent(tf3);

        FormLayout form1 = new FormLayout();

        /*TextField tf4 = new TextField("Firma");
        tf4.setRequiredIndicatorVisible(true);
        form1.addComponent(tf4);
        TextField tf5 = new TextField("Abteilung");
        form1.addComponent(tf5);

        TextField tf9 = new TextField("Straße");
        tf9.setRequiredIndicatorVisible(true);
        form1.addComponent(tf9);
        TextField tf6 = new TextField("Hausnummer");
        tf6.setRequiredIndicatorVisible(true);
        form1.addComponent(tf6);
        TextField tf7 = new TextField("PLZ");
        tf7.setRequiredIndicatorVisible(true);
        form1.addComponent(tf7);
        TextField tf8 = new TextField("Ort");
        tf8.setRequiredIndicatorVisible(true);
        form1.addComponent(tf8);

         */
        NativeSelect<String> select = new NativeSelect<>("Land");
        select.setItems("Deutschland", "Frankreich" , "Belgien", "Italien", "Spanien","Österreich");
        select.setValue("Deutschland");
        form1.addComponent(select);
        /*TextField tf10 = new TextField("Webseite");
        form1.addComponent(tf10);

        Label label1= new Label("Kontaktdaten");
        label1.addStyleName("panel_FirmaRegister_small");
        label1.setWidth("100%");




        FormLayout form2 = new FormLayout();

      HorizontalLayout anredeLayout= new HorizontalLayout();

        Label label2 = new Label("Anrede");
        CheckBox checkbox1 = new CheckBox("Frau");
        CheckBox checkbox2 = new CheckBox("Herr");

        checkbox1.addValueChangeListener(event ->
                checkbox2.setValue(! checkbox1.getValue()));

        checkbox2.addValueChangeListener(event ->
                checkbox1.setValue(! checkbox2.getValue()));

        anredeLayout.addComponent(label2);
        anredeLayout.addComponent(checkbox1);
        anredeLayout.addComponent(checkbox2);

        form2.addComponent(anredeLayout);


        NativeSelect<String> select1 = new NativeSelect<>("Anrede");
        select1.setItems("Bitte auswählen", "Herr", "Frau");
        select1.setValue("Bitte auswählen");
        form2.addComponent(select1);

        TextField tf11 = new TextField("Nachname");
        tf11.setRequiredIndicatorVisible(true);
        form2.addComponent(tf11);
        TextField tf12 = new TextField("Vorname");
        tf12.setRequiredIndicatorVisible(true);
        form2.addComponent(tf12);
        TextField tf13 = new TextField("Telefon");
        tf13.setRequiredIndicatorVisible(true);
        form2.addComponent(tf13);
        TextField tf14 = new TextField("Fax");
        form2.addComponent(tf14);

         */


        Button button = new Button("Registrieren", FontAwesome.SIGN_IN);
        button.addStyleName("button_login_out");

        //LAYOUT


        verticalLayoutBody.addComponent(image);
        verticalLayoutBody.addComponent(lab);
        verticalLayoutBody.addComponent(iconlayout);
        verticalLayoutBody.addComponent(panel);
        verticalLayoutBody.addComponent(form);
        verticalLayoutBody.addComponent(label);
        verticalLayoutBody.addComponent(form1);
        //verticalLayoutBody.addComponent(label1);
        verticalLayoutBody.addComponent(form2);
        verticalLayoutBody.addComponent(button);
        verticalLayoutBody.setComponentAlignment(button, Alignment.MIDDLE_CENTER);


        //layout.addComponent(barmenu);
        //layout.setComponentAlignment(barmenu, Alignment.TOP_CENTER);

        layout.addComponent(verticalLayoutBody);

        this.addComponent(layout);

        //Button Implementierung

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (!tf3.getValue().equals(tf2.getValue())) {
                    Notification.show("Passwort muss gleich sein! ", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                RegisterControl reg = RegisterControl.getInstance();
                VertrieblerDTO vertrieblerDTO = new VertrieblerDTO();

                vertrieblerDTO.setFirstName(tf12.getValue());
                vertrieblerDTO.setLastName(tf11.getValue());
                vertrieblerDTO.setEMail(tf1.getValue());
                vertrieblerDTO.setPassword(tf2.getValue());
                vertrieblerDTO.setPassword(tf3.getValue());
                /*companyDTO.setCountry(tf9.getValue());
                vertrieblerDTO.setPhone(tf13.getValue());
                vertrieblerDTO.setPostalCode(tf7.getValue());
                vertrieblerDTO.setStreet(tf9.getValue());
                vertrieblerDTO.setWebsite(tf10.getValue());
                vertrieblerDTO.setStreetNumber(tf6.getValue());
                vertrieblerDTO.setPostalCodeArea(tf8.getValue());
                vertrieblerDTO.setContactPerson(tf12.getValue() + " " + tf11.getValue());
                vertrieblerDTO.setCompanyName(tf4.getValue());

                 */

                RegistrationResult<VertrieblerDTO> result = null;

                try{
                    result = reg.registerCompany(vertrieblerDTO);
                } catch (UserAlreadyRegisteredException e) {
                    Notification notification= new  Notification("Fehler",
                            "Dieser Benutzer ist bereits registriert!", Notification.Type.ERROR_MESSAGE);
                    notification.setDelayMsec(5000);
                    notification.show(Page.getCurrent());
                    return;
                } catch (CompanyAlreadyRegisteredException e) {
                    Notification notification= new  Notification("Fehler",
                            "Das Unternehmen ist bereits registriert!", Notification.Type.ERROR_MESSAGE);
                    notification.setDelayMsec(5000);
                    return;
                }

                String registrationErrors = "";

                if(result.getResult()) {
                    Notification notification= new  Notification("Erfolg", "Die Registration war erfolgreich!", Notification.Type.HUMANIZED_MESSAGE);
                    notification.setDelayMsec(5000);
                    notification.show(Page.getCurrent());

                    UI.getCurrent().getSession().setAttribute(Globals.CURRENT_USER,
                            result.getRegisteredUserDTO());

                    UI.getCurrent().getNavigator().navigateTo(Views.MAIN);}
                else{

                    for(RegistrationResult.FailureType fail : result.getReasons()){
                        if(GlobalHelper.StringIsEmptyOrNull(registrationErrors))
                            registrationErrors += fail.name();
                        else
                            registrationErrors += ", " + fail.name();
                    }

                    /*List<RegistrationResult.FailureType> failList = result.getReasons();

                    if(failList.contains(RegistrationResult.FailureType.FIRSTNAME_MISSING) )
                        registrationErrors = "Nachname fehlt";
                    if(failList.contains( RegistrationResult.FailureType.LASTNAME_MISSING))
                        registrationErrors+= ", Vorname fehlt";
                    if(failList.contains( RegistrationResult.FailureType.EMAIL_MISSING))
                        registrationErrors+= ", Email fehlt";
                    if(failList.contains( RegistrationResult.FailureType.PASSWORD_MISSING))
                        registrationErrors+= ", Passwort fehlt.";

                    else {
                       registrationErrors="Bitte füllen Sie alle Felder aus!";
                    }

                    if (tf1.isEmpty() || tf2.isEmpty() || tf3.isEmpty() || tf4.isEmpty() || tf6.isEmpty() || tf7.isEmpty() || tf8.isEmpty()|| tf11.isEmpty() || tf12.isEmpty() || tf13.isEmpty() || select.isEmpty() ){
                        registrationErrors="Bitte füllen Sie alle mit '*' markierten Felder aus!";

                     */
                    }

                    Notification notification= new  Notification(registrationErrors, Notification.Type.ERROR_MESSAGE);
                    notification.setDelayMsec(10000);
                    notification.show(Page.getCurrent());
                    // Notification.show("Kein Erfolg!", "Nicht Erfolgreich ", Notification.Type.ERROR_MESSAGE);
                }
            });
        this.addComponent(footerLogin);
        this.setComponentAlignment(footerLogin, Alignment.BOTTOM_CENTER);
        }

    }
