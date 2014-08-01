package com.mk.myandroid.ui.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.mk.myandroid.R;

public class UsingGridViewActivity extends Activity {
	private ArrayAdapter<String> adapter;
	private GridView gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_grid_view);
		gridView = (GridView) findViewById(R.id.gridView1);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		gridView.setAdapter(adapter);
		for(int i = 0; i <50; i ++){
			adapter.add("mk" + i);
		}
	}

}
