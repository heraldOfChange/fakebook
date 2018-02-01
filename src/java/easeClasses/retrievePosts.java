package easeClasses;

/* HANRATH, Martijn Jan Willem V. */
public class retrievePosts {

    //Variables
    String name = "";
    String details = "";
    String dateOfPost = "";

    public retrievePosts(String name, String details, String date) {
        setName(name);
        setDetails(details);
        setDateOfPost(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

}
