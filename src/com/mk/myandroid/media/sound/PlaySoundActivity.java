package com.mk.myandroid.media.sound;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mk.myandroid.R;

public class PlaySoundActivity extends Activity {
	private SoundPool sp;
	private MediaPlayer mp;
	private int soundID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_sound); 
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		soundID = sp.load(this, R.raw.ding, 1);
		findViewById(R.id.btnPlaySound).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sp.play(soundID, 1, 1, 0, 0, 0.5f);
			}
		});
		
		findViewById(R.id.btnPlaySong).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mp !=null){
					mp.start();
				}
			}
		});
	}
	
	@Override
	protected void onPause() {
		if(mp != null){
			mp.release();
		}
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		mp = MediaPlayer.create(this, R.raw.iphone);
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play_sound, menu);
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
