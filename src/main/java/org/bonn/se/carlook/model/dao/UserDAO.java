package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.factories.UserFactory;
import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.model.objects.entities.User;
import org.bonn.se.carlook.services.util.Globals;

import java.sql.*;
import java.util.logging.Level;

public class UserDAO extends GenericDAO<User> {

    private static UserDAO userDAO = null;

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    private UserDAO() {
        super.table = Globals.TABLE_USER;
    }


    @Override
    public ResultSet add(User user) {

        String sql = String.format("INSERT INTO %s.%s " +
                "(registrierungsstatus, bild, passwort, strasse, hausnr, ort, " +
                        "email, telnr, vorname, nachname, anrede, geburtstag, plz, rolle) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                Globals.DATABASE_NAME,
                super.table);

        ResultSet rs = null;
        PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        try {
            stm.setBoolean(1, false); // registrierungsstatus
            stm.setBytes(2, user.getPicture()); // bild
            stm.setString(3, user.getPassword()); // password
            stm.setString(4, user.getStreet()); // strasse
            stm.setString(5, user.getStreetNumber()); // hausnr
            stm.setString(6, user.getPostalCodeArea()); // ort
            stm.setString(7, user.getEMail()); // email
            stm.setString(8, user.getPhone()); // telNr
            stm.setString(9, user.getFirstName()); // vorname
            stm.setString(10, user.getLastName()); // nachname
            stm.setString(11, user.getTitle()); // anrede
            stm.setDate(12, (Date) user.getDateOfBirth()); // geburtstag

            try {
                stm.setInt(13, user.getPostalCode() != null ? Integer.parseInt(user.getPostalCode()) : 0); // plz
            } catch(Exception ignored){}

            stm.setString(14, user.getRole());

            stm.executeUpdate();

            rs = stm.getGeneratedKeys();
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "UserDAO - Error: Error in add function!", ex);
            return null;
        }

        return rs;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public User select(String identifier) {
        User user = UserFactory.createEntity();

        String sql = String.format(
            "SELECT * " +
            "FROM %s.%s " +
            "WHERE %s = ?",
            Globals.DATABASE_NAME,
            super.table,
            Globals.TABLE_USER_EMAIL);



        try(PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            stm.setString(1, identifier);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next())
                    mapResultSetToEntity(rs, user);
            }
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "UserDAO: Error in select function!", ex);
            return null;
        }

        return user;
    }

    @Override
    public boolean remove(User entity) {
        String sql = String.format(
            "DELETE " +
            "FROM %s.%s " +
            "WHERE %s = ?",
            Globals.DATABASE_NAME,
            super.table,
            Globals.TABLE_USER_IDENTIFIER);



        try (PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            // CASCADE in sql tables should automatically delete referencing rows in student or businessman table
            // so no additional removal inside student or businessman table necessary

            stm.setInt(1, entity.getUserId());

            System.out.println(stm);

            stm.execute();
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "GenericDAO - Error in remove function for " + entity.getClass() + "!", ex);
            return false;
        }

        return true;
    }

    public boolean login(String email, String password){
        UserDTO userDTO = UserFactory.createDTO();

        String sql = String.format(
            "SELECT * " +
            "FROM %s.%s " +
            "WHERE %s = ? " +
            "AND %s = ?",
            Globals.DATABASE_NAME,
            super.table,
            Globals.TABLE_USER_EMAIL,
            Globals.TABLE_USER_PASSWORD);



        try(PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            stm.setString(1, email);
            stm.setString(2, password);

            // SQL INJECTION TEST
            //Statement stm = connection.getStatement();
            //ResultSet rs = stm.executeQuery("SELECT * FROM collahbrs.user WHERE email='" + email + "' AND passwort='" + password +"'");

            try (ResultSet rs = stm.executeQuery()) {
                if (!rs.next())
                    return false;
            }
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "UserDAO: Error in login function!", ex);
            return false;
        }
        return true;
    }

    private void mapResultSetToEntity(ResultSet rs, User entity) throws SQLException {
        // Mapping

        entity.setUserId(rs.getInt("userid"));
        entity.setTitle(rs.getString("anrede"));
        entity.setFirstName(rs.getString("vorname"));
        entity.setLastName(rs.getString("nachname"));

        entity.setEMail(rs.getString("email"));
        entity.setPassword(rs.getString("passwort"));

        entity.setDateOfBirth(rs.getDate("geburtstag"));

        entity.setStreet(rs.getString("strasse"));
        entity.setStreetNumber(rs.getString("hausnr"));
        entity.setPostalCode(rs.getString("plz"));
        entity.setPostalCodeArea(rs.getString("ort"));

        entity.setPhone(rs.getString("telnr"));

        entity.setPicture(rs.getBytes("bild"));

        entity.setRegistrationStatus(rs.getBoolean("registrierungsstatus"));

    }
}
