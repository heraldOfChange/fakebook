package Database;

import easeClasses.retrievePosts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
public class getPosts {

    //Logger
    private static Log logger = LogFactory.getLog(getPosts.class);

    //Variables
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;

    //<editor-fold defaultstate="collapsed" desc="REQUIRED">
    public getPosts() {

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

    public ArrayList getPosts(String id_param) {

        ArrayList posts = new ArrayList();
        int id=Integer.parseInt(id_param);
        
        try {

            String query = "SELECT * FROM posts WHERE acc_id="+id+" OR EXISTS (SELECT acc_id FROM friend_list WHERE posts.acc_id=friend_list.fri_id AND acc_id="+id+")";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                posts.add(new retrievePosts(rs.getString("name"), rs.getString("data"), rs.getString("dop")));
            }

        } catch (Exception ex) {
            logger.error("Could not get posts" + ex);
        }

        return posts;

    }//get a few posts

}
