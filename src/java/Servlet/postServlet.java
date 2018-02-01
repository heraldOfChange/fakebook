package Servlet;

import Database.post_DBCom;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
@WebServlet(name = "postServlet", urlPatterns = {"/postServlet"})
public class postServlet extends HttpServlet {

    //Logger for exception monitoring
    private static Log logger = LogFactory.getLog(postServlet.class);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Instance of post_DBCom Class
        post_DBCom dbConn = new post_DBCom();
        
        //Forward
        String address = null;
        
        try{
            
            dbConn.dbConnect();
            
            String account_id=request.getParameter("current_acc");
            String name=request.getParameter("lname")+", "+request.getParameter("fname");
            String post=request.getParameter("post").replace("'", "");
            
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            Date date = new Date();
            String timeNow = df.format(date);
            
            if(dbConn.newPost(account_id, name, post, timeNow)){
                address="home.jsp";
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
            
        }catch(Exception ex){
            logger.error("postServlet - Could not post: " + ex.getMessage());
        }finally{
            dbConn.dbDisconnect();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
