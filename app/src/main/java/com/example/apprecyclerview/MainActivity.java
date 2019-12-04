package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainData> data;
    public RecyclerView recyclerView;
    public static View.OnClickListener mainOnClickListener;
    public static int currentItem;
    private Button button;
    NotificationCompat.Builder builder;
    private static final int id = 123;

    private String CHANNEL_ID = "channel";
    private PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        llenarData();
        RecyclerView.Adapter adapter = new MainAdapter(data);
        recyclerView.setAdapter(adapter);
        mainOnClickListener = new MainOnClickListener(this);

        button = (Button) findViewById(R.id.button);



        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pendingIntent = PendingIntent.getActivity(this,0,intent,0);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                createNotification();
            }
        });

    }

    private void llenarData() {
        for (int i = 0; i < MainDataset.nameArray.length; i++){

            data.add(new MainData(
                    MainDataset.imageArray[i],
                    MainDataset.nameArray[i],
                    MainDataset.infoArray[i]
            ));
        }

    }



    private class MainOnClickListener implements View.OnClickListener {

        private final Context context;

        private MainOnClickListener(Context context) {
            this.context = context;
        }


        @Override
        public void onClick(View v) {
            currentItem = recyclerView.getChildAdapterPosition(v);
            startActivity(new Intent(getApplicationContext(), DetailActivity.class));

        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel name";  //getString(R.string.channel_name);
            String description = "channel description";  //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void createNotification(){
        Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
        builder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setTicker("Nouvelle notification")
                .setWhen(System.currentTimeMillis())
                .setContentTitle("Title")
                .setContentText("Notifications")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        ;

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(id, builder.build());
    }


}
