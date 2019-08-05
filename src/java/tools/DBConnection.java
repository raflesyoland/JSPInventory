//DBConnection.java
package tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "system";
        try {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Post establishing a DB connection - " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
