package org.bonn.se.carlook.test.util;

import org.bonn.se.carlook.model.factories.UserFactory;
import org.bonn.se.carlook.model.objects.entities.User;

public class GenericBuilder<T extends GenericBuilder<T, E>, E extends User> {

    protected E entity = null;

    public T createNewUser() {
        entity = (E) UserFactory.createEntity();
        return (T) this;
    }

    public T withFirstName(String name) {
        entity.setFirstName(name);
        return (T) this;
    }

    public T withLastName(String name) {
        entity.setLastName(name);
        return (T) this;
    }

    public T withEMail(String email) {
        entity.setEMail(email);
        return (T) this;
    }

    public T withPassword(String pw) {
        entity.setPassword(pw);
        return (T) this;
    }

    public T withStreet(String street) {
        entity.setStreet(street);
        return (T) this;
    }

    public T withStreetNumber(String streetNumber) {
        entity.setStreetNumber(streetNumber);
        return (T) this;
    }

    public T withPostalCode(String postalCode) {
        entity.setPostalCode(postalCode);
        return (T) this;
    }

    public T withPostalCodeArea(String postalCodeArea) {
        entity.setPostalCodeArea(postalCodeArea);
        return (T) this;
    }

    public T withPhone(String phone) {
        entity.setPhone(phone);
        return (T) this;
    }

    public E build() {
        return entity;
    }

}
