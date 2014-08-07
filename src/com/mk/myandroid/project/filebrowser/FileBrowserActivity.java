package com.mk.myandroid.project.filebrowser;

import java.io.File;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;

public class FileBrowserActivity extends ListActivity {
	private ArrayAdapter<EFile> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_browser);
		
		String dir = getIntent().getStringExtra("dir");
		if(dir == null){
			dir = "/";
		}
		
		File dirFile = new File(dir);
		File[] children = dirFile.listFiles();
		
		adapter = new ArrayAdapter<EFile>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		
		if(children!=null && children.length>0){
			for (File file : children) {
				adapter.add(new EFile(file));
			}
		}
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		EFile eFile = adapter.getItem(position);
		if(eFile.getFile().isDirectory()){
			
			Intent i = new Intent(this,FileBrowserActivity.class);
			i.putExtra("dir", eFile.getFile().getAbsolutePath());
			startActivity(i);
			
		}
		
		
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_browser, menu);
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
