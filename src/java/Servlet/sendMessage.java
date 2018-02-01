package Servlet;

import Database.sendMessage_DBCom;
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
@WebServlet(name = "sendMessage", urlPatterns = {"/sendMessage"})
public class sendMessage extends HttpServlet {

    //Logger for error monitoring
    private static Log logger = LogFactory.getLog(sendMessage.class);

    //error message
    private String errorMsg = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Form Data
        String sender = request.getParameter("user_id");
        String reciever = request.getParameter("friend");
        String message = request.getParameter("message").replace("'", "");

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Date date = new Date();
        String timeNow = df.format(date);

        //Forward
        String address = "messaging.jsp";

        //Instance of getFriends
        sendMessage_DBCom dbConn = new sendMessage_DBCom();

        try {

            dbConn.dbConnect();

            if (!reciever.equals("default")) {
                if (dbConn.sendTheMessage(sender, reciever, message, timeNow)) {
                    errorMsg = "<script>alert('Successfully sent the message.');</script>";
                    request.setAttribute("message_error", errorMsg);
                    errorMsg = "";
                } else {
                    errorMsg = "<script>alert('Could not send the message.');</script>";
                    request.setAttribute("message_error", errorMsg);
                    errorMsg = "";
                }
            } else {
                errorMsg = "<script>alert('Please select a person to send this message to.');</script>";
                request.setAttribute("message_error", errorMsg);
                errorMsg = "";
            }

        } catch (Exception ex) {
            logger.error("Could not send the message: " + ex);
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

}
