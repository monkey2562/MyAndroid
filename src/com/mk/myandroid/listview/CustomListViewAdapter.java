package com.mk.myandroid.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mk.myandroid.R;

public class CustomListViewAdapter extends BaseAdapter {
	private Context context;
	public CustomListViewAdapter(Context context){
		this.context = context;
	}
	
//	private String[] data = new String[]{"mk1","mk2","mk3","mk4","mk5","mk6",
//	"mk7","mk8","mk9","mk10","mk11","mk12","mk13","mk14","mk15","mk16","mk17","mk18","mk19","mk20"};

	private CustomListCellData[] data = new CustomListCellData[]{
			new CustomListCellData("img1" , "dec img1", R.drawable.fs),
			new CustomListCellData("img2" , "dec img2", R.drawable.ss),
			new CustomListCellData("img3" , "dec img3", R.drawable.ms)
	};
	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public CustomListCellData getItem(int position) {
		return data[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
//		Log.v("CustomListviewActivity", "getView()");
//		TextView tv = null;
//		if(convertView != null){
//			tv = (TextView) convertView;
//		} else{
//			Log.v("CustomListviewActivity", "new()");
//			tv = new TextView(CustomListviewActivity.this);
//		}
//		tv.setText(getItem(position));
//		tv.setTextSize(50);
//		return tv;

		
		LinearLayout ll = null;
		if(convertView != null){
			ll = (LinearLayout) convertView;
		}else {
			ll = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.customlistview_item, null);
		}
		CustomListCellData data = getItem(position);
		
		ImageView icon = (ImageView) ll.findViewById(R.id.imageview001);
		TextView name = (TextView) ll.findViewById(R.id.textview001);
		TextView dec = (TextView) ll.findViewById(R.id.textview002);
		icon.setImageResource(data.iconId);
		name.setText(data.name);
		dec.setText(data.dec);
		
		return ll;
	}

	public Context getContext() {
		return context;
	}
}
