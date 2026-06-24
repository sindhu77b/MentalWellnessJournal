package main;

import java.util.Scanner;

public class MentalWellnessApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=================================");
            System.out.println(" MENTAL WELLNESS JOURNAL SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Journal Module");
            System.out.println("4. Mood Module");
            System.out.println("5. Habit Module");
            System.out.println("6. Analytics");
            System.out.println("7. Exit");

            System.out.print("\nEnter Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    RegisterTest.run(sc);
                    break;

                case 2:
                    LoginTest.run(sc);
                    break;

                case 3:
                    JournalTest.run(sc);
                    break;

                case 4:
                    MoodTest.run(sc);
                    break;

                case 5:
                    HabitTest.run(sc);
                    break;

                case 6:
                    AnalyticsTest.run();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 7);

        sc.close();
    }
}