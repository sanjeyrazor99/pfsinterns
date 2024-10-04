import java.util.ArrayList;
import java.util.Scanner;

public class EmailClient {
    private static ArrayList<Email> inbox = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Email Client!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Compose Email");
            System.out.println("2. Read Emails");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    composeEmail(scanner);
                    break;
                case 2:
                    readEmails();
                    break;
                case 3:
                    System.out.println("Exiting the Email Client. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void composeEmail(Scanner scanner) {
        System.out.print("Enter recipient: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter body: ");
        String body = scanner.nextLine();

        Email newEmail = new Email(recipient, subject, body);
        inbox.add(newEmail);

        System.out.println("Email composed successfully!");
    }

    private static void readEmails() {
        if (inbox.isEmpty()) {
            System.out.println("No emails to read.");
        } else {
            for (int i = 0; i < inbox.size(); i++) {
                System.out.println("\nEmail " + (i + 1) + ":");
                System.out.println(inbox.get(i));
            }
        }
    }
}
