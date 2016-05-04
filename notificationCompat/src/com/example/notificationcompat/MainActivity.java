package com.example.notificationcompat;

import java.util.regex.Pattern;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.RemoteViews.RemoteView;


public class MainActivity extends Activity {
	private Button btnPushTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPushTxt=(Button) findViewById(R.id.btnPushTxt);
        /**
         * 点击推送文本消息
         */
        btnPushTxt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RemoteViews contentViews=new RemoteViews(getPackageName(), R.layout.item_notificat);
				contentViews
                .setImageViewResource(R.id.imageNo, R.drawable.ic_launcher);
        contentViews.setTextViewText(R.id.titleNo, "自定义通知标题");
        contentViews.setTextViewText(R.id.textNo, "自定义通知内容");
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                        MainActivity.this).setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("我的通知")
                        .setTicker("有一条新的消息");
                mBuilder.setAutoCancel(true);
                mBuilder.setContent(contentViews);
                mBuilder.setAutoCancel(true);
                mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(10, mBuilder.build());
			}
		});
    }
}
