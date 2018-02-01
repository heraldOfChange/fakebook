package Servlet;

import Database.changePassword_DBCom;
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
@WebServlet(name = "changePassword", urlPatterns = {"/changePassword"})
public class changePassword extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(changePassword.class);

    //error message
    private String errorMsg = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Form Data
        String user_id = request.getParameter("user_id");
        String old_pass = request.getParameter("old_pass").replace("'", "");
        String old_password = request.getParameter("old_password").replace("'", "");
        String password = request.getParameter("password").replace("'", "");

        //Forward
        String address = "change_password.jsp";

        //Instance of the changePassword_DBCom
        changePassword_DBCom dbConn = new changePassword_DBCom();

        try {

            dbConn.dbConnect();

            if (old_pass.equals(old_password)) {
                if (validations(old_password)) {
                    if (dbConn.changePassword(user_id, password)) {
                        errorMsg = "<script>alert('Password has been changed.')</script>";
                        request.setAttribute("changePass_error", errorMsg);
                        errorMsg = "";
                    }
                } else {
                    errorMsg = "<script>alert('Password must be 7 or more characters.')</script>";
                    request.setAttribute("changePass_error", errorMsg);
                    errorMsg = "";
                }
            } else {
                errorMsg = "<script>alert('Old password is incorrect.')</script>";
                request.setAttribute("changePass_error", errorMsg);
                errorMsg = "";
            }

        } catch (Exception ex) {
            logger.error("Could not change password: " + ex);
        } finally {
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

    public boolean validations(String old_password) {

        if (old_password.length() <= 6) {
            return false;
        }

        return true;

    }

}
