<header id="header">
    <div class="header">
        <a href="index.jsp" class="logo"><img src="images/logo.png" height="auto" width="200px" /></a>
        <form class="login" action="loginServlet" method="post">
            <table>
                <tr>
                    <td>Email or Phone</td><td>Password</td>
                </tr>
                <tr>
                    <th><input name="luser" type="text" maxlength="40" size="20" required/></th><th><input name="lpass" type="password" maxlength="40" size="20" required/></th><td class="loginBtn"><input name="loginBtn" type="submit" value="Log In" /></td>
                </tr>
                <tr>
                    <td><label for="extended"><input id="extended" name="extended" type="checkbox" /> Keep me logged in</label></td><td><a href="">Forgot your password?</a></td>
                </tr>
            </table>
        </form>
    </div>
</header>