package com.mk.myandroid.listview;

import com.mk.myandroid.R;

import android.app.ListActivity;
import android.os.Bundle;
/**
 * Ö±½Ó¼Ì³ÐListActivityµÄListView
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
