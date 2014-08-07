package com.mk.myandroid.resourceaccess.menu;

import com.mk.myandroid.R;
import com.mk.myandroid.R.id;
import com.mk.myandroid.R.layout;
import com.mk.myandroid.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ResourceMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resource_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resource_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.showDialog) {
//			return true;
//		}
		
		switch (item.getItemId()) {
		case R.id.showDialog:
			new AlertDialog.Builder(this).setTitle("����").setMessage("�Ի���").setPositiveButton("�ر�", null).show();
			break;
		case R.id.showToast:
			Toast.makeText(this, "��Ϣ", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
