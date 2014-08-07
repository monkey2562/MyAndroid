package com.mk.myandroid.datastorage.sqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;

import com.mk.myandroid.R;

public class UseSqliteActivity extends ListActivity {
	private SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_use_sqlite);
		Db db = new Db(this);
		SQLiteDatabase dbRead = db.getReadableDatabase();
		Cursor cursor = dbRead.query("user", null, null, null, null, null, null);
		adapter = new SimpleCursorAdapter(this, R.layout.user_list_cell, cursor, 
				new String[]{"name", "sex"}, new int[]{R.id.tvName,R.id.tvSex});
		setListAdapter(adapter);
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.use_sqlite, menu);
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
