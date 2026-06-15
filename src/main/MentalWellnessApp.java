package main;

import java.util.Scanner;

public class MentalWellnessApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

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

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                TestRegister.main(null);
                break;

            case 2:
                LoginTest.main(null);
                break;

            case 3:
                JournalTest.main(null);
                break;

            case 4:
                MoodTest.main(null);
                break;

            case 5:
                HabitTest.main(null);
                break;

            case 6:
                AnalyticsTest.main(null);
                break;

            case 7:
                System.out.println("Thank You...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Choice");
            }
        }
    }
}