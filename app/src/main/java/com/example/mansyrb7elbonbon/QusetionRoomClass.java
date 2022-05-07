package com.example.mansyrb7elbonbon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "QusetionsTable")
public class QusetionRoomClass {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int trueAnswer;

    public QusetionRoomClass(String question, String option1, String option2, String option3, String option4, int trueAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.trueAnswer = trueAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }
}
