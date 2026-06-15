package dao;

import dao.UserDAO;
import model.User;

public class TestRegister {

    public static void main(String[] args) {

        User user = new User();

        user.setFullName("Micky");
        user.setUsername("micky124");
        user.setEmail("micky@gmail.com");
        user.setPassword("Micky@123");
        user.setGender("Male");
        user.setDob("2003-01-01");

        UserDAO dao = new UserDAO();

        boolean result =
                dao.registerUser(user);

        if(result) {

            System.out.println(
                    "User Registered Successfully");

        } else {

            System.out.println(
                    "Registration Failed");

        }
    }
}