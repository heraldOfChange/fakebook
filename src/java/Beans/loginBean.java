package Beans;

public class loginBean {

    //Error Message
    private final String errorMsg = "<span style='color:red'>Please enter Username & Password.</span>";

    //Form Data
    public static String id;
    private String mail;
    private String password;
    private String extended;
    private String firstname;
    private String lastname;
    private String dob;
    private String phone;
    private String gender;

    //SETTERS
    public void setId(String id) {
        this.id = id;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExtended(String extended) {
        this.extended = extended;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //GETTERS
    public String getId() {
        return id;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getExtended() {
        return extended;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

}
