package com.mk.myandroid.resourceaccess.assets;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mk.myandroid.R;

public class ResourceAssetsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resource_assets);
		try {
			InputStream is = getAssets().open("data");
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			
			String str = new String(bytes,"gbk");
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageView iv = (ImageView) findViewById(R.id.imageView);
		
		try {
			InputStream is = getAssets().open("san.jpg");
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			iv.setImageBitmap(bitmap);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resource_assets, menu);
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
