package org.bonn.se.carlook.model.objects.dto;

import org.bonn.se.carlook.model.dao.AutoDAO;

import java.util.Date;

public class AutoDTO extends BaseDTO{

    private int autoId;
    private int preis = 5000;
    private Date baujahr;

    private String marke;
    private String beschreibung;
    private String status;




    public AutoDTO(){}

   /* public static AutoDAO getInstance() {
        return null;
    }*/

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis+1000;
    }

    public Date getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(Date baujahr) {
        this.baujahr = baujahr;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
