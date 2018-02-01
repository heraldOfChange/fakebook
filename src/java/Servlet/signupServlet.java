package Servlet;

import Database.signup_DBCom;
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
@WebServlet(name = "signupSevlet", urlPatterns = {"/signupSevlet"})
public class signupServlet extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(signupServlet.class);
    private String errorMsg = "";

    //Variable Declaration
    String fname;
    String lname;
    String email;
    String remail;
    String pass;
    String dob;
    String gender;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Instance of the signup_DBCom class
        signup_DBCom dbConn = new signup_DBCom();

        try {

            dbConn.dbConnect();

            //Forward address
            String address = null;

            //Form Data
            this.fname = request.getParameter("fname").replace("'", "");
            this.lname = request.getParameter("lname").replace("'", "");
            this.email = request.getParameter("email").replace("'", "");
            this.remail = request.getParameter("remail").replace("'", "");
            this.pass = request.getParameter("pass").replace("'", "");
            this.dob = request.getParameter("month") + "-" + request.getParameter("day") + "-" + request.getParameter("year");
            this.gender = request.getParameter("gender");

            //Check to see if email is in use
            if (dbConn.emailInUse(email) == false) {
                if (validateFields()) {
                    dbConn.addUser(fname, lname, email, dob, gender, pass);
                    address = "index.jsp";
                    //Pass on the error message
                    errorMsg = "<script>alert('Thank you for signing up with Fakebook. You now have the option to login to your account.');</script>";
                    request.setAttribute("signup_error", errorMsg);
                    errorMsg = "";
                } else {
                    address = "index.jsp";
                    //Pass on the error message
                    errorMsg += "');</script>";
                    request.setAttribute("signup_error", errorMsg);
                    request.setAttribute("fname", fname);
                    request.setAttribute("lname", lname);
                    request.setAttribute("email", email);
                    request.setAttribute("remail", remail);
                    request.setAttribute("pass", pass);
                    errorMsg = "";
                }
            } else {
                address = "index.jsp";
                //Pass on the error message
                errorMsg += "<script>alert('The eMail provided is already in use.');</script>";
                request.setAttribute("signup_error", errorMsg);
                request.setAttribute("fname", fname);
                request.setAttribute("lname", lname);
                request.setAttribute("pass", pass);
                errorMsg = "";
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            logger.error("signupServlet - Could not signup user: " + ex);
        } finally {
            dbConn.dbDisconnect();
        }
    }

    private boolean validateFields() {

        errorMsg = "<script>alert('";

        if (fname.equals("")) {
            errorMsg += "Please enter your firstname.";
            return false;
        }
        if (lname.equals("")) {
            errorMsg += "Please enter your lastname.";
            return false;
        }
        if (email.equals("")) {
            errorMsg += "Please enter your eMail address.";
            return false;
        } else if (!email.contains("@") || !email.contains(".com")) {
            errorMsg += "Please enter a valid eMail address.";
            return false;
        } else if (remail.equals("")) {
            errorMsg += "Please re-enter your eMail address";
            return false;
        } else if (!email.equals(remail)) {
            errorMsg += "Emails do not match.";
            return false;
        }
        if (pass.equals("")) {
            errorMsg += "Please enter a password.";
            return false;
        } else if (pass.length() <= 6) {
            errorMsg += "Password length does not meet minimum specifications. Please enter 7 or more characters.";
            return false;
        }
        if (dob.contains("default")) {
            errorMsg += "Please enter your birth-date.";
            return false;
        }
        if (gender.equals("")) {
            errorMsg += "Please select gender.";
            return false;
        }

        return true;

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
