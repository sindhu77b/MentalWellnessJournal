package main;

import java.util.Scanner;

import dao.MoodDAO;

public class MoodTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MoodDAO dao = new MoodDAO();

        int userId = 1;

        System.out.print("Mood: ");
        String mood = sc.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Notes: ");
        String notes = sc.nextLine();

        boolean result =
                dao.addMood(
                        userId,
                        mood,
                        date,
                        notes
                );

        if(result) {

            System.out.println("Mood Added");

        } else {

            System.out.println("Failed");
        }

        dao.viewMoods(userId);

        
    }
}