package Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class order {

    public static List<String> publications;
    private List<String> daysOfWeek;

    public order() {
        publications = Arrays.asList("The Irish Times", "The Irish Independent", "Irish Mirror", "The Irish Sun");
        daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    }

    public static List<String> getPublications() {
        return publications;
    }

    public void displayPublications() {
        System.out.println("Available Publications:");
        for (String publication : publications) {
            System.out.println("- " + publication);
        }
    }

    public void displayDaysOfWeek() {
        System.out.println("Available Days of the Week:");
        for (String day : daysOfWeek) {
            System.out.println("- " + day);
        }
    }

    public String getSelectedPublication(Scanner scanner) {
        System.out.println("Availiable Publications:");
        String publication = scanner.nextLine();

        while (!publications.contains(publication)) {
            System.out.println("Invalid publication. Please enter a valid publication name:");
            publication = scanner.nextLine();
        }
        return publication;
    }

    public List<String> getSelectedDays(Scanner scanner) {
        List<String> selectedDays = new ArrayList<>();
        String input;

        input = scanner.nextLine();
        String[] daysArray = input.split(",\\s*");

        for (String day : daysArray) {
            if (daysOfWeek.contains(day)) {
                selectedDays.add(day);
            } else {
                System.out.println("Invalid day: " + day + ". Please choose valid days.");
            }
        }

        if (selectedDays.isEmpty()) {
            System.out.println("No valid days selected. Please try again.");
            return getSelectedDays(scanner);
        }

        return selectedDays;
    }


    public static void main(String[] args) {
        order selector = new order();
        Scanner scanner = new Scanner(System.in);
        List<String> selectedPublications = new ArrayList<>();
        List<List<String>> selectedDaysForPublications = new ArrayList<>();

        boolean addMore = true;

        while (addMore) {
            selector.displayPublications();
            String publication = selector.getSelectedPublication(scanner);
            selectedPublications.add(publication);

            selector.displayDaysOfWeek();
            List<String> selectedDays = selector.getSelectedDays(scanner);
            selectedDaysForPublications.add(selectedDays);

            System.out.println("Add another publication? (yes/no):");
            String response = scanner.nextLine().trim().toLowerCase();
            addMore = response.equals("yes");
        }

        System.out.println("Summary of customer selections:");
        for (int i = 0; i < selectedPublications.size(); i++) {
            System.out.println("Publication: " + selectedPublications.get(i));
            System.out.println("Days: " + selectedDaysForPublications.get(i));
        }

        scanner.close();
    }
}