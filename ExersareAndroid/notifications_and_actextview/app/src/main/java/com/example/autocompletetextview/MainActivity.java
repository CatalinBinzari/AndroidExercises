package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView acTextView;
    Button btn;

    private static final String[] COUNTRIES = new String[] {"Belgium", "France", "Italy", "Germany", "Spain"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acTextViewAccess();
        ShowNotifications();
    }
    public void acTextViewAccess(){
        acTextView = (AutoCompleteTextView) findViewById(R.id.actw);

        //returneaza un view ptr fiecare element din Countries
        //arrayadapter creaza un obiect care adapteaza Countries ptr a putea face display la un ListView
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, COUNTRIES);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);
    }
    public void ShowNotifications(){
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification noti  = new Notification.Builder(MainActivity.this)
                        .setTicker("TickerTitle")
                        .setContentTitle("Content Title")
                        .setContentText("Content text.....................")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager mn = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                mn.notify(0,noti);
            }
        });
    }

}
