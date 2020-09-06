package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.entities.BaseEntity;
import org.bonn.se.carlook.services.JDBCConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public abstract class GenericDAO<E extends BaseEntity> {
    JDBCConnection connection;

    protected String table;
    protected Logger logger;

    public GenericDAO() {
        connection = JDBCConnection.getInstance();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public abstract ResultSet add(E entity) throws SQLException;

    public abstract boolean update(E entity) throws SQLException;

    public abstract E select(String identifier) throws SQLException;

    public abstract boolean remove(E entity);
}
