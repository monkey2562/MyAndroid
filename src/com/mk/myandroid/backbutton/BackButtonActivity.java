package com.mk.myandroid.backbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mk.myandroid.R;

public class BackButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_back_button);
	}
//	private int clickCount = 0;
	private long lastClickTime = 0;
	@Override
	public void onBackPressed() {
//		super.onBackPressed();
//		if(clickCount < 1){
//			Toast.makeText(this, "再在一次后退键才能返回。", Toast.LENGTH_SHORT).show();
//			clickCount++;
//		}else{
//			finish();
//		}
		if(lastClickTime <= 0){
			Toast.makeText(this, "再在一次后退键才能返回。", Toast.LENGTH_SHORT).show();
			lastClickTime = System.currentTimeMillis();
		}else{
			long currentClickTime = System.currentTimeMillis();
			if(currentClickTime - lastClickTime < 1000){
				finish();
			}else {
				Toast.makeText(this, "再在一次后退键才能返回。", Toast.LENGTH_SHORT).show();
				lastClickTime = currentClickTime;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.back_button, menu);
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
