package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class changePassword_DBCom {

    //Logger
    private static Log logger = LogFactory.getLog(changePassword_DBCom.class);

    //Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public changePassword_DBCom() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception ex) {
            logger.error("Could not find JDBC Drivers");
        }

    }//getPosts

    public void dbConnect() {

        try {

            dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanrath_fb", "root", "");
            stmt = dbConn.createStatement();

        } catch (Exception ex) {
            logger.error("Could not connect.");
        }

    }//connect to database

    public void dbDisconnect() {

        try {

            dbConn.close();

        } catch (Exception ex) {
            logger.error("Could not disconnect");
        }

    }//diconnect from database
    //</editor-fold>

    public boolean changePassword(String user_id, String password) {

        boolean success = false;

        try {

            String update = "UPDATE account SET pass='" + password + "' WHERE acc_id=" + user_id;
            stmt.executeUpdate(update);

            success = true;

        } catch (Exception ex) {
            logger.error("Could not change password: " + ex);
        }

        return success;

    }//change password

}
