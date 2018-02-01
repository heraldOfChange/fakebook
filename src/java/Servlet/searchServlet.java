package Servlet;

import Database.search_DBCom;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* HANRATH, Martijn Jan Willem V. */
@WebServlet(name = "searchServlet", urlPatterns = {"/searchServlet"})
public class searchServlet extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(searchServlet.class);
    private String errorMsg = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //Instance of search_DBCom
        search_DBCom dbConn = new search_DBCom();
        
        //Forward
        String address = "";
        
        try{
            
            String search=request.getParameter("search").replace("'", "");
            String current_user=request.getParameter("current_acc");
            
            dbConn.dbConnect();
            if(dbConn.searchPeople(current_user, search)){
                address="home.jsp";
                //append success
                errorMsg="<script>alert('Added friend with the eMail "+search+"');</script>";
                request.setAttribute("search_error", errorMsg);
                errorMsg="";
            }else{
                address="home.jsp";
                //append error
                errorMsg="<script>alert('Could not find an account with the eMail "+search+"');</script>";
                request.setAttribute("search_error", errorMsg);
                errorMsg="";
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
            
        }catch(Exception ex){
            
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
