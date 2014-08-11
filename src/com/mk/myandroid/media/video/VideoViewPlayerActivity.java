package com.mk.myandroid.media.video;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.mk.myandroid.R;

public class VideoViewPlayerActivity extends Activity {
	private VideoView vv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		vv = new VideoView(this);
		setContentView(vv);
		vv.setVideoPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/video.mp4");
		vv.setMediaController(new MediaController(this));//…Ë÷√øÿº˛Ãı
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.video_view_player, menu);
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
