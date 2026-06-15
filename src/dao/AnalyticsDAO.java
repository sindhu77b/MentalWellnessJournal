package dao;

import java.sql.*;

import util.DBConnection;

public class AnalyticsDAO {

    public int getJournalCount(int userId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT COUNT(*) total FROM journal_entries WHERE user_id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                return rs.getInt("total");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getMoodCount(int userId,String mood) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT COUNT(*) total FROM moods WHERE user_id=? AND mood_type=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1,userId);
            pst.setString(2,mood);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                return rs.getInt("total");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getHabitCount(int userId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT COUNT(*) total FROM user_habits WHERE user_id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1,userId);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                return rs.getInt("total");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}