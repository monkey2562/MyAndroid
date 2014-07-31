package com.mk.myandroid.ui;

import android.content.Context;
import android.content.Intent;

public class ListCellData {
	private String controlName;
	private Context context;
	private Intent intent;
	public ListCellData(Context context, String controlName, Intent intent) {
		this.controlName = controlName;
		this.context = context;
		this.intent = intent;
	}

	public String getControlName() {
		return controlName;
	}
	
	public Context getContext() {
		return context;
	}
	
	public Intent getIntent() {
		return intent;
	}
	
	
	public void startActivity(){
		getContext().startActivity(getIntent());
	}

	@Override
	public String toString() {
		return getControlName();
	}
	
	
}
