package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.factories.VertrieblerFactory;
import org.bonn.se.carlook.model.objects.entities.Vertriebler;
import org.bonn.se.carlook.services.util.Globals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class VertrieblerDAO extends GenericDAO<Vertriebler> {
    private static VertrieblerDAO vertrieblerDAO = null;

    public static VertrieblerDAO getInstance() {
        if (vertrieblerDAO == null) {
            vertrieblerDAO = new VertrieblerDAO();
        }
        return vertrieblerDAO;
    }

    private VertrieblerDAO() {
        super.table = Globals.TABLE_COMPANY;
    }

    @Override
    public ResultSet add(Vertriebler vertriebler){

        ResultSet rs = null;

        String sql = String.format("INSERT INTO %s.%s (userId, unternehmensname, website, ansprechpartner)" +
                " VALUES (?, ?, ?, ?)",
                Globals.DATABASE_NAME, Globals.TABLE_COMPANY);

        try (PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stm.setInt(1, vertriebler.getUserId());
            stm.setString(2, vertriebler.getFirstName());
            stm.setString(3, vertriebler.getLastName());
            stm.setString(4, vertriebler.getEMail());

            stm.executeUpdate();

            rs = stm.getGeneratedKeys();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "CompanyDAO - Error in add function!", ex);
            return null;
        }

        return rs;
    }

    @Override
    public boolean update(Vertriebler entity) throws SQLException {
        return false;
    }

    @Override
    public Vertriebler select(String identifier) {
        Vertriebler vertriebler = VertrieblerFactory.createEntity();

        String sql = String.format(
                "SELECT * " +
                "FROM %s.%s " +
                "WHERE %s = ?",
                Globals.DATABASE_NAME,
                super.table,
                Globals.TABLE_COMPANY_NAME);

        try (PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, identifier);

            try (ResultSet rs = stm.executeQuery()){
                if (rs.next())
                    mapResultSetToEntity(rs, vertriebler);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "CompanyDAO: Error in select function!", ex);
            return null;
        }

        return vertriebler;
    }

    @Override
    public boolean remove(Vertriebler entity) {
        return false;
    }

    private void mapResultSetToEntity(ResultSet rs, Vertriebler entity) throws SQLException {
        entity.setVertrieblerId(rs.getInt("unternehmenid"));
        entity.setUserId(rs.getInt("userid"));
        /*entity.setCompanyName(rs.getString("unternehmensname"));
        entity.setWebsite(rs.getString("website"));
        entity.setContactPerson(rs.getString("ansprechpartner"));

         */
    }
}