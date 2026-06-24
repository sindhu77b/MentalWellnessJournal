package main;

import java.util.Scanner;
import dao.UserDAO;
import model.User;
import util.ValidationUtil;

public class RegisterTest {

    public static void run(Scanner sc) {

        User user = new User();

        System.out.println("\n===== USER REGISTRATION =====");

        System.out.print("Full Name: ");
        String name = sc.nextLine();

        if (!ValidationUtil.isValidName(name)) {
            System.out.println("Invalid Name");
            return;
        }
        user.setFullName(name);

        System.out.print("Username: ");
        String username = sc.nextLine();

        if (!ValidationUtil.isValidUsername(username)) {
            System.out.println("Username must be minimum 4 characters");
            return;
        }
        user.setUsername(username);

        System.out.print("Email: ");
        String email = sc.nextLine();

        if (!ValidationUtil.isValidEmail(email)) {
            System.out.println("Invalid Email Format");
            return;
        }
        user.setEmail(email);

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!ValidationUtil.isValidPassword(password)) {
            System.out.println("Password must contain uppercase, lowercase, number, special character and be at least 8 characters.");
            return;
        }
        user.setPassword(password);

        System.out.print("Gender: ");
        user.setGender(sc.nextLine());

        System.out.print("DOB (YYYY-MM-DD): ");
        user.setDob(sc.nextLine());

        UserDAO dao = new UserDAO();

        boolean result = dao.registerUser(user);

        if (result) {
            System.out.println("Registration Success");
        } else {
            System.out.println("Registration Failed");
        }
    }
}