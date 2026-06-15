package main;

import java.util.Scanner;

import dao.UserHabitDAO;

public class HabitTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserHabitDAO dao =
                new UserHabitDAO();

        int userId = 1;

        System.out.println("1 Exercise");
        System.out.println("2 Water");
        System.out.println("3 Sleep");

        System.out.print("Habit ID: ");
        int habitId = sc.nextInt();

        sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Value: ");
        String value = sc.nextLine();

        boolean result =
                dao.addHabitRecord(
                        userId,
                        habitId,
                        date,
                        value
                );

        if(result) {

            System.out.println("Record Added");

        } else {

            System.out.println("Failed");
        }

        dao.viewRecords(userId);

    }
}