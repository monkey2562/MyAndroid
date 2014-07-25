package com.mk.myandroid.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mk.myandroid.R;

public class LayoutActivity extends Activity implements OnClickListener{
	Button neonLightButton;
	Button LinearButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		
		neonLightButton = (Button) findViewById(R.id.layout_btn_01);
		neonLightButton.setOnClickListener(this);
		LinearButton = (Button) findViewById(R.id.layout_btn_02);
		LinearButton.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_btn_01:
			Intent neonIntent = new Intent(LayoutActivity.this,NeonlightActivity.class);
			startActivity(neonIntent);
			break;
		case R.id.layout_btn_02:
			Intent linearIntent = new Intent(LayoutActivity.this,LinearActivity.class);
			startActivity(linearIntent);
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout, menu);
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
