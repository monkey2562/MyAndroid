package com.mk.myandroid.lifetime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mk.myandroid.R;

public class LifetimeActivity extends Activity {
	private static final String TAG = "LifetimeActivity";
	Button button;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lifetime);
		Log.v(TAG, "onCreate");
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LifetimeActivity.this, DatatransmissionActivity.class);
				intent.putExtra("data", "hello world of warcraft");
				
				
				startActivityForResult(intent, 0);
			}
		});
		
		
		textView = (TextView) findViewById(R.id.textView1);
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		
		textView.setText(data.getStringExtra("result"));
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.v(TAG, "onStart");
	}


	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v(TAG, "onRestart");
	}


	@Override
	protected void onResume() {
		super.onResume();
		Log.v(TAG, "onResume");
	}


	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause");
	}



	@Override
	protected void onStop() {
		super.onStop();
		Log.v(TAG, "onStop");
	}



	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}






	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lifetime, menu);
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
