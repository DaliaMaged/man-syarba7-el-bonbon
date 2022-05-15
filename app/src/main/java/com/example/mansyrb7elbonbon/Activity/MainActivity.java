package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mansyrb7elbonbon.R;
import com.example.mansyrb7elbonbon.model.Modelclass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    List<Modelclass>allQuestionList;
    Modelclass modelClass;
    int index=0;
    Button option1,option2,option3,option4,btnDialog;
    TextView question,btnNext,textAns,textCorrectAns;
    ImageView back,home,img1,img2;
    int correctCount=0;
    int wrongCount=0;
    TextView timer;
    CountDownTimer  countdowntimer;
    Dialog dialog;

    Animation topAnimation,topAnimation2;



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
        textAns=findViewById(R.id.textAns);
        textCorrectAns=findViewById(R.id.textCorrectAns);
        back=findViewById(R.id.iconBack);
        home=findViewById(R.id.iconHome);


        //timer
       timerFunction();


        //visibale
        textAns.setVisibility(View.GONE);
        textCorrectAns.setVisibility(View.GONE);


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

        //dialge
        dialog= new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialg);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;

        //dialog conf
        btnDialog= dialog.findViewById(R.id.dilogButton);
        img1=dialog.findViewById(R.id.img1);
        img2=dialog.findViewById(R.id.img2);

        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        topAnimation2=AnimationUtils.loadAnimation(this,R.anim.topanimation2);
        img1.setAnimation(topAnimation);
        img2.setAnimation(topAnimation2);


        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });




    }
    public void setAllData(){
        question.setText(modelClass.getQuestion());
        option1.setText(modelClass.getOption1());
        option2.setText(modelClass.getOption2());
        option3.setText(modelClass.getOption3());
        option4.setText(modelClass.getOption4());
        textCorrectAns.setText(modelClass.getAnswer());
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

    public void ShowAnswer(){
        textAns.setVisibility(View.VISIBLE);
        textCorrectAns.setVisibility(View.VISIBLE);
    }
    public void HideAnswer(){
        textAns.setVisibility(View.GONE);
        textCorrectAns.setVisibility(View.GONE);
    }

    public void Correct( Button button){

        button.setBackgroundResource(R.drawable.right_answer);
        reset();
        notificationCorrect();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelClass=SplashScreen.listOfQuestion.get(index);
                resetColor();
                setAllData();
                enableButton();
                timerFunction();

            }
        });

    }

    public void Wrong( Button option1){
        option1.setBackgroundResource(R.drawable.wrong_answer);
        ShowAnswer();
        notificationWrong();
        reset();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                HideAnswer();
                if (index<SplashScreen.listOfQuestion.size()-1){
                    index++;
                    modelClass=SplashScreen.listOfQuestion.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                    timerFunction();

                }else {
                    GameWon();
                }
            }
        });

    }

    public void GameWon(){
        Intent intent= new Intent(MainActivity.this, WinActivity.class);
        startActivity(intent);
        reset();

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
    public void timerFunction() {
        timer = findViewById(R.id.timer);
        //time durtion
        long duration = TimeUnit.MINUTES.toMillis(1);
        //countdown
        countdowntimer = new CountDownTimer(40000, 1000) {
            @Override
            public void onTick(long l) {
                //when tick convert milliseconds to minutes and seconds
                NumberFormat f = new DecimalFormat("00");
                long min = (l / 60000) % 60;
                long sec = (l / 1000) % 60;
                timer.setText(f.format(min) + ":" + f.format(sec));


            }

            @Override
            public void onFinish() {
                timer.setText("00:00");
                Toast.makeText(getApplicationContext(), "time is up ", Toast.LENGTH_LONG).show();
                ShowAnswer();

            }
        }.start();
    }
    public void reset(){
        countdowntimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countdowntimer!=null){
            countdowntimer.cancel();
        }
    }
    private void notificationCorrect(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Utils.CHANNEL_ID);
        builder.setContentTitle(Utils.NOTIFY_TITLE);
        builder.setContentText(Utils.NOTIFY_DESC_correct);
        builder.setSmallIcon(R.drawable.ic_ballon__1_);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(Utils.NOTIFY_ID,builder.build());
    }
    private void notificationWrong(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Utils.CHANNEL_ID);
        builder.setContentTitle(Utils.NOTIFY_TITLE);
        builder.setContentText(Utils.NOTIFY_DESC_wrong);
        builder.setSmallIcon(R.drawable.ic_ballon__1_);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(Utils.NOTIFY_ID,builder.build());
    }
}