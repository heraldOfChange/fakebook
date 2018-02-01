package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class search_DBCom {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(search_DBCom.class);

    //dbCommand Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public search_DBCom() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            logger.error("dbCommands - Could not locate JDBC Drivers.");
        }
    }//Constructor

    public void dbConnect() {
        try {
            dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanrath_fb", "root", "");
            stmt = dbConn.createStatement();
        } catch (Exception ex) {
            logger.error("dbCommands - Could not connect to Database.");
        }
    }//Connect to database

    public void dbDisconnect() {
        try {
            dbConn.close();
        } catch (Exception ex) {
            logger.error("dbCommands - Could not disconnect Database.");
        }
    }//Disconnect from database
    //</editor-fold>

    public boolean searchPeople(String acc_id, String search) {

        boolean success = false;

        try {

            String query = "SELECT acc_id FROM account WHERE mail='" + search + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                String add = "INSERT INTO friend_list VALUES(" + Integer.parseInt(acc_id) + ", '" + Integer.parseInt(rs.getString("acc_id")) + "', 'FRIENDS')";
                String add2 = "INSERT INTO friend_list VALUES('" + Integer.parseInt(rs.getString("acc_id")) + "'," + Integer.parseInt(acc_id) + ", 'FRIENDS')";
                stmt.executeUpdate(add);
                stmt.executeUpdate(add2);
                success = true;
            }

        } catch (Exception ex) {
            logger.error("search_DBCom - Could not find user" + ex);
        }

        return success;
    }//search for people

}
