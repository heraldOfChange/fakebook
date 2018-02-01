package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class sendMessage_DBCom {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(sendMessage_DBCom.class);

    //dbCommand Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public sendMessage_DBCom() {
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

    public boolean sendTheMessage(String sender, String reciever, String message, String timeSent) {

        boolean success = false;

        try {

            String query = "INSERT INTO messages(`sender`, `reciever`, `message`, `time_sent`) VALUES('" + sender + "', '" + reciever + "', '" + message + "', '"+timeSent+"')";
            stmt.executeUpdate(query);

            success = true;

        } catch (Exception ex) {
            logger.error("Could not send message: " + ex.getMessage());
        }

        return success;

    }

}
