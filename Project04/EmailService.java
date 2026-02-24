/**
 * @author Bailey Sudbay
 *
 * Represents a notification service that sends messages via email.
 *
 * <p>This class provides an implementation of the
 * NotificationMedium interface using an email-style delivery.</p>
 */
public class EmailService implements NotificationMedium {

    /**
     * Sends a notification message as an email.
     *
     * @param message the message to be sent
     */
    @Override
    public void send(String message) {
        System.out.println("EMAIL SENT: " + message);
    }
}
