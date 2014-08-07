package com.mk.myandroid.resourceaccess;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mk.myandroid.R;
import com.mk.myandroid.resourceaccess.array.ResourceArrayActivity;
import com.mk.myandroid.resourceaccess.assets.ResourceAssetsActivity;
import com.mk.myandroid.resourceaccess.color.ResourceColorActivity;
import com.mk.myandroid.resourceaccess.drawable.ResourceDrawableActivity;
import com.mk.myandroid.resourceaccess.menu.ResourceMenuActivity;
import com.mk.myandroid.resourceaccess.string.ResourceStringActivity;
import com.mk.myandroid.resourceaccess.styletheme.ResourceStyleThemeActivity;
import com.mk.myandroid.resourceaccess.xml.ResourceXMLActivity;
import com.mk.myandroid.ui.ListCellData;

public class ResourceAccessActivity extends ListActivity {
	private ArrayAdapter<ListCellData> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		adapter.add(new ListCellData(this, "��Դ����֮�ַ�����Դ�͹��ʻ�",new Intent(this,ResourceStringActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮��ɫ�ͳߴ���Դ",new Intent(this,ResourceColorActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮������Դ",new Intent(this,ResourceArrayActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮ͼƬ��Դ",new Intent(this,ResourceDrawableActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮��ʽ��������Դ",new Intent(this,ResourceStyleThemeActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮�˵���Դ",new Intent(this,ResourceMenuActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮XMLԭʼ������Դ",new Intent(this,ResourceXMLActivity.class)));
		adapter.add(new ListCellData(this, "��Դ����֮assets��Դ",new Intent(this,ResourceAssetsActivity.class)));
		
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
		getMenuInflater().inflate(R.menu.resource_access, menu);
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
