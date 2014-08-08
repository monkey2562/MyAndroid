package com.mk.myandroid.datastorage.contentprovider;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.mk.myandroid.R;
import com.mk.myandroid.datastorage.sqlite.Db;

public class UseContentProviderActivity extends ListActivity {
	private SimpleCursorAdapter adapter;
	private EditText etName,etSex;
	private Button btnAdd;
	private Db db;
	private SQLiteDatabase dbRead,dbWrite;
	private OnClickListener btnAddListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			ContentValues cv = new ContentValues();
			cv.put("name", etName.getText().toString());
			cv.put("sex", etSex.getText().toString());
//			dbWrite.insert("user", null, cv);
			getContentResolver().insert(UsersCP.URI, cv);
			refreshListView();
		}
	};
	private OnItemLongClickListener listViewItemLongClickListener = new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				final int position, long id) {
			new AlertDialog.Builder(UseContentProviderActivity.this).setTitle("提醒").setMessage("确定要删除吗？").setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Cursor c = adapter.getCursor();
					c.moveToPosition(position);
					int itemId = c.getInt(c.getColumnIndex("_id"));
					dbWrite.delete("user", "_id=?", new String[]{itemId+""});
					refreshListView();
					
				}
			}).show();
			
			
			
			
			return true;//true表示长按成功
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_use_sqlite);
		etName = (EditText) findViewById(R.id.etName);
		etSex = (EditText) findViewById(R.id.etSex);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(btnAddListener);
		
		
		db = new Db(this);
		dbRead = db.getReadableDatabase();
		dbWrite = db.getWritableDatabase();
		
		
		adapter = new SimpleCursorAdapter(this, R.layout.user_list_cell, null, 
				new String[]{"name", "sex"}, new int[]{R.id.tvName,R.id.tvSex});
		setListAdapter(adapter);
		
		refreshListView();
		
		
		getListView().setOnItemLongClickListener(listViewItemLongClickListener);
		//写入数据库
//		SQLiteDatabase dbWrite = db.getWritableDatabase();
//		ContentValues cv = new ContentValues();
//		cv.put("name", "小张");
//		cv.put("sex", "男");
//		dbWrite.insert("user", null, cv);
//		
//		cv = new ContentValues();
//		cv.put("name", "小许");
//		cv.put("sex", "女");
//		dbWrite.insert("user", null, cv);	
//		db.close();
		
//		SQLiteDatabase dbRead = db.getReadableDatabase();
//		Cursor cursor = dbRead.query("user", null, null, null, null, null, null);
//		while (cursor.moveToNext()) {
//			String name = cursor.getString(cursor.getColumnIndex("name"));
//			String sex = cursor.getString(cursor.getColumnIndex("sex"));
//			System.out.println(String.format("name=%s,sex=%s", name,sex));
//			
//		}
	}
	
	private void refreshListView(){
//		Cursor cursor = dbRead.query("user", null, null, null, null, null, null);
//		adapter.changeCursor(cursor);
		adapter.changeCursor(getContentResolver().query(UsersCP.URI, null, null, null, null));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.use_content, menu);
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
