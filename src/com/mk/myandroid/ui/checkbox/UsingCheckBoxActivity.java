package com.mk.myandroid.ui.checkbox;

import com.mk.myandroid.R;
import com.mk.myandroid.R.id;
import com.mk.myandroid.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class UsingCheckBoxActivity extends Activity {
	private CheckBox cbniurou,cbyangrou,cbgourou,cbjirou;
	private Button btnSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_check_box);
		
		cbniurou = (CheckBox) findViewById(R.id.cbniurou);
		cbyangrou = (CheckBox) findViewById(R.id.cbyangrou);
		cbgourou = (CheckBox) findViewById(R.id.cbgourou);
		cbjirou = (CheckBox) findViewById(R.id.cbjirou);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuffer sb = new StringBuffer("中午要吃的东西有：\n");
				if(cbniurou.isChecked()){
					sb.append("牛肉\n");
				}
				if(cbyangrou.isChecked()){
					sb.append("羊肉\n");
				}
				if(cbgourou.isChecked()){
					sb.append("狗肉\n");
				}
				if(cbjirou.isChecked()){
					sb.append("鸡肉");
				}
				
				new AlertDialog.Builder(UsingCheckBoxActivity.this).setTitle("结果")
				.setMessage(sb.toString()).setPositiveButton("确定", null).show();
			}
		});
	}

}
