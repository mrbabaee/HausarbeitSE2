package org.bonn.se.carlook.process.control;
import org.bonn.se.carlook.services.JDBCConnection;

import java.sql.Connection;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import java.sql.SQLException;


public class JDBCConectionTest {

    private static JDBCConnection connection = null;

    private static Connection conn;
    String url = "jdbc:postgresql://dumbo.inf.h-brs.de/iasani2s";

    private Properties props = new Properties();

    @Test
    public void dbDriverTest() {
        System.out.println("Loading driver ...");
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Can't find the driver in the classpath!", e);
        }
    }


    @Test
    public void openConnection() throws SQLException {
    }
}
