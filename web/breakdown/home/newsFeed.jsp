<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="easeClasses.retrievePosts"%>
<%@page import="java.util.Collections"%>
<%@page import="Beans.loginBean"%>
<%@page import="Database.getPosts"%>
<%@page import="java.util.ArrayList"%>
<%

    Log logger = LogFactory.getLog("updater");

    //Table Populator
    ArrayList getPosts = new ArrayList();

    //Instance on the getPosts database
    getPosts dbConn = new getPosts();

    try {

        dbConn.dbConnect();

        for (Object instance : dbConn.getPosts(loginBean.id)) {
            getPosts.add((retrievePosts) instance);
        }

        Collections.reverse(getPosts);

        for (int i = 0; i < getPosts.size(); i++) {
            out.println("<div class='userPost'><footer>");
            out.println(((retrievePosts) getPosts.get(i)).getName() + "<br />");
            out.println(((retrievePosts) getPosts.get(i)).getDateOfPost());
            out.println("</footer><content>");
            out.println(((retrievePosts) getPosts.get(i)).getDetails());
            out.println("</content>");
            out.println("</div>");
        }

    } catch (Exception ex) {
        logger.info("There was an error getting the news-feed.");
    } finally {
        dbConn.dbDisconnect();
    }

%>