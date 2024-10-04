public class Email {
    private String recipient;
    private String subject;
    private String body;

    public Email(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public String toString() {
        return "To: " + recipient + "\nSubject: " + subject + "\nBody:\n" + body;
    }
}
