package com.mk.myandroid.ui.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;

import com.mk.myandroid.R;

public class UsingGalleryActivity extends Activity {
	private Gallery gallery;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_gallery);
		
		gallery = (Gallery) findViewById(R.id.gallery1);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		for (int i = 0; i < 20; i++) {
			adapter.add("mk" + i);
		}
		
		gallery.setAdapter(adapter);
	}

}
