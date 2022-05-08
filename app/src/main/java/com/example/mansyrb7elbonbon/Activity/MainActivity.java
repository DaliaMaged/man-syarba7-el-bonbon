package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;
import com.example.mansyrb7elbonbon.model.Modelclass;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Modelclass>allQuestionList;
    Modelclass modelClass;
    int index=0;
    Button option1,option2,option3,option4;
    TextView question,btnNext;
    int correctCount=0;
    int wrongCount=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        question=findViewById(R.id.questionID);
        option1=findViewById(R.id.option1ID);
        option2=findViewById(R.id.option2ID);
        option3=findViewById(R.id.option3ID);
        option4=findViewById(R.id.option4ID);
        btnNext=findViewById(R.id.btnNextQuestion);


        //
        allQuestionList=SplashScreen.listOfQuestion;
        Collections.shuffle(allQuestionList);
        modelClass =SplashScreen.listOfQuestion.get(index);

        //
        option1.setBackgroundResource(R.drawable.answer_contaner);
        option2.setBackgroundResource(R.drawable.answer_contaner);
        option3.setBackgroundResource(R.drawable.answer_contaner);
        option4.setBackgroundResource(R.drawable.answer_contaner);

        btnNext.setClickable(false);

        setAllData();


    }
    public void setAllData(){
        question.setText(modelClass.getQuestion());
        option1.setText(modelClass.getOption1());
        option2.setText(modelClass.getOption2());
        option3.setText(modelClass.getOption3());
        option4.setText(modelClass.getOption4());
    }

    public void Correct( Button button){

        button.setBackgroundResource(R.drawable.right_answer);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelClass=SplashScreen.listOfQuestion.get(index);
                setAllData();
                resetColor();
                enableButton();
            }
        });

    }


    public void Wrong( Button option1){
        option1.setBackgroundResource(R.drawable.wrong_answer);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index<SplashScreen.listOfQuestion.size()-1){
                    index++;
                    modelClass=SplashScreen.listOfQuestion.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                }else {

                    GameWon();
                }
            }
        });
    }

    public void GameWon(){
        Intent intent= new Intent(MainActivity.this, WinActivity.class);
        startActivity(intent);

    }
    public void enableButton(){
        option1.setClickable(true);
        option2.setClickable(true);
        option3.setClickable(true);
        option4.setClickable(true);
    }
    public void disableButton(){
        option1.setClickable(false);
        option2.setClickable(false);
        option3.setClickable(false);
        option4.setClickable(false);
    }
    public void resetColor(){
        option1.setBackgroundResource(R.drawable.answer_contaner);
        option2.setBackgroundResource(R.drawable.answer_contaner);
        option3.setBackgroundResource(R.drawable.answer_contaner);
        option4.setBackgroundResource(R.drawable.answer_contaner);
    }

    public void option1Click(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getOption1().equals(modelClass.getAnswer())){
            option1.setBackgroundResource(R.drawable.right_answer);
            if (index<SplashScreen.listOfQuestion.size()-1){
                Correct(option1);
            }
            else {
                GameWon();
            }
        }
        else {
            Wrong(option1);
        }
    }

    public void option2Click(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getOption2().equals(modelClass.getAnswer())){
            option2.setBackgroundResource(R.drawable.right_answer);
            if (index<SplashScreen.listOfQuestion.size()-1){
               Correct(option2);
            }
            else {
                GameWon();
            }
        }
        else {
            Wrong(option2);
        }
    }

    public void option3Click(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getOption3().equals(modelClass.getAnswer())){
            option3.setBackgroundResource(R.drawable.right_answer);
            if (index<SplashScreen.listOfQuestion.size()-1){
                Correct(option3);
            }
            else {
                GameWon();
            }
        }
        else {
            Wrong(option3);
        }
    }

    public void option4Click(View view) {
        disableButton();
        btnNext.setClickable(true);
        if (modelClass.getOption4().equals(modelClass.getAnswer())){
            option4.setBackgroundResource(R.drawable.right_answer);
            if (index<SplashScreen.listOfQuestion.size()-1){
               Correct(option4);
            }
            else {
                GameWon();
            }
        }
        else {
            Wrong(option4);
        }
    }
}