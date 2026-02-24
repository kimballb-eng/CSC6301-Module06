/**
 * @author Bailey Sudbay
 *
 * Represents a notification service that sends messages via SMS.
 *
 * <p>This class provides an implementation of the
 * NotificationMedium interface using an SMS-style delivery.</p>
 */
public class SMSService implements NotificationMedium {

    /**
     * Sends a notification message as an SMS.
     *
     * @param message the message to be sent
     */
    @Override
    public void send(String message) {
        System.out.println("SMS SENT: " + message);
    }
}