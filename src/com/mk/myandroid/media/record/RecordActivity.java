package com.mk.myandroid.media.record;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.mk.myandroid.R;

public class RecordActivity extends Activity {
	private MediaRecorder mr;
	private OnClickListener btnClickListenter = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnStartRecord:
				startRecord();
				break;
			case R.id.btnStopRecord:
				stopRecord();
				break;
			}
		}
	};
	
	private void startRecord(){
		if(mr == null){
			
			File dir = new File(Environment.getExternalStorageDirectory(),"sounds");
			if(!dir.exists()){
				dir.mkdirs();
			}
			File soundFile = new File(dir,System.currentTimeMillis()+".amr");
			
			if(!soundFile.exists()){
				try {
					soundFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			mr = new MediaRecorder();
			mr.setAudioSource(MediaRecorder.AudioSource.MIC);//输入源
			mr.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);//输出格式
			mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);//音频编码
			
			
			
			mr.setOutputFile(soundFile.getAbsolutePath());
			try {
				mr.prepare();
				mr.start();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void stopRecord(){
		if(mr != null){
			mr.stop();
			mr.release();
			mr = null;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		findViewById(R.id.btnStartRecord).setOnClickListener(btnClickListenter );
		findViewById(R.id.btnStopRecord).setOnClickListener(btnClickListenter );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
