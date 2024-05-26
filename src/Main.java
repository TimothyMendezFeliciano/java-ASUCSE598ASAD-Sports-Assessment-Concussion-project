import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Sports Concussion Assessment System");
        Map<String, Athlete> athletes = new HashMap<>();

        Scanner inMenu = new Scanner(System.in);
        while (true) {
            System.out.println("Please input if you are an athlete (1) or medical practitioner (2)");

            int choice = inMenu.nextInt();
            inMenu.nextLine();
            if (choice == 0) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }
            if (choice == 1) {
                System.out.println("Please input your name");
                String name = inMenu.nextLine();
                Athlete athlete;
                if (!athletes.containsKey(name)) {
                    athlete = new Athlete(name);
                    athletes.put(name, athlete);
                } else {
                    athlete = athletes.get(name);
                }
                System.out.println("Hello Athlete " + name);
                while (true) {
                    System.out.println("Choose a functionality.");
                    System.out.println("1) Symptom Entry");
                    System.out.println("2) Display Symptoms Summary");
                    System.out.println("3) Risky Condition");
                    System.out.println("0) Go back");

                    choice = inMenu.nextInt();
                    if (choice == 0) {
                        break;
                    }

                    switch (choice) {
                        case 1:
                            athlete.symptomEntry();
                            break;
                        case 2:
                            athlete.displaySymptomSummary();
                            break;
                        case 3:
                            athlete.riskyCondition();
                            break;
                        default:
                            System.out.println("Invalid choice. Try again");
                    }
                }
            } else if (choice == 2) {
                System.out.println("Welcome to the Athlete Monitor");
                if (athletes.isEmpty()) {
                    System.out.println("You have no athletes to inspect");
                } else {
                    System.out.println("Available Athletes: ");
                    for (String name : athletes.keySet()) {
                        System.out.println("- " + name);
                    }

                    System.out.println("input the name of the athlete to inspect: ");
                    String name = inMenu.nextLine();
                    Athlete athlete = athletes.get(name);

                    if (athlete == null) {
                        System.out.println("No athlete found with the name " + name);
                    } else {
                        while (true) {
                            System.out.println("Choose a functionality.");
                            System.out.println("1) Display Symptoms Summary");
                            System.out.println("2) Risky Condition");
                            System.out.println("0) Go back");

                            choice = inMenu.nextInt();
                            inMenu.nextLine();

                            if (choice == 0) {
                                break;
                            }

                            switch (choice) {
                                case 1:
                                    athlete.displaySymptomSummary();
                                    break;
                                case 2:
                                    athlete.riskyCondition();
                                    break;
                            }
                        }
                    }

                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}