package com.example.mansyrb7elbonbon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mansyrb7elbonbon.R;

public class HomeActivity extends AppCompatActivity {
    TextView levelOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        levelOne=findViewById(R.id.txtLevelOne);
        levelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}