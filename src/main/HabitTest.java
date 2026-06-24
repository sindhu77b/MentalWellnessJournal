package main;

import java.util.Scanner;
import dao.UserHabitDAO;

public class HabitTest {

    public static void run(Scanner sc) {

        UserHabitDAO dao = new UserHabitDAO();
        int userId = 1;

        System.out.println("1 Exercise");
        System.out.println("2 Water");
        System.out.println("3 Sleep");

        int habitId;

        while (true) {
            System.out.print("Habit ID: ");
            habitId = sc.nextInt();
            sc.nextLine(); // consume newline

            if (habitId >= 1 && habitId <= 3) {
                break;
            }

            System.out.println("Invalid Habit ID! Please enter 1, 2 or 3.");
        }

        String date;

        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            date = sc.nextLine();

            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                break;
            }

            System.out.println("Invalid date format!");
            System.out.println("Example: 2026-06-20");
        }

        System.out.print("Value: ");
        String value = sc.nextLine();

        boolean result = dao.addHabitRecord(userId, habitId, date, value);

        if (result) {
            System.out.println("Record Added Successfully");
        } else {
            System.out.println("Failed");
        }

        dao.viewRecords(userId);
    }
}