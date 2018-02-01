<div id="content">
    <div class="content">
        <aside class="advert">
            <p>
            <footer>
                <h1><b:message key="advert.title" /></h1>
                <b:message key="advert.content" />
            </footer>
            <content>

            </content>
            </p>
        </aside>
        <article class="signup">
            <p>
            <footer><b:message key="signup.title" /></footer>
            <content>
                <form class="signup_form" action="signupSevlet" method="post">
                    <table>
                        <tr>
                            <td><input name="fname" type="text" maxlength="40" size="20" placeholder="First Name" value="${fname}" required/></td><td><input name="lname" type="text" maxlength="40" size="20" placeholder="Last Name" value="${lname}" required/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input name="email" type="text" maxlength="40" size="20" placeholder="eMail Address"value="${email}"  required/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input name="remail" type="text" maxlength="40" size="20" placeholder="Re-enter eMail Address"value="${remail}"  required/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input name="pass" type="password" maxlength="40" size="20" placeholder="New Password"value="${pass}"  required/></td>
                        </tr>
                    </table>
                    <table class="dob">
                        <tr>
                            <td><select name="month" required>
                                    <option disabled selected value="">Month</option>
                                    <option value="01">January</option>
                                    <option value="02">February</option>
                                    <option value="03">March</option>
                                    <option value="04">April</option>
                                    <option value="05">May</option>
                                    <option value="06">June</option>
                                    <option value="07">July</option>
                                    <option value="08">August</option>
                                    <option value="09">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>
                            </td>
                            <td>
                                <select name="day" required>
                                    <option disabled selected value="">Day</option>
                                    <script type="text/javascript">for (var i = 1; i <= 31; i++) {
                                            document.writeln('<option value="' + i + '">' + i + '</option>')
                                        }</script>
                                </select>
                            </td>
                            <td>
                                <select name="year" required>
                                    <option disabled selected value="">Year</option>
                                    <script type="text/javascript">var date = new Date();
                                        var current = date.getFullYear();
                                        var past = current - 110;
                                        for (var i = current; i > past; i--) {
                                            document.writeln('<option value="' + i + '">' + i + '</option>');
                                        }</script>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <div class="proceed">
                        <label for="female"><input id="female" name="gender" type="radio" value="female" required/> Female</label><label for="male"><input id="male" name="gender" type="radio" value="male" /> Male</label>
                        <p>By clicking Sign Up, you agree to our <a>Terms</a> and that you have read our <a>Data Use Policy</a>, inlcuding our <a>Cookie Use</a>.</p>
                        <input class="signupBtn" name="signupBtn" type="submit" value="Sign Up" />
                    </div>
                </form>
                <hr />
                <a>Create a Page</a> for a celebrity, band or business.
            </content>
            </p>
        </article>
    </div>
</div>