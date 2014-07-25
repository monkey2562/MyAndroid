package com.mk.myandroid.layout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mk.myandroid.R;

public class NeonlightActivity extends Activity implements Runnable{
	/** ���TextView����ɫֵ*/
	private int[] colors = new int[]{0xFFFF0000,0xFF00FF00,0xFF0000FF,0xFFFF00FF,0xFF00FFFF};
	/** ÿһ�ε���ɫ����һ�����������һ����ɫ����һ������ֵ�ǵ�һ�����൱��ѭ������*/
	private int[] nextColorPointers = new int[]{1,2,3,4,0};
	private View[] views;
	private int currentColorPointer = 0;
	private Handler handler;

	@Override
	public void run() {
		int nextColorPointer = currentColorPointer;
		for(int i = views.length -1 ; i >=0 ; i--){
			//���õ�ǰTextView�ı���ɫ
			views[i].setBackgroundColor(colors[nextColorPointers[nextColorPointer]]);
			//��ȡ��һ��TextView�ı���ɫֵ������
			nextColorPointer = nextColorPointers[nextColorPointer];
		}
		currentColorPointer++;
		if(currentColorPointer == 5 ){
			currentColorPointer = 0 ;
		}
		
		
		handler.postDelayed(this, 2000);//300����ѭ��һ��
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neonlight);
		
		views = new View[]{findViewById(R.id.layout_tv_001),findViewById(R.id.layout_tv_002),
				findViewById(R.id.layout_tv_003),findViewById(R.id.layout_tv_004),
				findViewById(R.id.layout_tv_005)};
		handler = new Handler();
		handler.postDelayed(this, 0);//300����ѭ��һ��
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.neonlight, menu);
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
