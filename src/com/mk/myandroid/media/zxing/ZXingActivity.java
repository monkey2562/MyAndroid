package com.mk.myandroid.media.zxing;

import com.google.zxing.WriterException;
import com.mk.myandroid.R;
import com.mk.myandroid.R.id;
import com.mk.myandroid.R.layout;
import com.mk.myandroid.R.menu;
import com.zxing.activity.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * <p>1.先把BarCodeTest作为Lib,</p>
 * <p>2.在工程中引用这个库</p>
 * @author Administrator
 *
 */
public class ZXingActivity extends Activity {
	TextView tv;
	EditText et;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zxing);
		tv = (TextView) findViewById(R.id.text);
		findViewById(R.id.scan).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(ZXingActivity.this, "你可以扫描条形码和二维码", Toast.LENGTH_SHORT).show();
				Intent startScan = new Intent(ZXingActivity.this,CaptureActivity.class);
//				startActivity(startScan);
				startActivityForResult(startScan, 0);
			}
		});
		
		et = (EditText) findViewById(R.id.input);
		iv = (ImageView) findViewById(R.id.image);
		findViewById(R.id.gen).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String in = et.getText().toString();
				if(in.equals("")){
					Toast.makeText(ZXingActivity.this, "请输入文本", Toast.LENGTH_SHORT).show();
				} else {
					try {
						Bitmap qrcode = EncodingHandler.createQRCode(in, 400);
						iv.setImageBitmap(qrcode);
					} catch (WriterException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			String result = data.getExtras().getString("result");
			tv.setText(result);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zxing, menu);
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
