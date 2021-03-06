package com.mk.myandroid.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;

public class ListviewActivity extends Activity implements OnItemClickListener{
	ListView listView;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		//系统自带
//		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		//自定义
		adapter = new ArrayAdapter<String>(this, R.layout.listview_item);
		
		listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
		
		adapter.add("ListCellData");
		adapter.add("自定义列表");
		adapter.add("ListActivity");
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			Intent listcellIntent = new Intent(this,ListcellActivity.class);
			startActivity(listcellIntent);
			break;
		case 1:
			Intent customIntent = new Intent(this,CustomListviewActivity.class);
			startActivity(customIntent);
			break;
		case 2:
			Intent listActivityIntent = new Intent(this,CustomListView2Activity.class);
			startActivity(listActivityIntent);
			break;

		default:
			break;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listview, menu);
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
