package com.mk.myandroid.ui.baseadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyListAdapter<T> extends BaseAdapter {
	private Context context;
	private int listCellId;
	
	public MyListAdapter(Context content,int resId) {
		this.context = content;
		this.listCellId = resId;
	}
	
	public Context getContext() {
		return context;
	}
	
	private List<T> list = new ArrayList<T>();
	
	public void add(T item) {
		list.add(item);
		notifyDataSetChanged();
	}
	
	public void remove(int position){
		list.remove(position);
		notifyDataSetChanged();
	}
	
	public void removelast(){
		remove(getCount()-1);
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(listCellId, null);
		}
		
		initListCell(position, convertView, parent);
		
		return convertView;
	}

	protected abstract void initListCell(int position, View listCell, ViewGroup parent);
	
	
}
