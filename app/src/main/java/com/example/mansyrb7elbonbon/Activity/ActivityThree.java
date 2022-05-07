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

public class ActivityThree extends AppCompatActivity {
    Animation topAnimation,topAnimation2;
    ImageView boy1,boy2;

    TextView getStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_three);



        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        topAnimation2=AnimationUtils.loadAnimation(this,R.anim.topanimation2);


        boy1=findViewById(R.id.boy1);
        boy2=findViewById(R.id.boy2);
        getStart=findViewById(R.id.getStart);

        boy1.setAnimation(topAnimation);
        boy2.setAnimation(topAnimation2);

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ActivityThree.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}