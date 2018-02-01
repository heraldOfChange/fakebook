package easeClasses;

/* HANRATH, Martijn Jan Willem V. */
public class retrieveMessages {

    //Variables
    private String sender;
    private String message;
    private String timeSent;
    
    public retrieveMessages(String sender, String message, String timeSent){
        this.setSender(sender);
        this.setMessage(message);
        this.setTimeSent(timeSent);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }
    
}
