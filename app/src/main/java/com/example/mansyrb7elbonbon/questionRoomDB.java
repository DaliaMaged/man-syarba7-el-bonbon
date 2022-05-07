package com.example.mansyrb7elbonbon;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = QuestionsModel.class,version = 1)
public abstract class questionRoomDB extends RoomDatabase {
    private static questionRoomDB instance;
     abstract QustionDao qustionDao();

    public static synchronized questionRoomDB getInstance(Context context){
        if (instance== null){
            instance= Room.databaseBuilder(context.getApplicationContext()
                    ,questionRoomDB.class,"Question_database").fallbackToDestructiveMigration()
                    .addCallback(roomCollBack).build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCollBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class populateDataAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private QustionDao mquestionDao;

         populateDataAsyncTask(questionRoomDB db) {
             mquestionDao= db.qustionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
             mquestionDao.insert(new QuestionsModel("Question1","answer1","answer2","answer3","answer4",1));
            mquestionDao.insert(new QuestionsModel("Question1","answer1","answer2","answer3","answer4",2));
            mquestionDao.insert(new QuestionsModel("Question1","answer1","answer2","answer3","answer4",3));
            mquestionDao.insert(new QuestionsModel("Question1","answer1","answer2","answer3","answer4",4));
            return null;
        }
    }
}
