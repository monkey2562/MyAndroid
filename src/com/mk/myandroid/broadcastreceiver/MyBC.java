package com.mk.myandroid.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBC extends BroadcastReceiver {

	
	public static final String ACTION = "com.mk.myandroid.intent.action.MyBC";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("MyBC", "onReceive---"+intent.getStringExtra("txt"));

	}

}
