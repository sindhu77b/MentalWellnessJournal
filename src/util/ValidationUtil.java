package util;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {

        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);
    }

    public static boolean isValidPassword(String password) {

        if(password.length() < 8)
            return false;

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        for(char ch : password.toCharArray()) {

            if(Character.isUpperCase(ch))
                upper = true;

            else if(Character.isLowerCase(ch))
                lower = true;

            else if(Character.isDigit(ch))
                digit = true;

            else
                special = true;
        }

        return upper && lower && digit && special;
    }

    public static boolean isValidUsername(String username) {

        return username != null &&
               username.length() >= 4;
    }

    public static boolean isValidName(String name) {

        return name != null &&
               !name.trim().isEmpty();
    }
}