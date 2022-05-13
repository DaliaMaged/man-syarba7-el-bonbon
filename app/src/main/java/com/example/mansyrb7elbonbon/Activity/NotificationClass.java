package com.example.mansyrb7elbonbon.Activity;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class NotificationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        notificationChannel();
    }
    private void notificationChannel(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=new NotificationChannel(Utils.CHANNEL_ID,Utils.CHANNEL_Name, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription(Utils.CHANNEL_DSC);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}
