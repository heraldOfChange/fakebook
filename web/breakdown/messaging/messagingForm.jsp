<%@page import="Database.getFriends_DBCom"%>
<%@page import="easeClasses.retrieveFriends"%>
<%@page import="Beans.loginBean"%>
<%@page import="java.util.ArrayList"%>
<div id="content">
    <div class="content">
        <select id="friend" onchange="getMessages()">
            <option value="default" selected disabled>Please select one of your friends</option>
            <%

                //Friend Populator
                ArrayList friends = new ArrayList();

                //Instance on the getFriends database
                getFriends_DBCom dbConn = new getFriends_DBCom();

                try {

                    dbConn.dbConnect();

                    for (Object instance : dbConn.getNames(loginBean.id)) {
                        friends.add(instance);
                    }

                    for (int i = 0; i < friends.size(); i++) {
                        out.println("<option value='" + ((retrieveFriends) friends.get(i)).getId() + "'>" + ((retrieveFriends) friends.get(i)).getFname() + ", " + ((retrieveFriends) friends.get(i)).getLname() + "</option>");
                    }

                } catch (Exception ex) {

                } finally {
                    dbConn.dbDisconnect();
                }

            %>
        </select>
        <div id="messages">
            <form id="retrieveMessages" action="getMessages" method="post">
                <input name="user_id" type="hidden" value="${lBean.id}"/>
            </form>
        </div>
    </div>
</div>