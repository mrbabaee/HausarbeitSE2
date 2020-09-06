package org.bonn.se.carlook.model.objects.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO extends BaseDTO implements Serializable {
    // TODO: Dennis

    protected String title;
    protected String firstName;
    protected String lastName;

    protected String eMail;
    protected String password;

    protected Date dateOfBirth;

    protected String street;
    protected String streetNumber;
    protected String postalCode;
    protected String postalCodeArea;

    protected String phone;

    protected byte[] picture;

    protected String role;


    public UserDTO(){
        this.title = null;
        this.firstName = null;
        this.lastName = null;
        this.eMail = null;
        this.street = null;
        this.streetNumber = null;
        this.postalCode = null;
        this.postalCodeArea = null;
        this.phone = null;
        this.dateOfBirth = null;
        this.picture = null;
        this.role = null;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCodeArea() {
        return postalCodeArea;
    }

    public void setPostalCodeArea(String postalCodeArea) {
        this.postalCodeArea = postalCodeArea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPicture() {
        //TODO
        return new byte[0];
    }

    public void setPicture() {
        //TODO
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
