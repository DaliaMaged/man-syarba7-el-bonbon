package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;

public class ActivityOne extends AppCompatActivity {
    Animation topAnimation,bottomAnimation,bottonAnimation2,bottomAnmation3;
    ImageView imageView1,imageView2,imageView3,imageView4,imageViewBallon;
    TextView txtSkip,txtNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_one);

        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        bottonAnimation2=AnimationUtils.loadAnimation(this,R.anim.bottomanimation2);
        bottomAnmation3=AnimationUtils.loadAnimation(this,R.anim.bottomanimation3);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageViewBallon=findViewById(R.id.imageBallon);
        txtSkip=findViewById(R.id.txtSkip);
        txtNext=findViewById(R.id.txtNext);

        imageView1.setAnimation(bottomAnmation3);
        imageView2.setAnimation(bottomAnimation);
        imageView3.setAnimation(bottomAnimation);
        imageView4.setAnimation(bottonAnimation2);
        imageViewBallon.setAnimation(topAnimation);

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityOne.this, ActivityTwo.class));
            }
        });

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityOne.this, HomeActivity.class));
            }
        });

    }
}