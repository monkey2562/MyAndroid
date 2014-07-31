package com.mk.myandroid.ui.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mk.myandroid.R;

public class UsingSpinnerActivity extends Activity {
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_spinner);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
		adapter.add("hello");
		adapter.add("world");
		adapter.add("Hearth Stone");
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
	}

}
