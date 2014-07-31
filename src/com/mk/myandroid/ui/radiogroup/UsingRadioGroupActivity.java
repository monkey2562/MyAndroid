package com.mk.myandroid.ui.radiogroup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mk.myandroid.R;

public class UsingRadioGroupActivity extends Activity {
	private RadioButton radioRight;
	private Button btnSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_radio_group);
		
		radioRight = (RadioButton) findViewById(R.id.radioRight);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(radioRight.isChecked()){
					new AlertDialog.Builder(UsingRadioGroupActivity.this)
					.setTitle("ÅÐ¶Ï").setMessage("»Ø´ðÕýÈ·").setPositiveButton("¹Ø±Õ", null).show();
				}else{
					new AlertDialog.Builder(UsingRadioGroupActivity.this)
					.setTitle("ÅÐ¶Ï").setMessage("»Ø´ð´íÎó").setPositiveButton("¹Ø±Õ", null).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.using_radio_group, menu);
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
