package com.mk.myandroid.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mk.myandroid.R;

public class ListcellActivity extends Activity implements OnItemClickListener{
	ListView listView;
	ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listcell);
		
		//自定义
		adapter = new ArrayAdapter<ListCellData>(this, R.layout.listview_item);
		
		listView = (ListView) findViewById(R.id.listview02);
		listView.setAdapter(adapter);	
		adapter.add(new ListCellData("小丽", "女", 25));
		adapter.add(new ListCellData("小张", "男", 26));
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		ListCellData data = adapter.getItem(position);
		Toast.makeText(this, String.format("姓名：%s,性别：%s,年龄：%d", data.getUserName(),data.getSex(),data.getAge()), Toast.LENGTH_SHORT).show();;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listcell, menu);
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
