package com.example.mansyrb7elbonbon;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepository {

    private QustionDao mquestionDoa;
    private LiveData<List<QuestionsModel>> getAllQuestion;

    public QuestionRepository(Application app) {
        questionRoomDB db= questionRoomDB.getInstance(app);
        mquestionDoa= db.qustionDao();
        getAllQuestion=mquestionDoa.getAllQuestions();
    }
}
