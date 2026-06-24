package main;

import java.util.Scanner;
import dao.JournalDAO;

public class JournalTest {

    public static void run(Scanner sc) {

        JournalDAO dao = new JournalDAO();
        int userId = 1;

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Content: ");
        String content = sc.nextLine();

        String date;
        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            date = sc.nextLine();

            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                break;
            }

            System.out.println("Invalid date format! Example: 2026-06-20");
        }

        boolean result = dao.addJournal(userId, title, content, date);

        if (result) {
            System.out.println("Journal Added Successfully");
        } else {
            System.out.println("Failed");
        }

        dao.viewJournals(userId);
    }
}