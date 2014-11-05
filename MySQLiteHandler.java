package com.example.myfirst;

import android.R.string;
import android.app.DownloadManager.Query;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

public class MySQLiteHandler extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	private boolean result;
	// Books table name
	private static final String TABLE_USERS = "Users";

	// Books Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_USERNAME = "username";
	private static final String KEY_PASSWORD = "password";

	private static final String[] COLUMNS = { KEY_ID, KEY_USERNAME,
			KEY_PASSWORD };
	// Database version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "UsersDB";

	private static final Cursor SELECT = null;

	public MySQLiteHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CREATE_USERS_TABLE = "CREATE TABLE Users ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT, "
				+ "password TEXT )";

		// create books table
		db.execSQL(CREATE_USERS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older users table if existed
		db.execSQL("DROP TABLE IF EXISTS Users");

		// create fresh users table
		this.onCreate(db);

	}

	public boolean Login(String username, String password) {
		String count = "SELECT * FROM " + TABLE_USERS + " WHERE KEY_USERNAME="
				+ username + "KEY_USERNAME=" + password + ";";
		Cursor mCursor = db
				.rawQuery(count, null);

		if (mCursor != null) {
			return true;

		} else
			return false;

	}

	// Adding new contact
	public boolean addUser(String username, String password) {
		Users user = new Users();
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USERNAME, user.getUsername()); // Contact Name
		values.put(KEY_PASSWORD, user.getPassword()); // Contact Phone Number

		// Inserting Row
		db.insert(TABLE_USERS, null, values);
		db.close(); // Closing database connection
		return true;
	}

}
