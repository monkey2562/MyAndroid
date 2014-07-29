package com.mk.myandroid.service;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class EchoService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.v("EchoService", "onBind");
		return echoServiceBinder;
	}
	
	private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
	
	public class EchoServiceBinder extends Binder{
		public EchoService getService(){
			return EchoService.this;
		}
	}
	
	public int getCurrentNum(){
		return i;
	}
	

	@Override
	public void onCreate() {
		Log.v("EchoService", "onCreate");
		
		startTimer();
		
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.v("EchoService", "onDestroy");
		
		stopTimer();
		
		super.onDestroy();
	}
	
	private Timer timer;
	private TimerTask task;
	
	private int i = 0;
	
	public void startTimer(){
		if(timer ==null){
			timer = new Timer();
			task = new TimerTask() {
				
				@Override
				public void run() {
					i++;
					Log.v("EchoService", "i = " + i);
				}
			};
			
			timer.schedule(task, 1000, 1000);
		}
	}
	
	public void stopTimer(){
		if(timer != null){
			task.cancel();
			timer.cancel();
			
			task = null;
			timer = null;
		}
	}
	
}










