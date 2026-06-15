package main;

import java.util.Scanner;

import dao.UserDAO;

public class LoginTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        UserDAO dao = new UserDAO();

        int userId = dao.loginUser(username, password);

        if(userId > 0) {

            System.out.println("Login Successful");
            System.out.println("User ID = " + userId);

        } else {

            System.out.println("Invalid Username or Password");
        }

      
    }
}