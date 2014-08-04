package com.mk.myandroid.project;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;
import com.mk.myandroid.project.calculator.CalculatorActivity;
import com.mk.myandroid.ui.ListCellData;

public class ProjectActivity extends ListActivity {
	private ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListCellData(this, "Calculator",new Intent(this,CalculatorActivity.class)));
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
		getMenuInflater().inflate(R.menu.project, menu);
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
