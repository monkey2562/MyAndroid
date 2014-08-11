package com.mk.myandroid.media.video;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.mk.myandroid.R;

public class SurfaceViewPlayerActivity extends Activity {
	
	private SurfaceView sv;
	private SurfaceHolder holder;
	private Callback surfaceHolderCallback = new Callback() {
		private MediaPlayer mp;
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			mp.release();
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			mp = MediaPlayer.create(SurfaceViewPlayerActivity.this, R.raw.video);
			try {
				mp.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mp.setDisplay(holder);
			mp.start();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		sv  = new SurfaceView(this);
		holder = sv.getHolder();
		holder.addCallback(surfaceHolderCallback);
		setContentView(sv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play_video, menu);
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
