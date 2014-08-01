package com.mk.myandroid.ui.imageswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.mk.myandroid.R;

public class UsingImageSwitcherActivity extends Activity {
	private ImageSwitcher imageSwitcher;
	private boolean showImg1 = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_image_switcher);
		
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
			
			@Override
			public View makeView() {
				return new ImageView(UsingImageSwitcherActivity.this);
			}
		});
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(UsingImageSwitcherActivity.this, android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(UsingImageSwitcherActivity.this, android.R.anim.fade_out));
		
		
		imageSwitcher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showImg1 = !showImg1;
				showCurrentImage();
			}
		});
		showCurrentImage();
	}

	private void showCurrentImage(){
		if(showImg1){
			imageSwitcher.setImageResource(R.drawable.dly);
		} else {
			imageSwitcher.setImageResource(R.drawable.dz);
		}
	}
}
