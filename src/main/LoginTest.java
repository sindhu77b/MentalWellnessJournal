package main;

import java.util.Scanner;
import dao.UserDAO;

public class LoginTest {

    public static void run(Scanner sc) {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        UserDAO dao = new UserDAO();

        int userId = dao.loginUser(username, password);

        if (userId > 0) {
            System.out.println("Login Successful");
            System.out.println("User ID = " + userId);
        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}