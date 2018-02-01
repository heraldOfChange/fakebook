package Servlet;

import Database.getMessage_DBCom;
import easeClasses.retrieveMessages;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
@WebServlet(name = "getMessages", urlPatterns = {"/getMessages"})
public class getMessages extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(getMessages.class);
    
    //error message
    private String errorMsg=null;
    
    //messages
    public static ArrayList messages;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Form Data
        String reciever=request.getParameter("user_id");
        String sender=request.getParameter("friendId");
        
        logger.warn(reciever);
        logger.warn(sender);
        
        //Forward
        String address="viewMessages.jsp";
        
        //Instance of the getMessage_DBCom
        getMessage_DBCom dbConn = new getMessage_DBCom();
        
        try{
            
            messages=new ArrayList();
            
            dbConn.dbConnect();
            
            messages=dbConn.getMessage(sender, reciever);
            
            if(!messages.isEmpty())
                request.setAttribute("fromWhom", ((retrieveMessages)messages.get(0)).getSender());
            
        }catch(Exception ex){
            logger.error("Could not get messages: " + ex);
        }finally{
            dbConn.dbDisconnect();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
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
