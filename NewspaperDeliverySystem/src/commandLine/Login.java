package commandLine;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // Hardcoded username and password
        String correctUsername = "Jeremy Stone";
        String correctPassword = "763585";

        // Create a scanner object to capture user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Prompt user for password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if username and password are correct
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Successful login
            System.out.println("Welcome, " + username + "!");
        	CommandLine.main(args);

        } else {
            // Failed login
            System.out.println("Incorrect username or password. Try again.");
            Login.main(args);
        }

        // Close the scanner
        scanner.close();
    }
}
