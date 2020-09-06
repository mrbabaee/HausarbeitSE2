package org.bonn.se.carlook.test.util;

import org.bonn.se.carlook.model.factories.UserFactory;
import org.bonn.se.carlook.model.objects.entities.User;

public class UserBuilder extends GenericBuilder<UserBuilder, User> {

    public UserBuilder createNewUser() {
        super.entity = UserFactory.createEntity();
        return this;
    }
}
