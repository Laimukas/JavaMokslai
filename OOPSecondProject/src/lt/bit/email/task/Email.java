package lt.bit.email.task;

import java.time.LocalDate;

public class Email {
    private String mailSentTo;
    private LocalDate sentDate;
    private Message message;

    public Email(String mailSentTo,  Message message) {
        this.mailSentTo = mailSentTo;
        this.message = message;
    }

    public String getMailSentTo() {
        return mailSentTo;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public Message getMessage() {
        return message;
    }

    public void setSentDate(LocalDate sentDate){
        this.sentDate=sentDate;
    }


}
