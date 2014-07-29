package com.mk.myandroid.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.mk.myandroid.R;

public class ServiceActivity extends Activity implements OnClickListener, ServiceConnection{
	private Button btnStartService;
	private Button btnStopService;
	private Button btnBindService;
	private Button btnUnbindService;
	private Button btnGetCurrentNum;
	private Intent serviceIntent;
	private EchoService echoService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		serviceIntent = new Intent(this, EchoService.class);
		
		btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStopService = (Button) findViewById(R.id.btnStopService);
		btnBindService = (Button) findViewById(R.id.btnBindService);
		btnUnbindService = (Button) findViewById(R.id.btnUnbindService);
		btnGetCurrentNum = (Button) findViewById(R.id.btnGetCurrentNum);
		
		
		btnStartService.setOnClickListener(this);
		btnStopService.setOnClickListener(this);
		btnBindService.setOnClickListener(this);
		btnUnbindService.setOnClickListener(this);
		btnGetCurrentNum.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnStartService:
			startService(serviceIntent);
			break;
		case R.id.btnStopService:
			stopService(serviceIntent);
			break;
		case R.id.btnBindService:
			bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
			
			break;
		case R.id.btnUnbindService:
			unbindService(this);
			echoService = null;
			break;
		case R.id.btnGetCurrentNum:
			if(echoService!=null){
				Toast.makeText(this, "当前服务中的数字是：" + echoService.getCurrentNum(), Toast.LENGTH_SHORT).show();
			}
			
			break;
		default:
			break;
		}
		
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder binder) {
		Log.v("ServiceActivity", "onServiceConnected");
		
		echoService = ((EchoService.EchoServiceBinder) binder).getService();
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		
	}

}
