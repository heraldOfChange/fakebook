package easeClasses;

/* HANRATH, Martijn Jan Willem V. */
public class retrieveFriends {
    
    //Variables
    private String id;
    private String fname;
    private String lname;
    private String mail;
    
    //CONSTRUCTOR
    public retrieveFriends(String id, String fname, String lname, String mail){
        
        this.setId(id);
        this.setFname(fname);
        this.setLname(lname);
        this.setMail(mail);
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
