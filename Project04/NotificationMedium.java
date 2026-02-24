/**
 * @author Bailey Sudbay
 *
 * Represents a way to send a notification message.
 *
 * <p>This interface defines a contract that any notification method
 * must follow. By using this interface, the notification delivery method
 * can be changed without rewriting the main alert system.</p>
 */
public interface NotificationMedium {

    /**
     * Sends a notification message.
     *
     * @param message the message to be sent
     */
    void send(String message);
}