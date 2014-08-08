package com.mk.myandroid.datastorage.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDb extends SQLiteOpenHelper {

	public UsersDb(Context context) {
		super(context, "db", null, 3);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE user("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT DEFAULT \"\","
				+ "sex TEXT DEFAULT \"\")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		db.execSQL("DROP TABLE user");
		
		db.execSQL("CREATE TABLE user("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT DEFAULT \"\","
				+ "sex TEXT DEFAULT \"\")");

	}

}
