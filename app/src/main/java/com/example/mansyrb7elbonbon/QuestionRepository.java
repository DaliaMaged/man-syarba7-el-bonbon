package com.example.mansyrb7elbonbon;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mansyrb7elbonbon.QusetionRoomClass;
import com.example.mansyrb7elbonbon.QustionDao;
import com.example.mansyrb7elbonbon.questionRoomDB;

import java.util.List;

public class QuestionRepository {

    private QustionDao mquestionDoa;
    private LiveData<List<QusetionRoomClass>> getAllQuestion;

    public QuestionRepository(Application app) {
        questionRoomDB db= questionRoomDB.getInstance(app);
        mquestionDoa= db.qustionDao();
        //getAllQuestion= mquestionDoa.getAllQuestion();
    }
}
