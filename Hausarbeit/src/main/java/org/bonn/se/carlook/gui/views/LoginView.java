package org.bonn.se.carlook.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.bonn.se.carlook.gui.components.Footer;
import org.bonn.se.carlook.gui.components.HeaderLoginView;
import org.bonn.se.carlook.process.control.LoginControl;
import org.bonn.se.carlook.process.control.exceptions.NoSuchUserOrPassword;
import org.bonn.se.carlook.services.util.Views;

public class LoginView extends VerticalLayout implements View {

    public LoginView(){


        HorizontalLayout horizontalHeader1 = new HeaderLoginView();
        this.addComponent(horizontalHeader1);
        this.setComponentAlignment(horizontalHeader1, Alignment.TOP_CENTER);

        HorizontalLayout footerLogin = new Footer();
        footerLogin.setHeightFull();


        Label loginLabel = new Label("Willkommen zurück!");

        final TextField userLogin = new TextField(); // final, da anonyme Klassen drauf zugreifen muessen
        userLogin.setCaption("Benutzername: ");

        final PasswordField userPassword = new PasswordField();
        userPassword.setCaption("Passwort: ");

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull(); //Statt this.setSizeFull();

        layout.addComponent(userLogin);
        layout.addComponent(userPassword);

        layout.setComponentAlignment(userLogin, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(userPassword, Alignment.MIDDLE_CENTER);

        Label label = new Label("&nbsp;", ContentMode.HTML );
        layout.addComponent(label);

        Panel panel = new Panel("Bitte Login-Daten eingeben: ");
        panel.addStyleName("login");

        this.addComponent(panel);
        this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

        panel.setContent(layout);

        Button buttonLogin = new Button("Login", FontAwesome.SIGN_IN);
        buttonLogin.addStyleName("button_login_out");
        layout.addComponent(buttonLogin);
        layout.setComponentAlignment(buttonLogin, Alignment.MIDDLE_CENTER);

        Button KundeRegister = new Button("Hier");
        Button companyRegister = new Button("Hier");

        KundeRegister.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        companyRegister.addStyleName(ValoTheme.BUTTON_BORDERLESS);

        KundeRegister.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getNavigator().navigateTo(Views.Kunde);
            }
        });

        Label notRegistered = new Label ("Noch nicht registriert? Klicke ");

        layout.addComponent(notRegistered);
        layout.addComponent(KundeRegister);
        layout.setComponentAlignment(notRegistered, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(KundeRegister, Alignment.MIDDLE_CENTER);

        panel.setSizeUndefined();

        //wenn Button geklickt wird
        buttonLogin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String benutzername = userLogin.getValue();
                String passwort = userPassword.getValue();

                try {
                    //Login-Vorgang: checkAuthentication()

                    LoginControl.getInstance().checkAuthentication(benutzername, passwort);
                    Notification.show("Erfolg!", "Erfolgreich eingeloggt", Notification.Type.HUMANIZED_MESSAGE);
                    UI.getCurrent().getNavigator().navigateTo(Views.MAIN);

                } catch (NoSuchUserOrPassword noSuchUserOrPassword) {
                    noSuchUserOrPassword.printStackTrace();

                    //Benachrichtigung über fehlerhaften Login-Vorgang
                    Notification.show("Fehler", "Benutzername oder Passwort falsch", Notification.Type.ERROR_MESSAGE);

                    //Login-Felder reseten
                    userLogin.setValue("");
                    userPassword.setValue("");
                }

            }
        });

        this.addComponent(footerLogin);
        this.setComponentAlignment(footerLogin, Alignment.BOTTOM_CENTER);

    }
}
