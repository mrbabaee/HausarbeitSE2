package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.entities.User;
import org.bonn.se.carlook.test.util.UserBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {

    UserDAO userDAO = null;

    User user = null;

    @Before
    public void setUp() throws SQLException {
        userDAO = userDAO.getInstance();

        UserBuilder userBuilder = new UserBuilder();
        user = userBuilder.createNewUser().
                withFirstName("TestFirstName").
                withLastName("TestLastName").
                withEMail("TestEMail").
                withPassword("12345").
                withPostalCode("12345").
                build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAGetInstance() {
        userDAO = UserDAO.getInstance();
        assertNotNull(userDAO);
    }

    @Test
    public void testUserDAOCoverage() {
        // add user
        ResultSet rs = userDAO.add(user);
        assertNotNull(rs);

        // select user
        User userTest = userDAO.select(user.getEMail());
        user.setUserId(userTest.getUserId());
        assertNotNull(userTest);

        // login with user credentials
        boolean loginSuccess = userDAO.login(user.getEMail(), user.getPassword());
        assertTrue(loginSuccess);

        // remove user from database
        boolean removeSuccess = userDAO.remove(user);
        assertTrue(removeSuccess);
    }
}