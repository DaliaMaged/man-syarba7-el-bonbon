package com.example.mansyrb7elbonbon;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mansyrb7elbonbon.Activity.SplashScreen;

import java.util.List;

@Dao
public interface QustionDao {
    @Insert
    void insert(QuestionsModel qusetion);
    @Query("SELECT * From "+ SplashScreen.TABLE_NAME)
    LiveData<List<QuestionsModel>> getAllQuestions();
}
