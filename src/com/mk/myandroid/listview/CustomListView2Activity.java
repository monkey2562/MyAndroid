package com.mk.myandroid.listview;

import com.mk.myandroid.R;

import android.app.ListActivity;
import android.os.Bundle;
/**
 * ֱ�Ӽ̳�ListActivity��ListView
 * @author Administrator
 *
 */
public class CustomListView2Activity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_listview2);
		setListAdapter(new CustomListViewAdapter(this));
		
	}
}
