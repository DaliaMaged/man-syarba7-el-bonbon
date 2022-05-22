package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;

public class WinActivity extends AppCompatActivity {
    TextView winText,score;
    int correct,wrong;
    ImageView imgGirl1,imgGirl2,imgGirl3,imgBoy1,imgBoy2;
    Animation topAnimation,topAnimation2,bottonAnimation,rightAnmation,leftAnimation;
    private static int SPLASH_SCREEN=4000;
    MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        winText =findViewById(R.id.textWin);
        imgGirl1=findViewById(R.id.imgGirl1);
        imgGirl2=findViewById(R.id.imgGirl2);
        imgGirl3=findViewById(R.id.imggirl3);
        imgBoy1=findViewById(R.id.imgBoy1);
        imgBoy2=findViewById(R.id.imgBoy2);

        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        topAnimation2=AnimationUtils.loadAnimation(this,R.anim.topanimation2);
        bottonAnimation=AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        rightAnmation=AnimationUtils.loadAnimation(this,R.anim.rightanimation);
        leftAnimation=AnimationUtils.loadAnimation(this,R.anim.leftanimation);

        //set animation to layout
        winText.setAnimation(topAnimation);
        imgGirl1.setAnimation(topAnimation);
        imgGirl2.setAnimation(topAnimation2);
        imgGirl3.setAnimation(bottonAnimation);
        imgBoy1.setAnimation(leftAnimation);
        imgBoy2.setAnimation(rightAnmation);

        score=findViewById(R.id.score);
        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);
        score.setText(correct+ "/10");
if (correct<5){
    WrongSound();
}
else {
    correctSound();
}

    }
    private void correctSound(){
        ring= MediaPlayer.create(WinActivity.this,R.raw.kids2);
        ring.start();    }

    private void WrongSound(){
        ring= MediaPlayer.create(WinActivity.this,R.raw.kids1);
        ring.start();    }
}
