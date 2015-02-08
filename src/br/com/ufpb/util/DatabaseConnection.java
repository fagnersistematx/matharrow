package br.com.ufpb.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseConnection {

	private static final String DATABASE_NAME = "banco_arrow003.db";
	private static final int DATABASE_VERSION = 1;
	private static SQLiteDatabase db;
	private static OpenHelper openHelper;
	private static DatabaseConnection databaseConnection;

	private DatabaseConnection(Context context) {
		openDatabase(context);		
	}

	private static void openDatabase(Context context) {
		openHelper = new OpenHelper(context);
		db = openHelper.getWritableDatabase();
	}

	private static class OpenHelper extends SQLiteOpenHelper {
		OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL("CREATE TABLE PLAYER(ID INTEGER PRIMARY KEY, "
					+ "NAME TEXT, SCORE DOUBLE )");
			
			db.execSQL("CREATE TABLE LESSON(ID INTEGER PRIMARY KEY, "
					+ "NAME TEXT NOT NULL, HELP TEXT )");
			
			db.execSQL("CREATE TABLE QUESTION(ID INTEGER PRIMARY KEY, "
					+ "ACTIVITY_ID INTEGER NOT NULL, QUESTION TEXT NOT NULL, ANSWER TEXT NOT NULL )");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Example",
					"Upgrading database, this will drop tables and recreate.");
			// db.execSQL("DROP TABLE IF EXISTS " + PACIENTE);
			// onCreate(db);
		}
	}
	
	public static SQLiteDatabase getDb() {
		return db;
	}

	public static DatabaseConnection getInstance(Context context){
		openDatabase(context);		
		if(databaseConnection == null){
			databaseConnection = new DatabaseConnection(context);
		}
		return databaseConnection;
	}
	
	public static void closeDatabase() {	    
	    if (openHelper != null) {
	        openHelper.close();
	    }
	    if (db != null) {
	        db.close();
	    }
	}
	
}