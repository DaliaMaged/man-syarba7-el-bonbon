package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;

public class WinActivity extends AppCompatActivity {
    TextView winText;
    ImageView imgGirl1,imgGirl2,imgGirl3,imgBoy1,imgBoy2;
    Animation topAnimation,topAnimation2,bottonAnimation,rightAnmation,leftAnimation;
    private static int SPLASH_SCREEN=4000;

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
        imgBoy1.setAnimation(rightAnmation);
        imgBoy2.setAnimation(leftAnimation);


    }
}