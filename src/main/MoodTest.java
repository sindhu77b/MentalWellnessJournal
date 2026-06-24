package main;

import java.util.Scanner;
import dao.MoodDAO;

public class MoodTest {

    public static void run(Scanner sc) {

        MoodDAO dao = new MoodDAO();
        int userId = 1;

        System.out.print("Mood Type: ");
        String moodType = sc.nextLine();

        System.out.print("Note: ");
        String notes = sc.nextLine();

        String moodDate;
        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            moodDate = sc.nextLine().trim();

            if (moodDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                break;
            }

            System.out.println("Invalid date format! Example: 2026-06-20");
        }

        // CORRECT ORDER: userId, moodType, moodDate, notes
        boolean result = dao.addMood(userId, moodType, moodDate, notes);

        if (result) {
            System.out.println("Mood Added Successfully");
        } else {
            System.out.println("Failed");
        }

        dao.viewMoods(userId);
    }
}