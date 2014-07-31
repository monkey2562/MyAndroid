package com.mk.myandroid.ui.progressbar;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.mk.myandroid.R;

public class UsingProgressBarActivity extends Activity {
	private ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_progress_bar);
		
		pb = (ProgressBar) findViewById(R.id.progressBar3);
		pb.setMax(100);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		startTimer();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		stopTimer();
	}

	
	private Timer timer;
	private TimerTask task;
	private int progress = 0;
	public void startTimer(){
		if(timer == null ){
			timer = new Timer();
			task = new TimerTask() {
				
				@Override
				public void run() {
					progress ++;
					pb.setProgress(progress);
				}
			};
			timer.schedule(task, 1000,1000);
		}
	}
	
	public void stopTimer(){
		if(timer != null ){
			task.cancel();
			timer.cancel();
			task = null;
			timer = null;
		}
	}
}
