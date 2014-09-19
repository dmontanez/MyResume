/*
* Resume Application
* September 2014
* Daniel J. Montanez
*/

package com.example.danielmontanez;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	//Database Data =================================================================================
	public static final String DATABASE_NAME = "AppResume.db";
	public static final int VERSION = 4;
	
	//=================================================================================
	//Database Seed Data; Personal Information
	//=================================================================================
	
	private static final String FIRST_NAME = "Daniel";
	private static final String MIDDLE_INITIAL = "J.";
	private static final String LAST_NAME = "Montanez";
	private static final String PHONE = "(661) 869-4325";
	private static final String EMAIL = "dmontanez86@gmail.com";
	private static final String ADDRESS_L1 = "7636 Palmilla Drive";
	private static final String ADDRESS_L2 = "Unit 110";
	private static final String CITY = "San Diego";
	private static final String STATE = "CA";
	private static final String ZIP = "92122";
	private static final String SUMMARY = "Excellent Technical Aptitude:\nQuick at acquiring new skills and utilizing new technology."
			+ "\n\nKnowledgeable of Software Engineering Fundamentals:\nCompetent in software development lifecycle – from conception through delivery."
			+ "\n\nInnovative:\nAble to develop unique methodology and procedures for accomplishing goals."
			+ "\n\nDouble-Loop Learner:\nActively critique personal methodology and decision making process, making adjustments when needed.";
	
	private static String SEED_DATA = "'" + FIRST_NAME + "', '"
			+ MIDDLE_INITIAL + "', '" 
			+ LAST_NAME + "', '" 
			+ PHONE + "', '" 
			+ EMAIL + "', '" 
			+ ADDRESS_L1 + "', '" 
			+ ADDRESS_L2 + "', '" 
			+ CITY + "', '" 
			+ STATE + "', '" 
			+ ZIP + "', '" 
			+ SUMMARY + "'";
	
	//=================================================================================
	//=================================================================================
	
	//Profile Data Fields ===================================================================================
	public static final String PROFILE_TABLE = "profile_table";
	public static final String PROFILE_ID = "_id";
	public static final String PROFILE_FNAME = "first_name";
	public static final String PROFILE_MI = "middle_initial";
	public static final String PROFILE_LNAME = "last_name";
	public static final String PROFILE_PHONE = "phone";
	public static final String PROFILE_EMAIL = "email";
	public static final String PROFILE_ADDRESS_L1 = "address_1";
	public static final String PROFILE_ADDRESS_L2 = "address_2";
	public static final String PROFILE_CITY = "city";
	public static final String PROFILE_STATE = "state";
	public static final String PROFILE_ZIP = "zip";
	public static final String PROFILE_SUMMARY = "summary";
		
	//String for all PROFILE_TABLE Fields =====================================================================
	public static final String[] PROFILE_FIELDS = new String[] {PROFILE_ID, PROFILE_FNAME, PROFILE_MI, PROFILE_LNAME, PROFILE_PHONE, PROFILE_EMAIL, PROFILE_ADDRESS_L1, PROFILE_ADDRESS_L2, PROFILE_CITY, PROFILE_STATE, PROFILE_ZIP, PROFILE_SUMMARY};
	
	//SQL Statement for creating the Profile Table. ============================================================
	private final String createProfile = "CREATE TABLE IF NOT EXISTS " + PROFILE_TABLE + " ( "
			+ PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ PROFILE_FNAME + " TEXT, "
			+ PROFILE_MI + " TEXT, "
			+ PROFILE_LNAME + " TEXT, "
			+ PROFILE_PHONE + " TEXT, "
			+ PROFILE_EMAIL + " TEXT, "
			+ PROFILE_ADDRESS_L1 + " TEXT, "
			+ PROFILE_ADDRESS_L2 + " TEXT, "
			+ PROFILE_CITY + " TEXT, "
			+ PROFILE_STATE + " TEXT, "
			+ PROFILE_ZIP + " TEXT, " 
			+ PROFILE_SUMMARY + " TEXT);";
	
	//Initializer ===============================================================================================
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}
	
	//Create and Upgrade ========================================================================================
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(createProfile);
		
		db.execSQL("INSERT INTO " + PROFILE_TABLE + "(" 
					+ PROFILE_FNAME + ", "
					+ PROFILE_MI  + ", "
					+ PROFILE_LNAME + ", "
					+ PROFILE_PHONE + ", "
					+ PROFILE_EMAIL + ", "
					+ PROFILE_ADDRESS_L1 + ", "
					+ PROFILE_ADDRESS_L2 + ", "
					+ PROFILE_CITY + ", "
					+ PROFILE_STATE + ", "
					+ PROFILE_ZIP + ", "
					+ PROFILE_SUMMARY
				+ ") VALUES (" 
					+ SEED_DATA
				+ ");");
				
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// Drop older tables if they exist
		db.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
		
		// create fresh database table
		this.onCreate(db);
	}

	//Profile manipulation methods =================================================================================
	public Profile getProfile (int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(PROFILE_TABLE,  PROFILE_FIELDS, PROFILE_ID + " = ?", new String[] {
				String.valueOf(id)
				}, null, null, null, null);
		
		if (cursor != null)
			cursor.moveToFirst();
		
		Profile profile = new Profile();
		profile.setId(Integer.parseInt(cursor.getString(0)));
		profile.setFName(cursor.getString(1));
		profile.setMInit(cursor.getString(2));
		profile.setLName(cursor.getString(3));
		profile.setPhone(cursor.getString(4));
		profile.setEmail(cursor.getString(5));
		profile.setAddr1(cursor.getString(6));
		profile.setAddr2(cursor.getString(7));
		profile.setCity(cursor.getString(8));
		profile.setState(cursor.getString(9));
		profile.setZip(cursor.getString(10));
		profile.setSummary(cursor.getString(11));
		
		
		return profile;
	}
	
}
