package model;

public class Mood {

    private int moodId;
    private int userId;
    private String moodType;
    private String moodDate;
    private String note;

    public Mood() {
    }

    public Mood(int moodId, int userId, String moodType, String moodDate, String note) {
        this.moodId = moodId;
        this.userId = userId;
        this.moodType = moodType;
        this.moodDate = moodDate;
        this.note = note;
    }

    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMoodType() {
        return moodType;
    }

    public void setMoodType(String moodType) {
        this.moodType = moodType;
    }

    public String getMoodDate() {
        return moodDate;
    }

    public void setMoodDate(String moodDate) {
        this.moodDate = moodDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}