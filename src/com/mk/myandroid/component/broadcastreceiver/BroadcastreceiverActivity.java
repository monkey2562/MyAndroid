package com.mk.myandroid.component.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mk.myandroid.R;

public class BroadcastreceiverActivity extends Activity {
	Button btnSendBroadcast,btnRegBroadcast,btnUnregBroadcast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcastreceiver);
		
		btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
		
		
		btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(BroadcastreceiverActivity.this, MyBC.class);
				Intent intent = new Intent(MyBC.ACTION);
				intent.putExtra("txt", "Hello Hearth Stone!");
				sendBroadcast(intent);
			}
		});
		
		btnRegBroadcast = (Button) findViewById(R.id.btnRegBroadcast);
		btnRegBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				registerReceiver(myBC, new IntentFilter(MyBC.ACTION));
			}
		});
		
		btnUnregBroadcast = (Button) findViewById(R.id.btnUnregBroadcast);
		btnUnregBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unregisterReceiver(myBC);
			}
		});
	}
	
	private final MyBC myBC = new MyBC();
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.broadcastreceiver, menu);
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
