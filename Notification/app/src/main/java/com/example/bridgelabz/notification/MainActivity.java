package com.example.bridgelabz.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify("New Message","This is notified message");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notify1();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notify2();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notify3();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notify4();
            }
        });
    }



    public void Notify(String title, String message)
    {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.f,"My Messsage", 2000);
        Intent intent = new Intent(this,NotifiedClass.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        notification.setLatestEventInfo(MainActivity.this,title,message,pendingIntent);
        manager.notify(9999,notification);
    }

    public void notify1()
    {
        Intent intent = new Intent(this,NotifiedClass.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Notification 2");
        builder.setContentText("This is the second notification");
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.f);
        builder.setFullScreenIntent(pendingIntent,false);
        Notification notification2 = builder.build();

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8,notification2);
    }

    public void notify2()
    {
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText("hiiii my name is sahel. I am 22 years old. I am working in bridgelab company");
        style.setBigContentTitle("Big text open");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setStyle(style);
        builder.setContentTitle("Big Text Notification");
        builder.setContentText("hiiii");
        builder.setSmallIcon(R.drawable.f);
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,smsIntent,0);
        builder.setFullScreenIntent(pendingIntent,false);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1000,notification);
    }

    public void notify3()
    {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox style Notification");
        inboxStyle.addLine("line 1");
        inboxStyle.addLine("line 2");
        inboxStyle.addLine("line 3");
        inboxStyle.addLine("line 4");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText("inbox style notification came");
        builder.setContentTitle("inbox style");
        builder.setStyle(inboxStyle);
        builder.setSmallIcon(R.drawable.f);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(123,notification);
    }

    public void notify4()
    {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.f);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle("Inbox style Notification");
        bigPictureStyle.bigPicture(bitmap);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText("big picture style notification came");
        builder.setContentTitle("big picture style");
        builder.setStyle(bigPictureStyle);
        builder.setSmallIcon(R.drawable.f);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(123,notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
