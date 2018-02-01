<header id="header">
    <div class="header">
        <table class="quickLinks">
            <tr>
                <td><h1>fakebook</h1><a href="home.jsp"><img src="images/icons/people.png"/></a><a href="messaging.jsp"><img src="images/icons/closed.png"/></a></td>
                <td><form class="search" action="searchServlet" method="post"><input class="searchBar" name="search" type="text" placeholder="Search for people, places or things" maxlength="40" size="40"/><input name="current_acc" type="hidden" value="${lBean.id}"/><input class="searchBtn" name="searchBtn" type="submit" value="Search"/></form></td>
                <td class="accountSettings"><a href="change_password.jsp">Change Password</a><a href="logoutServlet">Log Out</a></td>
            </tr>
        </table>
    </div>
</header>