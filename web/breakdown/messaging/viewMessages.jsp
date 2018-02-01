<div id="content">
    <div class="content">
        
        <table>
            <tr>
                <td><h1>Send Message</h1>
                    <form action="sendMessage" method="post">
                        <input name="user_id" type="hidden" value="${lBean.id}" />
                        <input name="friend" type="hidden" value="<%= request.getParameter("friendId") %>"/>
                        <textarea name="message" placeholder="Please type message to be sent."></textarea>
                        <input class="btn" type="submit" value="Send"/>
                    </form>
                </td>
                <td><h1>Message History</h1>
                    <%@page import="easeClasses.retrieveMessages"%>
                    <%@page import="Servlet.getMessages"%>
                    <%
                        for(Object instance : getMessages.messages){
                            out.println("<div class='message'><footer>");
                            out.println(((retrieveMessages)instance).getTimeSent()+"</footer><content>");
                            out.println(((retrieveMessages)instance).getMessage());
                            out.println("</content>");
                            out.println("</div>");
                        }
                    %>
                </td>
            </tr>
        </table>
        
    </div>
</div>