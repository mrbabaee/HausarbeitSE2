package org.bonn.se.carlook.model.objects.entities;

import java.util.Date;

public class User extends BaseEntity{
    //TODO Dennis

    private int userId;
    private String title;
    private String firstName;
    private String lastName;

    private String eMail;
    private String password;

    private Date dateOfBirth;

    private String street;
    private String streetNumber;
    private String postalCode;
    private String postalCodeArea;

    private String phone;
    private byte[] picture;

    private boolean registrationStatus;

    private String role;


    public User(){
        this.userId = 0;
        this.title = null;
        this.firstName = null;
        this.lastName = null;
        this.eMail = null;
        this.password = null;
        this.dateOfBirth = null;
        this.street = null;
        this.streetNumber = null;
        this.postalCode = null;
        this.postalCodeArea = null;
        this.phone = null;
        this.picture = null;
        this.registrationStatus = false;
        this.role = null;
    }

    public User(int userId, String title, String firstName, String lastName,
                String eMail, String password, Date dateOfBirth, String street,
                String streetNumber, String postalCode, String postalCodeArea,
                String phone, byte[] picture, boolean registrationStatus,
                String role){
        //List<String> roles){
        this.userId = userId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.postalCodeArea = postalCodeArea;
        this.phone = phone;
        this.picture = picture;
        this.registrationStatus = registrationStatus;
        this.role = role;
    }


    // -- START GETTERS / SETTERS

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMail() {
        return this.eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return this.password;
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

    public byte[] getPicture(){
        return this.picture;
    }

    public void setPicture(byte[] picture){
        this.picture = picture;
    }

    public boolean getRegistrationStatus(){
        return this.registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus){
        this.registrationStatus = registrationStatus;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }

    // -- END GETTERS / SETTERS


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean hasRole(String role){
        if(this.role.isEmpty())
            return false;

        return this.role.equals(role);
    }
}
