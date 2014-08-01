package com.mk.myandroid.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;
import com.mk.myandroid.ui.autocomplete.UsingAutoCompleteActivity;
import com.mk.myandroid.ui.baseadapter.UsingBaseAdapterActivity;
import com.mk.myandroid.ui.checkbox.UsingCheckBoxActivity;
import com.mk.myandroid.ui.datepicker.UsingDatePickerActivity;
import com.mk.myandroid.ui.edittext.UsingEditTextActivity;
import com.mk.myandroid.ui.gallery.UsingGalleryActivity;
import com.mk.myandroid.ui.gridview.UsingGridViewActivity;
import com.mk.myandroid.ui.imageswitcher.UsingImageSwitcherActivity;
import com.mk.myandroid.ui.notification.UsingNotificationActivity;
import com.mk.myandroid.ui.progressbar.UsingProgressBarActivity;
import com.mk.myandroid.ui.progressdialog.UsingProgressDialogActivity;
import com.mk.myandroid.ui.radiogroup.UsingRadioGroupActivity;
import com.mk.myandroid.ui.ratingbar.UsingRatingBarActivity;
import com.mk.myandroid.ui.scrollview.UsingScrollViewActivity;
import com.mk.myandroid.ui.seekbar.UsingSeekBarActivity;
import com.mk.myandroid.ui.spinner.UsingSpinnerActivity;
import com.mk.myandroid.ui.timepicker.UsingTimePickerActivity;

public class UiListActivity extends ListActivity {
	private ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListCellData(this, "RadioGroup",new Intent(this,UsingRadioGroupActivity.class)));
		adapter.add(new ListCellData(this, "CheckBox",new Intent(this,UsingCheckBoxActivity.class)));
		adapter.add(new ListCellData(this, "DatePicker",new Intent(this,UsingDatePickerActivity.class)));
		adapter.add(new ListCellData(this, "TimePicker",new Intent(this,UsingTimePickerActivity.class)));
		adapter.add(new ListCellData(this, "Spinner",new Intent(this,UsingSpinnerActivity.class)));
		adapter.add(new ListCellData(this, "ProgressBar",new Intent(this,UsingProgressBarActivity.class)));
		adapter.add(new ListCellData(this, "AutoComplete",new Intent(this,UsingAutoCompleteActivity.class)));
		adapter.add(new ListCellData(this, "SeekBar",new Intent(this,UsingSeekBarActivity.class)));
		adapter.add(new ListCellData(this, "GridView",new Intent(this,UsingGridViewActivity.class)));
		adapter.add(new ListCellData(this, "ProgressDialog",new Intent(this,UsingProgressDialogActivity.class)));
		adapter.add(new ListCellData(this, "Notification",new Intent(this,UsingNotificationActivity.class)));
		adapter.add(new ListCellData(this, "ScrollView",new Intent(this,UsingScrollViewActivity.class)));
		adapter.add(new ListCellData(this, "RatingBar",new Intent(this,UsingRatingBarActivity.class)));
		adapter.add(new ListCellData(this, "ImageSwitcher",new Intent(this,UsingImageSwitcherActivity.class)));
		adapter.add(new ListCellData(this, "Gallery",new Intent(this,UsingGalleryActivity.class)));
		adapter.add(new ListCellData(this, "EditText",new Intent(this,UsingEditTextActivity.class)));
		adapter.add(new ListCellData(this, "BaseAdapter",new Intent(this,UsingBaseAdapterActivity.class)));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		ListCellData data = adapter.getItem(position);
		data.startActivity();
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_group, menu);
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
