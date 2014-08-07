package com.mk.myandroid.datastorage;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;
import com.mk.myandroid.datastorage.externalstorage.ExternalStorageActivity;
import com.mk.myandroid.datastorage.internalstorage.InternalStorageActivity;
import com.mk.myandroid.datastorage.sharedpreferences.UseSharedPreferencesActivity;
import com.mk.myandroid.datastorage.sqlite.UseSqliteActivity;
import com.mk.myandroid.ui.ListCellData;

public class DataStorageActivity extends ListActivity {
	private ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListCellData(this, "数据存储之SharedPreferences", new Intent(this,UseSharedPreferencesActivity.class)));
		adapter.add(new ListCellData(this, "数据存储之内部存储", new Intent(this,InternalStorageActivity.class)));
		adapter.add(new ListCellData(this, "数据存储之外部存储", new Intent(this,ExternalStorageActivity.class)));
		adapter.add(new ListCellData(this, "数据存储之Sqlite", new Intent(this,UseSqliteActivity.class)));
		
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
		getMenuInflater().inflate(R.menu.data_storage, menu);
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
