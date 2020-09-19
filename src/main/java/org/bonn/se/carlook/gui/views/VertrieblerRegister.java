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
import org.bonn.se.carlook.process.control.exceptions.VertrieblerSchonRegistriertException;
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

        //FormLayout form = new FormLayout();
        TextField tf1 = new TextField("Email");
        tf1.setRequiredIndicatorVisible(true);
        form2.addComponent(tf1);
        PasswordField tf2 = new PasswordField("Passwort");
        tf2.setRequiredIndicatorVisible(true);
        form2.addComponent(tf2);
        PasswordField tf3 = new PasswordField("Passwort bestätigen");
        tf3.setRequiredIndicatorVisible(true);
        form2.addComponent(tf3);



        Button button = new Button("Registrieren", FontAwesome.SIGN_IN);
        button.addStyleName("button_login_out");

        //LAYOUT


        verticalLayoutBody.addComponent(image);
        verticalLayoutBody.addComponent(lab);
        verticalLayoutBody.addComponent(iconlayout);
        verticalLayoutBody.addComponent(panel);
        //verticalLayoutBody.addComponent(form);
        verticalLayoutBody.addComponent(label);
        //verticalLayoutBody.addComponent(form1);
        //verticalLayoutBody.addComponent(label1);
        verticalLayoutBody.addComponent(form2);
        verticalLayoutBody.addComponent(button);
        verticalLayoutBody.setComponentAlignment(button, Alignment.MIDDLE_CENTER);



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


                RegistrationResult<VertrieblerDTO> result = null;

                try{
                    result = reg.registerCompany(vertrieblerDTO);
                } catch (UserAlreadyRegisteredException e) {
                    Notification notification= new  Notification("Fehler",
                            "Dieser Benutzer ist bereits registriert!", Notification.Type.ERROR_MESSAGE);
                    notification.setDelayMsec(5000);
                    notification.show(Page.getCurrent());
                    return;
                } catch (VertrieblerSchonRegistriertException e) {
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
