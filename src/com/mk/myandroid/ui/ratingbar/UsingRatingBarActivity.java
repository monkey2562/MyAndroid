package com.mk.myandroid.ui.ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.mk.myandroid.R;

public class UsingRatingBarActivity extends Activity {
	private RatingBar ratingBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_rating_bar);
		
		ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
		ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Toast.makeText(UsingRatingBarActivity.this, "ÆÀ¼ÛÎª£º" + rating, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
