<div id="mainContent">
    <div class="mainContent">
        <form action="changePassword" method="post">
            <input name="user_id" type="hidden" value="${lBean.id}" />
            <input name="old_pass" type="hidden" value="${lBean.password}" />
            <table>
                <tr><td><input class="text" name="old_password" type="password" placeholder="Enter Old Password" maxlength="40" size="20" /></td></tr>
                <tr><td><input class="text" name="password" type="password" placeholder="Enter New Password" maxlength="40" size="20" /></td></tr>
                <tr><td><input class="btn" name="changeBtn" type="submit" value="Change Password" /></td></tr>
            </table>
        </form>
    </div>
</div>