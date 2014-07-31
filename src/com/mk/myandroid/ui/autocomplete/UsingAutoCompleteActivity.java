package com.mk.myandroid.ui.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.mk.myandroid.R;

public class UsingAutoCompleteActivity extends Activity {
	private AutoCompleteTextView actv;
	private MultiAutoCompleteTextView mactv;
	private ArrayAdapter<String> autoCompleteAdapter;
	private ArrayAdapter<String> multiAutoCompleteAdapter;
	private String[] strs = new String[]{"hello","hello world","hello world of warcraft","hello Hearth Stone",
			"hello JAVA","hello android","java","javascript"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_auto_complete);
		actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		autoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,strs);
		actv.setAdapter(autoCompleteAdapter);
		
		mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		multiAutoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,strs);
		mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		mactv.setAdapter(multiAutoCompleteAdapter);
	}

}
