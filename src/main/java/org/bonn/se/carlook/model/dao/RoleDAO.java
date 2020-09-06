package org.bonn.se.carlook.model.dao;

import org.bonn.se.carlook.model.objects.dto.RoleDTO;
import org.bonn.se.carlook.model.objects.entities.User;

import java.util.List;

public class RoleDAO {

    // roleDAO cannot be final, because its initliazied inside the getInstance method
    private static RoleDAO roleDAO = null;

    public static RoleDAO getInstance() {
        if (roleDAO == null) {
           // roleDAO = new RoleDAO();
        }
        return roleDAO;
    }

    private RoleDAO(){

    }

    public List<RoleDTO> getRolesForUser(User user) {

        List<RoleDTO> roleDTOS = null;

        /*try {
            PreparedStatement statement = JDBCConnection.getInstance().getPreparedStatement(
                    "SELECT * "
                    +   "FROM " + DATABASE_NAME + "." + DB_TABLES_USERROLES + " "
                    +   "WHERE ? = ?"
            );

            // statement.setString(1, ...);
        } catch (SQLException ex){
            if(DEBUG_MODE)
                Logger.getAnonymousLogger().log(Level.SEVERE, "An SQLException was thrown during getRolesForUser().", ex);
        }*/

        return roleDTOS;
    }
}
