package com.mk.myandroid.media.camera;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;

import com.mk.myandroid.R;
import com.mk.myandroid.project.filebrowser.FileBrowserActivity;

public class CameraActivity extends Activity {
	private SurfaceView cameraPreview;
	private Camera camera;
	private Callback cameraPreviewHoldCallback = new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			stopPreview();
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			startPreview();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);
		cameraPreview.getHolder().addCallback(cameraPreviewHoldCallback);
		
		findViewById(R.id.btnTakePic).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				camera.takePicture(null, null, new Camera.PictureCallback() {
					
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						String path = saveTempFile(data);
						if(path !=null){
							Intent intent = new Intent(CameraActivity.this,ImagePreviewActivity.class);
							intent.putExtra("path", path);
							startActivity(intent);
						}else {
							Toast.makeText(CameraActivity.this, "±£¥Ê’’∆¨ ß∞‹°£", Toast.LENGTH_SHORT).show();
						}
					}
				});
			}
		});
	}
	
	private String saveTempFile(byte[] bytes){
		try {
			File f = File.createTempFile("img", "");
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.flush();
			fos.close();
			
			return f.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void startPreview(){
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(cameraPreview.getHolder());
			camera.setDisplayOrientation(90);//…Ë÷√Õº∆¨–˝◊™90∂»
			camera.startPreview();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void stopPreview(){
		camera.stopPreview();
		camera.release();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
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
