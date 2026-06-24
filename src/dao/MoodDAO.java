package dao;

import java.sql.*;
import util.DBConnection;

public class MoodDAO {

    public boolean addMood(int userId, String moodType, String moodDate, String notes) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO moods(user_id, mood_type, mood_date, notes) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, userId);
            pst.setString(2, moodType);
            pst.setDate(3, java.sql.Date.valueOf(moodDate));   // moodDate must be yyyy-mm-dd
            pst.setString(4, notes);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void viewMoods(int userId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM moods WHERE user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== MOODS =====");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("mood_id") + " | " +
                        rs.getString("mood_type") + " | " +
                        rs.getString("mood_date") + " | " +
                        rs.getString("notes")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteMood(int moodId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM moods WHERE mood_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, moodId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}