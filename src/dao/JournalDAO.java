package dao;

import java.sql.*;
import util.DBConnection;

public class JournalDAO {

    public boolean addJournal(
            int userId,
            String title,
            String content,
            String date) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "INSERT INTO journal_entries(user_id,title,content,entry_date) VALUES(?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, userId);
            pst.setString(2, title);
            pst.setString(3, content);
            pst.setString(4, date);

            return pst.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void viewJournals(int userId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "SELECT * FROM journal_entries WHERE user_id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, userId);

            ResultSet rs =
                    pst.executeQuery();

            System.out.println("\n===== JOURNALS =====");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("journal_id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("entry_date")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}