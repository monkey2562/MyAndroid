package com.mk.myandroid.datastorage.sharedpreferences;

import com.mk.myandroid.R;
import com.mk.myandroid.R.id;
import com.mk.myandroid.R.layout;
import com.mk.myandroid.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class UseSharedPreferencesActivity extends Activity {
	CheckBox checkBox;
	SharedPreferences sp;
	private static final String KEY_SHOW_DIALOG_AT_START = "ShowWelcomeDialogAtStart";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_use_shared_preferences);
		
		sp = getSharedPreferences("mysp", Context.MODE_PRIVATE);
		
		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Editor e = sp.edit();
				e.putBoolean(KEY_SHOW_DIALOG_AT_START, isChecked);
				e.commit();
			}
		});
		
		
		
		checkBox.setChecked(sp.getBoolean(KEY_SHOW_DIALOG_AT_START, false));
		
		if(checkBox.isChecked()){
			new AlertDialog.Builder(this).setTitle("ª∂”≠").setMessage("ª∂”≠ π”√").setPositiveButton("πÿ±’", null).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.use_shared_preferences, menu);
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
