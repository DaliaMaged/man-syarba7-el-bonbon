package com.example.mansyrb7elbonbon.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;
import com.example.mansyrb7elbonbon.model.Modelclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    public static final String TABLE_NAME  = "QuestionsTable";
Animation topAnimation,bottomAnimation,bottonAnimation2,bottomAnmation3;
ImageView imageView1,imageView2,imageView3,imageView4;
private static int SPLASH_SCREEN=4000;
TextView textView;

//List of Questions
     public static ArrayList<Modelclass> listOfQuestion;
     DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //list question
        listOfQuestion= new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Question").child("Level_One");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modelclass modelclass= dataSnapshot.getValue(Modelclass.class);
                    listOfQuestion.add(modelclass);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        bottonAnimation2=AnimationUtils.loadAnimation(this,R.anim.bottomanimation2);
        bottomAnmation3=AnimationUtils.loadAnimation(this,R.anim.bottomanimation3);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        textView=findViewById(R.id.textView);

        imageView1.setAnimation(bottomAnmation3);
        imageView2.setAnimation(bottomAnimation);
        imageView3.setAnimation(bottomAnimation);
        imageView4.setAnimation(bottonAnimation2);
        textView.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this, ActivityOne.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}