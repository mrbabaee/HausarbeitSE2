package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.entities.Vertriebler;
import org.bonn.se.carlook.test.util.VertrieblerBuilder;
import org.junit.After;
import org.junit.Before;

public class VertrieblerDAOTest {
        VertrieblerDAO vertrieblerDAO = null;
        UserDAO userDAO = null;

        Vertriebler vertriebler = null;

        @Before
        public void setUp() throws Exception {
            vertrieblerDAO = VertrieblerDAO.getInstance();
            userDAO = UserDAO.getInstance();

            VertrieblerBuilder vertrieblerBuilder = new VertrieblerBuilder();

        }

        @After
        public void tearDown() throws Exception {
        }

    }