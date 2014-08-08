package com.mk.myandroid.datastorage.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class UsersCP extends ContentProvider {

	private UsersDb db;
	private SQLiteDatabase dbRead,dbWrite;
	private static final String TBALE_NAME = "user";
	public static final Uri URI = Uri.parse("content://com.mk.myandroid.usercp");
	@Override
	public boolean onCreate() {
		db = new UsersDb(getContext());
		dbRead = db.getReadableDatabase();
		dbWrite = db.getWritableDatabase();
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return dbRead.query(TBALE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		dbWrite.insert(TBALE_NAME, null, values);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		dbWrite.delete(TBALE_NAME, selection, selectionArgs);
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		dbWrite.update(TBALE_NAME, values, selection, selectionArgs);
		return 0;
	}

}
