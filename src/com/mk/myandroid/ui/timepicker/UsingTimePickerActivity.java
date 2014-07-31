package com.mk.myandroid.ui.timepicker;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.mk.myandroid.R;

public class UsingTimePickerActivity extends Activity {
	private Button btnSelectTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_time_picker);
		
		btnSelectTime = (Button) findViewById(R.id.btnSelectTime);
		btnSelectTime.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new TimePickerDialog(UsingTimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						btnSelectTime.setText(String.format("%02d:%02d", hourOfDay,minute));
					}
				}, 16, 31, true).show();
			}
		});
	}

}
