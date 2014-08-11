package com.mk.myandroid.media;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;
import com.mk.myandroid.media.camera.CameraActivity;
import com.mk.myandroid.media.camera.UsingSystemCameraActivity;
import com.mk.myandroid.media.record.RecordActivity;
import com.mk.myandroid.media.sound.PlaySoundActivity;
import com.mk.myandroid.media.video.PlayVideoActivity;
import com.mk.myandroid.ui.ListCellData;

public class MediaActivity extends ListActivity {
	private ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media);
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListCellData(this, "SoundPoll和MediaPlay播放声音", new Intent(this,PlaySoundActivity.class)));
		adapter.add(new ListCellData(this, "SurfaceView和VideoView播放视频", new Intent(this,PlayVideoActivity.class)));
		adapter.add(new ListCellData(this, "camera照相机", new Intent(this,CameraActivity.class)));
		adapter.add(new ListCellData(this, "调用系统照相机", new Intent(this,UsingSystemCameraActivity.class)));
		adapter.add(new ListCellData(this, "MediaRecord录音", new Intent(this,RecordActivity.class)));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		ListCellData data = adapter.getItem(position);
		data.startActivity();
		super.onListItemClick(l, v, position, id);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.media, menu);
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
