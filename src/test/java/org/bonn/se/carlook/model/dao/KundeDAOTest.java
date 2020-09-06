package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.entities.Kunde;
import org.bonn.se.carlook.test.util.KundeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KundeDAOTest {

    KundeDAO kundeDAO = null;

    Kunde kunde = null;

    @Before
    public void setUp() throws SQLException {
        kundeDAO = KundeDAO.getInstance();

        KundeBuilder kundeBuilder = new KundeBuilder();
        kunde = kundeBuilder.createNewStudent().
                withFirstName("Hallo").build();
    }

    @After
    public void tearDown() {
    }


    @Test
    public void TestAGetInstance() {
        kundeDAO = KundeDAO.getInstance();
        assertNotNull(kundeDAO);
    }

    @Test
    public void testKundeDAOCoverage() {

    }
}
