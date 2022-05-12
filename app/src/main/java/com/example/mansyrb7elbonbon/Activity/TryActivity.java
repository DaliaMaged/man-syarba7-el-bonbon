package com.example.mansyrb7elbonbon.Activity;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mansyrb7elbonbon.R;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TryActivity extends AppCompatActivity {
    TextView timer;
    TextView btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        timerFunction();
        nextBtnFunction();


    }

    private void nextBtnFunction() {
        btnNext=findViewById(R.id.btnNextQuestion);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel("my notify","my notify", IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(TryActivity.this,"My notification");
                builder.setContentTitle("my notify");
                builder.setContentText("Excellent , ready to the next question!");
                builder.setSmallIcon(R.drawable.ic_ballon__1_);
                builder.setAutoCancel(true);
               // Intent notificationIntent = new Intent(this, TryActivity.class);
//                PendingIntent contentIntent = PendingIntent.getActivity(, 0, notificationIntent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(contentIntent);

                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(TryActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }

    private void timerFunction() {
        timer=findViewById(R.id.timer);
        //time durtion
        long duration = TimeUnit.MINUTES.toMillis(1);
        //countdown
        new CountDownTimer(40000, 1000) {
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
                Toast.makeText(getApplicationContext(),"time is up ",Toast.LENGTH_LONG).show();

            }
        }.start();

    }
}