package dao;

import java.sql.*;

import util.DBConnection;

public class UserHabitDAO {

    public boolean addHabitRecord(
            int userId,
            int habitId,
            String date,
            String value) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "INSERT INTO user_habits(user_id,habit_id,record_date,value) VALUES(?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, userId);
            pst.setInt(2, habitId);
            pst.setString(3, date);
            pst.setString(4, value);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void viewRecords(int userId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "SELECT uh.record_id,h.habit_name,uh.record_date,uh.value " +
            "FROM user_habits uh " +
            "JOIN habits h ON uh.habit_id=h.habit_id " +
            "WHERE uh.user_id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, userId);

            ResultSet rs =
                    pst.executeQuery();

            System.out.println("\n===== HABIT RECORDS =====");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("record_id")
                        + " | "
                        + rs.getString("habit_name")
                        + " | "
                        + rs.getString("record_date")
                        + " | "
                        + rs.getString("value")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}