/**
 * Author: Bailey Sudbay
 *
 * Simple test to prove we can add WhatsApp as a new notification option
 * without modifying AlertSystem or NotificationMedium.
 */
public class MaintenanceTest {

    public static void main(String[] args) {

        AlertSystem system = new AlertSystem();

        system.setMedium(new EmailService());
        system.notifyUser("Email test");

        system.setMedium(new SMSService());
        system.notifyUser("SMS test");

        system.setMedium(new WhatsAppService());
        system.notifyUser("WhatsApp test");

        System.out.println();
        System.out.println("Session Log:");

        for (int i = 0; i < system.getLog().size(); i++) {
            System.out.println((i + 1) + ". " + system.getLog().get(i));
        }
    }
}