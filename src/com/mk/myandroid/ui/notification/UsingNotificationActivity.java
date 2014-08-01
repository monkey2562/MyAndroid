package com.mk.myandroid.ui.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mk.myandroid.R;

public class UsingNotificationActivity extends Activity {
	private Button button;
	private NotificationManager manager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_notification);
		
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancel(R.layout.activity_using_notification);//点击使通知消失
		button =(Button) findViewById(R.id.btnShowNotification);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				new Notification.Builder(UsingNotificationActivity.this);
				
				Notification notification = new Notification(R.drawable.app_icon,"Ticker Text",System.currentTimeMillis());
				notification.setLatestEventInfo(UsingNotificationActivity.this, "title", "content", 
						PendingIntent.getActivity(UsingNotificationActivity.this, 1, getIntent(), 0));
				manager.notify(R.layout.activity_using_notification, notification);
			}
		});
	}

}
