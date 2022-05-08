package com.example.mansyrb7elbonbon;

import android.app.Application;
import android.os.AsyncTask;

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

    //insert
//    public void (Question question){
//        new InsertAsyncTask(mquestionDoa).execute(question);
//    }
    //get questions
    public LiveData<List<QuestionsModel>> getAllQuestion(){
        return getAllQuestion;
    }

    private static class InsertAsyncTask extends AsyncTask<QuestionsModel,Void,Void>{
        private QustionDao qustionDao;

        public InsertAsyncTask(QustionDao qustionDao) {
            this.qustionDao = qustionDao;
        }

        @Override
        protected Void doInBackground(QuestionsModel... questionsModels) {
            qustionDao.insert(questionsModels[0]);
            return null;
        }
    }
}
