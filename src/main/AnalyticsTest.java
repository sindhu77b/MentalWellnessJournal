package main;

import dao.AnalyticsDAO;

public class AnalyticsTest {

    public static void main(String[] args) {

        int userId = 1;

        AnalyticsDAO dao =
                new AnalyticsDAO();

        int journals =
                dao.getJournalCount(userId);

        int happy =
                dao.getMoodCount(userId,"Happy");

        int sad =
                dao.getMoodCount(userId,"Sad");

        int stress =
                dao.getMoodCount(userId,"Stress");

        int habits =
                dao.getHabitCount(userId);

        int score =
                (happy * 10)
                - (sad * 5)
                - (stress * 7)
                + (habits * 2)
                + (journals * 3);

        System.out.println();
        System.out.println("===== ANALYTICS =====");

        System.out.println(
                "Total Journals : " + journals);

        System.out.println(
                "Happy Moods    : " + happy);

        System.out.println(
                "Sad Moods      : " + sad);

        System.out.println(
                "Stress Moods   : " + stress);

        System.out.println(
                "Habit Records  : " + habits);

        System.out.println(
                "Wellness Score : " + score);
    }
}