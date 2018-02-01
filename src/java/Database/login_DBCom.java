package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class login_DBCom {
    
    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(login_DBCom.class);
    
    //dbCommand Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    
    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public login_DBCom(){
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
    
    public boolean existingAccount(String mail, String pass){
        
        boolean success = false;
        
        try{
            
            String query = "SELECT * FROM account WHERE mail='"+mail+"' AND pass='"+pass+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                success=true;
            }else{
                success=false;
            }
            
        }catch(Exception ex){
            logger.error("dbCommands - existingAccount()");
        }
        
        return success;
    }//Check to see if the account exists
    
    public String getID(String mail){
        
        String id=null;
        
        try{
            
            String query = "SELECT acc_id FROM account WHERE mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                id=rs.getString("acc_id");
            }
            
        }catch(Exception ex){
            logger.error("login_DBCom - Could not get user id");
        }
        
        return id;
    }
    
    public String getFname(String mail){
        
        String firstname = null;
        
        try{
            String query = "SELECT fname FROM account where mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                firstname=rs.getString("fname");
            }
        }catch(Exception ex){
            logger.error("dbCommands - Could not get users firstname.");
        }
        
        return firstname;
    }//get the firstname of the users account
    
    public String getLname(String mail){
        
        String lastname = null;
        
        try{
            String query = "SELECT lname FROM account where mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                lastname=rs.getString("lname");
            }
        }catch(Exception ex){
            logger.error("dbCommands - Could not get users lastname.");
        }
        
        return lastname;
    }//get the firstname of the users account
    
    public String getDob(String mail){
        
        String dob = null;
        
        try{
            String query = "SELECT dob FROM account WHERE mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                dob=rs.getString("dob");
            }
        }catch(Exception ex){
            logger.error("dbCommands - Could not get users dob.");
        }
        
        return dob;
        
    }//get users date-of-birth
    
    public String getPhone(String mail){
        
        String phone = null;
        
        try{
            
            String query = "SELECT phone from account WHERE mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                phone=rs.getString("phone");
            }
            
        }catch(Exception ex){
            logger.error("dbCommands - Could not get users phone number.");
        }
        
        return phone;
        
    }//get users phone number
    
    public String getGender(String mail){
        
        String gender = null;
        
        try{
            
            String query = "SELECT gender FROM account WHERE mail='"+mail+"'";
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                gender=rs.getString("gender");
            }
            
        }catch(Exception ex){
            logger.error("dbCommands - Could not get users gender.");
        }
        
        return gender;
        
    }//get users gender
    
}
