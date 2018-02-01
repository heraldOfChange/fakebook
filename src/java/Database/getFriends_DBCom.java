package Database;

import easeClasses.retrieveFriends;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class getFriends_DBCom {

    //Logger
    private static Log logger = LogFactory.getLog(getFriends_DBCom.class);

    //Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public getFriends_DBCom() {

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

    public ArrayList getNames(String id) {

        ArrayList names = new ArrayList();

        try {

            String query = "SELECT account.acc_id, account.fname, account.lname, account.mail FROM account INNER JOIN friend_list ON account.acc_id=friend_list.acc_id WHERE friend_list.fri_id="+id;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (!rs.getString("account.acc_id").equals(id)) {
                    names.add(new retrieveFriends(rs.getString("account.acc_id"), rs.getString("account.fname"), rs.getString("account.lname"), rs.getString("account.mail")));
                }
            }

        } catch (Exception ex) {
            logger.error("Could not get names:" + ex);
        }

        return names;
    }//get the list of friends

}
