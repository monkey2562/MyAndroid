package com.mk.myandroid.ui.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mk.myandroid.R;

public class UsingSeekBarActivity extends Activity {
	private SeekBar seekBar;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_seek_bar);
		tv = (TextView) findViewById(R.id.textView1);
		
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		
		seekBar.setMax(100);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tv.setText(String.format("当前进度为：%d", progress)+"%");
			}
		});
	}

}
