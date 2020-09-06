package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.factories.KundeFactory;
import org.bonn.se.carlook.model.objects.entities.Kunde;
import org.bonn.se.carlook.services.util.Globals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class KundeDAO extends GenericDAO<Kunde>{

    private static KundeDAO kundeDAO = null;

    public static KundeDAO getInstance() {
        if (kundeDAO == null) {
            kundeDAO = new KundeDAO();
        }
        return kundeDAO;
    }

    private KundeDAO() {
        super.table = Globals.TABLE_STUDENT;
    }

    @Override
    public ResultSet add(Kunde kunde) {
        ResultSet rs = null;

        String sql = String.format(
            "INSERT INTO %s.%s " +
            "(%s, %s)" +
            "VALUES (?, ?)",
            Globals.DATABASE_NAME,
            super.table,
            Globals.TABLE_USER_IDENTIFIER,
            Globals.TABLE_STUDENT_INTRODUCTION);

        PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            stm.setInt(1, kunde.getUserId());
            stm.setString(2, kunde.getIntroduction());

            stm.executeUpdate();

            rs = stm.getGeneratedKeys();
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "KundeDAO: Error in add function!", ex);
            return null;
        }

        return rs;
    }

    @Override
    public boolean update(Kunde entity) throws SQLException {
        return false;
    }

    @Override
    public Kunde select(String identifier) {
        Kunde kunde = KundeFactory.createEntity();

        String sql = String.format(
            "SELECT * " +
            "FROM %s.%s " +
            "WHERE %s = ?" +
            "INNER JOIN %s" +
            "ON %s = %s",
            Globals.DATABASE_NAME,
            super.table,
            Globals.TABLE_STUDENT_IDENTIFIER,
            Globals.TABLE_USER,
            Globals.TABLE_USER + "." + Globals.TABLE_USER_IDENTIFIER,
            Globals.TABLE_STUDENT + "." + Globals.TABLE_USER_IDENTIFIER);

        try(PreparedStatement stm = connection.getPreparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            stm.setString(1, identifier);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next())
                    mapResultSetToEntity(rs, kunde);
            }
        } catch(SQLException ex){
            logger.log(Level.SEVERE, "UserDAO: Error in select function!", ex);
            return null;
        }

        return kunde;
    }

    @Override
    public boolean remove(Kunde entity) {
        return false;
    }

    private void mapResultSetToEntity(ResultSet rs, Kunde entity) throws SQLException {
        entity.setKundeId(rs.getInt("kundeid"));
        entity.setUserId(rs.getInt("userid"));
        entity.setIntroduction(rs.getString("kurvorstellung"));
    }
}
