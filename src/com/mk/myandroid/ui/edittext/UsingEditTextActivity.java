package com.mk.myandroid.ui.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mk.myandroid.R;

public class UsingEditTextActivity extends Activity {
	private EditText editText;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_edit_text);
		
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.btnGetText);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(TextUtils.isEmpty(editText.getText())){
					Toast.makeText(UsingEditTextActivity.this, "ÎÄ±¾Îª¿Õ£¡", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(UsingEditTextActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}
