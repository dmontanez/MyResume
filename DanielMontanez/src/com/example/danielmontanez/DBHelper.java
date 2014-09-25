/*
 * Resume Application
 * September 2014
 * Daniel J. Montanez
 */

package com.example.danielmontanez;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	// Database Data
	// =================================================================================
	public static final String DATABASE_NAME = "AppResume.db";
	public static final int VERSION = 8;

	// =================================================================================
	// Database Seed Data; Personal Information
	// =================================================================================

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

	private static String PROFILE_SEED = "'" + FIRST_NAME + "', '"
			+ MIDDLE_INITIAL + "', '" + LAST_NAME + "', '" + PHONE + "', '"
			+ EMAIL + "', '" + ADDRESS_L1 + "', '" + ADDRESS_L2 + "', '" + CITY
			+ "', '" + STATE + "', '" + ZIP + "', '" + SUMMARY + "'";

	// Education Seeds
	// ---------------------------------------------------------------------
	private static final String ED_UNIV_0 = "Penn State University";
	private static final String ED_DEG_0 = "Masters";
	private static final String ED_DEG_STAT_0 = "Graduated";
	private static final String ED_DEG_DATE_0 = "August 2014";
	private static final String ED_MAJ_0 = "Software Engineering";
	private static final String ED_MIN_0 = "";
	private static final String ED_DATE_0 = "2012 - 2014";

	private static String ED_SEED_0 = "'" + ED_UNIV_0 + "', '" + ED_DEG_0
			+ "', '" + ED_DEG_STAT_0 + "', '" + ED_DEG_DATE_0 + "', '"
			+ ED_MAJ_0 + "', '" + ED_MIN_0 + "', '" + ED_DATE_0 + "'";

	private static final String ED_UNIV_1 = "Cal State University, Bakersfield";
	private static final String ED_DEG_1 = "B.S.";
	private static final String ED_DEG_STAT_1 = "Graduated";
	private static final String ED_DEG_DATE_1 = "June 2011";
	private static final String ED_MAJ_1 = "Computer Science";
	private static final String ED_MIN_1 = "Philosophy";
	private static final String ED_DATE_1 = "2005 - 2011";

	private static String ED_SEED_1 = "'" + ED_UNIV_1 + "', '" + ED_DEG_1
			+ "', '" + ED_DEG_STAT_1 + "', '" + ED_DEG_DATE_1 + "', '"
			+ ED_MAJ_1 + "', '" + ED_MIN_1 + "', '" + ED_DATE_1 + "'";

	// Interest Seed
	// -----------------------------------------------------------------------
	private static final String IN_TITLE_0 = "Four Year Letter Winner";
	private static final String IN_DESC_0 = "CSUB Division I Wrestling Team";
	private static final String IN_YEAR_0 = "2006 - 2010";

	private static String IN_SEED_0 = "'" + IN_TITLE_0 + "', '" + IN_DESC_0
			+ "', '" + IN_YEAR_0 + "'";

	private static final String IN_TITLE_1 = "Assistant Wrestling Coach";
	private static final String IN_DESC_1 = "Cathedral Catholic HS";
	private static final String IN_YEAR_1 = "2013 - Present";

	private static String IN_SEED_1 = "'" + IN_TITLE_1 + "', '" + IN_DESC_1
			+ "', '" + IN_YEAR_1 + "'";
	
	// Course Seed
	// -----------------------------------------------------------------------

	private static String[] PSU_COURSES = { "Requirements Engineering",
			"Software System Design (UML)", "Pattern Oriented Desing",
			"Database Design", "Software System Architecture",
			"Enterprise Integration", "Applied Human Computer Interaction",
			"Program Understanding", "Web Security and Privacy",
			"Software Project Management",
			"Advanced Software Enginering Studio" };
	
	private static String[] CSUB_COURSES = { "Web Design",
			"Advanced Computer Networks", "Database Systems",
			"Software Engineering",
			"Beginning and Advanced Artificial Intelligence",
			"Programming Languages", "Advanced Computer Architecture",
			"Methods in Applied Statistics", "Data Analysis" };

	// =================================================================================
	// =================================================================================

	// Profile Data Fields
	// ===================================================================================
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

	// String for all PROFILE_TABLE Fields
	// =====================================================================
	public static final String[] PROFILE_FIELDS = new String[] { PROFILE_ID,
			PROFILE_FNAME, PROFILE_MI, PROFILE_LNAME, PROFILE_PHONE,
			PROFILE_EMAIL, PROFILE_ADDRESS_L1, PROFILE_ADDRESS_L2,
			PROFILE_CITY, PROFILE_STATE, PROFILE_ZIP, PROFILE_SUMMARY };

	// SQL Statement for creating the Profile Table.
	// ============================================================
	private final String createProfile = "CREATE TABLE IF NOT EXISTS "
			+ PROFILE_TABLE + " ( " + PROFILE_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROFILE_FNAME
			+ " TEXT, " + PROFILE_MI + " TEXT, " + PROFILE_LNAME + " TEXT, "
			+ PROFILE_PHONE + " TEXT, " + PROFILE_EMAIL + " TEXT, "
			+ PROFILE_ADDRESS_L1 + " TEXT, " + PROFILE_ADDRESS_L2 + " TEXT, "
			+ PROFILE_CITY + " TEXT, " + PROFILE_STATE + " TEXT, "
			+ PROFILE_ZIP + " TEXT, " + PROFILE_SUMMARY + " TEXT);";

	// Education Data Fields
	// ====================================================================================
	public static final String ED_TABLE = "education_table";
	public static final String ED_ID = "_id";
	public static final String ED_UNIV = "education_university";
	public static final String ED_DEG = "education_degree";
	public static final String ED_DEG_STAT = "degree_status";
	public static final String ED_DEG_DATE = "degree_date";
	public static final String ED_MAJ = "education_major";
	public static final String ED_MIN = "education_minor";
	public static final String ED_DATE = "education_date";

	// String for all ED_TABLE Fields.
	// ===========================================================================
	public static final String[] ED_FIELDS = new String[] { ED_ID, ED_UNIV,
			ED_DEG, ED_DEG_STAT, ED_DEG_DATE, ED_MAJ, ED_MIN, ED_DATE };

	// SQL Statement for creating the Education Table.
	// ===========================================================
	public static final String createEducation = "CREATE TABLE IF NOT EXISTS "
			+ ED_TABLE + " ( " + ED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ED_UNIV + " TEXT, " + ED_DEG + " TEXT, " + ED_DEG_STAT
			+ " TEXT, " + ED_DEG_DATE + " TEXT, " + ED_MAJ + " TEXT, " + ED_MIN
			+ " TEXT, " + ED_DATE + " TEXT);";

	// Interest Data Fields
	// ======================================================================================
	public static final String IN_TABLE = "interest_table";
	public static final String IN_ID = "_id";
	public static final String IN_TITLE = "interest_title";
	public static final String IN_DESC = "interest_description";
	public static final String IN_DATE = "interest_date";

	// String for IN_TABLE Fields.
	// =====================================================================================
	public static final String[] IN_FIELDS = new String[] { IN_ID, IN_TITLE,
			IN_DESC, IN_DATE };

	// SQL Statement for creating the Interest Table.
	// =====================================================================================
	public static final String createInterest = "CREATE TABLE IF NOT EXISTS "
			+ IN_TABLE + " ( " + IN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ IN_TITLE + " TEXT, " + IN_DESC + " TEXT, " + IN_DATE + " TEXT);";
	
	// Course Data Fields
	// ======================================================================================
	public static final String CRS_TABLE = "course_table";
	public static final String CRS_ID = "_id";
	public static final String CRS_SCHL_ID = "school_id";
	public static final String CRS_TITLE = "course_title";

	// String for CRS_TABLE Fields.
	// =====================================================================================
	public static final String[] CRS_FIELDS = new String[] { CRS_ID, CRS_SCHL_ID,
			CRS_TITLE };

	// SQL Statement for creating the Course Table.
	// =====================================================================================
	public static final String createCourse = "CREATE TABLE IF NOT EXISTS "
			+ CRS_TABLE + " ( " + CRS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ CRS_SCHL_ID + " TEXT, " + CRS_TITLE + " TEXT);";
	
	// Initializer
	// ===============================================================================================
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	// Create and Upgrade
	// ========================================================================================
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(createProfile);
		db.execSQL(createEducation);
		db.execSQL(createInterest);
		db.execSQL(createCourse);

		// Seed the profile.
		db.execSQL("INSERT INTO " + PROFILE_TABLE + "(" + PROFILE_FNAME + ", "
				+ PROFILE_MI + ", " + PROFILE_LNAME + ", " + PROFILE_PHONE
				+ ", " + PROFILE_EMAIL + ", " + PROFILE_ADDRESS_L1 + ", "
				+ PROFILE_ADDRESS_L2 + ", " + PROFILE_CITY + ", "
				+ PROFILE_STATE + ", " + PROFILE_ZIP + ", " + PROFILE_SUMMARY
				+ ") VALUES (" + PROFILE_SEED + ");");

		// Seed the education.
		db.execSQL("INSERT INTO " + ED_TABLE + "(" + ED_UNIV + ", " + ED_DEG
				+ ", " + ED_DEG_STAT + ", " + ED_DEG_DATE + ", " + ED_MAJ + ", " + ED_MIN + ", " + ED_DATE + ") VALUES ("
				+ ED_SEED_0 + ");");

		db.execSQL("INSERT INTO " + ED_TABLE + "(" + ED_UNIV + ", " + ED_DEG
				+ ", " + ED_DEG_STAT + ", " + ED_DEG_DATE + ", " + ED_MAJ + ", " + ED_MIN + ", " + ED_DATE + ") VALUES ("
				+ ED_SEED_1 + ");");

		// Seed the interest.
		db.execSQL("INSERT INTO " + IN_TABLE + "(" + IN_TITLE + ", " + IN_DESC
				+ ", " + IN_DATE + ") VALUES ("
				+ IN_SEED_0 + ");");
		
		db.execSQL("INSERT INTO " + IN_TABLE + "(" + IN_TITLE + ", " + IN_DESC
				+ ", " + IN_DATE + ") VALUES ("
				+ IN_SEED_1 + ");");
		
		// Seed the courses.
		for (int i = 0; i < PSU_COURSES.length; i++) {
			db.execSQL("INSERT INTO " + CRS_TABLE + "(" + CRS_SCHL_ID + ", "
					+ CRS_TITLE + ") VALUES ('1', '" + PSU_COURSES[i] + "');");
		}
		
		for (int i = 0; i < CSUB_COURSES.length; i++) {
			db.execSQL("INSERT INTO " + CRS_TABLE + "(" + CRS_SCHL_ID + ", "
					+ CRS_TITLE + ") VALUES ('2', '" + CSUB_COURSES[i] + "');");
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// Drop older tables if they exist
		db.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + ED_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + IN_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + CRS_TABLE);

		// create fresh database table
		this.onCreate(db);
	}

	// Profile manipulation methods
	// =================================================================================
	public Profile getProfile(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		Cursor cursor = db.query(PROFILE_TABLE, PROFILE_FIELDS, PROFILE_ID
				+ " = ?", new String[] { String.valueOf(id) }, null, null,
				null, null);

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

	// Education manipulation methods
	// =================================================================================
	public Education getEducation(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		Cursor cursor = db.query(ED_TABLE, ED_FIELDS, ED_ID + " = ?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();

		Education education = new Education();
		education.setId(Integer.parseInt(cursor.getString(0)));
		education.setUniversity(cursor.getString(1));
		education.setDegree(cursor.getString(2));
		education.setMajor(cursor.getString(3));
		education.setMinor(cursor.getString(4));
		education.setDate(cursor.getString(5));

		return education;
	}

	public List<Education> getAllEducaion() {

		List<Education> educations = new LinkedList<Education>();
		String query = "SELECT * FROM " + ED_TABLE;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		Education education = null;

		if (cursor.moveToFirst()) {
			do {
				education = new Education();
				education.setId(Integer.parseInt(cursor.getString(0)));
				education.setUniversity(cursor.getString(1));
				education.setDegree(cursor.getString(2));
				education.setMajor(cursor.getString(3));
				education.setMinor(cursor.getString(4));
				education.setDate(cursor.getString(5));
				educations.add(education);
			} while (cursor.moveToNext());
		}

		return educations;
	}
	
	// Interest manipulation methods
		// =================================================================================
		public Interest getInterest(int id) {
			SQLiteDatabase db = this.getWritableDatabase();

			Cursor cursor = db.query(IN_TABLE, IN_FIELDS, IN_ID + " = ?",
					new String[] { String.valueOf(id) }, null, null, null, null);

			if (cursor != null)
				cursor.moveToFirst();

			Interest interest = new Interest();
			interest.setId(Integer.parseInt(cursor.getString(0)));
			interest.setTitle(cursor.getString(1));
			interest.setDescription(cursor.getString(2));
			interest.setDate(cursor.getString(3));

			return interest;
		}

		public List<Interest> getAllInterest() {

			List<Interest> interests = new LinkedList<Interest>();
			String query = "SELECT * FROM " + IN_TABLE;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(query, null);

			Interest interest = null;

			if (cursor.moveToFirst()) {
				do {
					interest = new Interest();
					interest.setId(Integer.parseInt(cursor.getString(0)));
					interest.setTitle(cursor.getString(1));
					interest.setDescription(cursor.getString(2));
					interest.setDate(cursor.getString(3));
					interests.add(interest);
				} while (cursor.moveToNext());
			}

			return interests;
		}

}
