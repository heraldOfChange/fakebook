package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class signup_DBCom {
    
    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(signup_DBCom.class);
    
    //dbCommand Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    
    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public signup_DBCom(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex){
            logger.error("dbCommands - Could not locate JDBC Drivers.");
        }
    }//Constructor
    
    public void dbConnect(){
        try{
            dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanrath_fb", "root", "");
            stmt = dbConn.createStatement();
        }catch(Exception ex){
            logger.error("dbCommands - Could not connect to Database.");
        }
    }//Connect to database
    
    public void dbDisconnect(){
        try{
            dbConn.close();
        }catch(Exception ex){
            logger.error("dbCommands - Could not disconnect Database.");
        }
    }//Disconnect from database
    //</editor-fold>
    
    public boolean emailInUse(String email){
        
        boolean success = false;
        
        try{
            
            String query="SELECT * FROM account WHERE mail='"+email+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                success=true;
            }
            
        }catch(Exception ex){
            logger.error("signup_DBCom - emailInUse()");
        }
        
        return success;
        
    }//check to see if the email is in use
    
    public void addUser(String fname, String lname, String mail, String dob, String gender, String pass){
        
        try{
            
            String query = "INSERT into account(fname, lname, mail, dob, gender, pass) VALUES('"+fname+"', '"+lname+"', '"+mail+"', '"+dob+"', '"+gender+"', '"+pass+"')";
            stmt.executeUpdate(query);
            
        }catch(Exception ex){
            logger.error("signup_DBCom - Could not add new user account: " + ex.getMessage());
        }
    }//add the new user
    
}
