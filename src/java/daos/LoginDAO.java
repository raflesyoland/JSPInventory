//LoginDao.java
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.LoginBean;
import tools.DBConnection;

public class LoginDAO {

    public String authenticateUser(LoginBean loginBean) {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password,role_id from INVENTORY.admin");
            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role_id");
                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("1")) {
                    return "Admin_Role";
                } else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("2")) {
                    return "Editor_Role";
                } else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("3")) {
                    return "User_Role";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
