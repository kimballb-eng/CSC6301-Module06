import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bailey Sudbay
 *
 * Main container for the flexible notification system.
 *
 * <p>This class uses composition by holding a NotificationMedium as a field.
 * That way, the delivery method (email, SMS, etc.) can be swapped without
 * changing the rest of the alert logic.</p>
 */
public class AlertSystem {

    private NotificationMedium medium;
    private final ArrayList<String> log;

    /**
     * Creates a new AlertSystem with no medium selected yet.
     * The log starts empty for the current session.
     */
    public AlertSystem() {
        this.medium = null;
        this.log = new ArrayList<>();
    }

    /**
     * Sets or swaps the notification medium used to send messages.
     *
     * @param medium the delivery method to use for notifications
     */
    public void setMedium(NotificationMedium medium) {
        this.medium = medium;
    }

    /**
     * Sends a message using the currently selected medium and stores it in the session log.
     *
     * @param message the message to send
     * @throws IllegalStateException if no medium has been set yet
     */
    public void notifyUser(String message) {
        if (medium == null) {
            throw new IllegalStateException("No notification medium set. Please call setMedium() first.");
        }

        medium.send(message);
        log.add(message);
    }

    /**
     * Returns the list of messages sent during this session.
     *
     * @return an ArrayList containing all messages sent so far
     */
    public ArrayList<String> getLog() {
        return log;
    }

    /**
     * Runs a simple CLI so the program can be compiled and executed using the command line.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AlertSystem alertSystem = new AlertSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Flexible Notification System");
        System.out.println("Choose a notification medium:");
        System.out.println("1) Email");
        System.out.println("2) SMS");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            alertSystem.setMedium(new EmailService());
            System.out.println("Medium set to Email.");
        } else if (choice.equals("2")) {
            alertSystem.setMedium(new SMSService());
            System.out.println("Medium set to SMS.");
        } else {
            alertSystem.setMedium(new EmailService());
            System.out.println("Invalid choice. Defaulting to Email.");
        }

        System.out.println();
        System.out.println("Type a message to send. Type 'exit' to quit.");

        while (true) {
            System.out.print("Message: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            alertSystem.notifyUser(message);
        }

        System.out.println();
        System.out.println("Session Log:");

        if (alertSystem.getLog().isEmpty()) {
            System.out.println("(No messages sent.)");
        } else {
            for (int i = 0; i < alertSystem.getLog().size(); i++) {
                System.out.println((i + 1) + ". " + alertSystem.getLog().get(i));
            }
        }

        scanner.close();
    }
}