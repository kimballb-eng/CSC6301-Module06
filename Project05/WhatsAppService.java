/**
 * Author: Bailey Sudbay
 *
 * This class adds WhatsApp as a new notification option.
 * This class follows the same structure as existing EmailService and SMSService,
 * this allows us to plug it into AlertSystem without changing any existing code.
 */
public class WhatsAppService implements NotificationMedium {

    /**
     * Sends a message using WhatsApp.
     *
     * @param message the text of the alert being sent
     */
    @Override
    public void send(String message) {
        System.out.println("WHATSAPP SENT: " + message);
    }
}