package com.mk.myandroid.ui.baseadapter;

import android.R.anim;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.mk.myandroid.R;

public class UsingBaseAdapterActivity extends ListActivity implements OnClickListener{
	private MyListAdapter<String> adapter;
	private int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_base_adapter);
		
		adapter = new MyListAdapter<String>(this,android.R.layout.simple_list_item_1) {
			
			@Override
			protected void initListCell(int position, View listCell, ViewGroup parent) {
				((TextView)listCell).setText(getItem(position));
			}
		};
		
		setListAdapter(adapter);
		
		for (index = 0; index < 5; index++) {
			adapter.add("mk" + index);
		}
		
		
		findViewById(R.id.btnadd).setOnClickListener(this);
		findViewById(R.id.btnremove).setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnadd:
			adapter.add("mk"+index);
			index++;
			break;
		case R.id.btnremove:
			adapter.removelast();
			break;

		}
	}

}
