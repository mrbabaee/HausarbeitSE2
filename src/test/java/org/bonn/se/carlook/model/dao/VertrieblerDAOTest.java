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
           // company = companyBuilder.createNewCompany();
            //CompanyBuilder.withFirstName("TestFirstName").
                   // withLastName("TestLastName").
                  //  withEMail("TestEMail").
                  //  withPassword("12345").
                 //   withPostalCode("12345").
                  //  build();
        }

        @After
        public void tearDown() throws Exception {
        }

        /*@Test
        public void testCompanyDAOCoverage() {
            companyDAO = CompanyDAO.getInstance();
            assertNotNull(companyDAO);

            ResultSet rs = companyDAO.add(company);
            assertNotNull(rs);

            // User userTest = companyDAO.select(company.getEMail());

            company.setCompanyId(company.getUserId());

            boolean loginSuccess = userDAO.login(company.getEMail(), company.getPassword());
            assertTrue(loginSuccess);

            boolean removeSuccess = companyDAO.remove(company);
            assertTrue(removeSuccess);
        }*/
    }