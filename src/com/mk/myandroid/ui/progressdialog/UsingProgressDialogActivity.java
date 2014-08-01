package com.mk.myandroid.ui.progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.mk.myandroid.R;

public class UsingProgressDialogActivity extends Activity {
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_progress_dialog);
		
		findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				progressDialog = ProgressDialog.show(UsingProgressDialogActivity.this, "加载中", "正在加载，请稍后。");
				
				new Thread(){
					public void run() {
						try {
							Thread.sleep(3000);
							progressDialog.dismiss();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					};
				}.start();
			}
		});
		
	}

}
