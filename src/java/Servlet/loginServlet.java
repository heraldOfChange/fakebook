package Servlet;

import Beans.loginBean;
import Database.login_DBCom;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(loginServlet.class);
    private String errorMsg = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Instance of login_DBCom Class
        login_DBCom dbConn = new login_DBCom();

        try {

            dbConn.dbConnect();

            //Forward address
            String address = null;

            //Form Data
            String mail = request.getParameter("luser").replace("'", "");
            String password = request.getParameter("lpass").replace("'", "");

            if ((mail == null || mail.equals("")) && (password == null || password.equals(""))) {
                errorMsg += "<script>alert('Please provide a Username & Password.');</script>";
                request.setAttribute("login_error", errorMsg);
                errorMsg = "";
            } else {
                //Check to see if account exists & has matching username&password
                if (dbConn.existingAccount(mail, password)) {

                    //Create a Bean and add Data to it
                    loginBean lBean = new loginBean();
                    lBean.setMail(mail);
                    lBean.setPassword(password);
                    lBean.setId(dbConn.getID(mail));
                    lBean.setFirstname(dbConn.getFname(mail));
                    lBean.setLastname(dbConn.getLname(mail));
                    lBean.setDob(dbConn.getDob(mail));
                    lBean.setPhone(dbConn.getPhone(mail));
                    lBean.setGender(dbConn.getGender(mail));

                    request.getSession().setAttribute("lBean", lBean);
                    address = "home.jsp";

                } else {
                    address = "index.jsp";
                    errorMsg += "<script>alert('Invalid Username or Password.');</script>";
                    request.setAttribute("login_error", errorMsg);
                    errorMsg = "";
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }

        } catch (Exception ex) {
            logger.error("loginServlet - Could not login user" + ex);
        } finally {
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
