package com.example.mansyrb7elbonbon;

import  androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface QustionDao {
    @Insert
    void insert(QusetionRoomClass qusetion);

//    @Query("SELECT * From QusetionsTable")
//    LiveData<List<QusetionRoomClass>> getAllQuestion();
}
