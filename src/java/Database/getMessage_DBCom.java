package Database;

import easeClasses.retrieveMessages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class getMessage_DBCom {

    //Logger
    private static Log logger = LogFactory.getLog(getMessage_DBCom.class);

    //Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public getMessage_DBCom() {

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
    
    public ArrayList getMessage(String sender, String reciever){
        
        ArrayList al = new ArrayList();
        
        try{
            
            String query="SELECT sender, message, time_sent FROM messages WHERE (sender="+sender+" AND reciever="+reciever+") OR (sender="+reciever+" AND reciever="+sender+");";
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                al.add(new retrieveMessages(rs.getString("sender"), rs.getString("message"), rs.getString("time_sent")));
            }
            
        }catch(Exception ex){
            logger.error("Could not get messages: " + ex.getMessage());
        }
        
        return al;
    }//get messages
    
}
