package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import model.User;
import util.DBConnection;

public class UserDAO {

    // REGISTER USER
    public boolean registerUser(User user) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO users(full_name, username, email, password, gender, dob, status) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, user.getFullName());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getGender());
            pst.setString(6, user.getDob());
            pst.setString(7, "Active");

            int rows = pst.executeUpdate();

            pst.close();
            con.close();

            return rows > 0;

        }
        catch (SQLIntegrityConstraintViolationException e) {

            System.out.println("\nERROR: Username or Email already exists!");
            return false;

        }
        catch (Exception e) {

            System.out.println("\nDATABASE ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN USER
    public int loginUser(String username, String password) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT user_id FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                int userId = rs.getInt("user_id");

                rs.close();
                pst.close();
                con.close();

                return userId;
            }

            rs.close();
            pst.close();
            con.close();

        }
        catch (Exception e) {

            System.out.println("\nDATABASE ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }
}