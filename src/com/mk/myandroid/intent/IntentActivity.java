package com.mk.myandroid.intent;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mk.myandroid.R;

public class IntentActivity extends Activity {
	Button btnAction,btnImage,btnPhone,btnWebsite;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		btnAction = (Button) findViewById(R.id.btnAction);
		btnAction.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//通过ACTION启动activity 隐式intent
				Intent intent = new Intent("com.mk.myandroid.intent.action.actionactivity");
				startActivity(intent);
			}
		});
		//打开图片
		btnImage = (Button) findViewById(R.id.btnImage);
		btnImage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//通过IMAGE启动activity
				File file = new File("/mnt/sdcard/3.jpg");
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(file), "image/*");
				startActivity(intent);
			}
		});
		//拨打电话
		btnPhone = (Button) findViewById(R.id.btnPhone);
		btnPhone.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("tel:10010"));
				startActivity(intent);
			}
		});
		//打开网址
		btnWebsite = (Button) findViewById(R.id.btnWebsite);
		btnWebsite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.intent, menu);
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
