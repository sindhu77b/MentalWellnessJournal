package main;

import java.util.Scanner;

import dao.JournalDAO;

public class JournalTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        JournalDAO dao = new JournalDAO();

        int userId = 1;

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Content: ");
        String content = sc.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        boolean result =
                dao.addJournal(
                        userId,
                        title,
                        content,
                        date
                );

        if(result) {

            System.out.println("Journal Added");

        } else {

            System.out.println("Failed");
        }

        dao.viewJournals(userId);

        
    }
}