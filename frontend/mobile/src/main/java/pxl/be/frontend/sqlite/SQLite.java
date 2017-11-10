package pxl.be.frontend.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 11400982 on 10/11/2017.
 */

public class SQLite extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 5;

    // Database Name
    private static final String DATABASE_NAME = "MDev";

    // Table Names
    private static final String TABLE_CITIES = "cities";
    private static final String TABLE_EVENTS = "events";

    // Common column names


    // TABLE_CITIES - column names
    private static final String KEY_POSTCODE = "postcode";
    private static final String KEY_NAME = "name";

    // TABLE_DISHES - column names
    private static final String KEY_EVENT_ID = "event_id";

    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CITY = "city";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PRICE = "price";
    private static final String KEY_TICKET_LINK = "ticket_link";



    // Table Create Statements
    // TABLE_CITIES - create statement
    private static final String CREATE_TABLE_CITIES = "CREATE TABLE "
            + TABLE_CITIES + "(" + KEY_POSTCODE + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT)";

    // TABLE_DISHES - create statement
    private static final String CREATE_TABLE_EVENTS = "CREATE TABLE "
            + TABLE_EVENTS + "(" + KEY_EVENT_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_CITY + " TEXT,"
            + KEY_PRICE + " DOUBLE," + KEY_TICKET_LINK + " TEXT)";

    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_CITIES);
        db.execSQL(CREATE_TABLE_EVENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        onCreate(db);
    }

    public boolean insertCities(String postal_code, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();;
        contentValues.put(KEY_POSTCODE, postal_code);
        contentValues.put(KEY_NAME, name);
        long result = db.insert(TABLE_CITIES, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertEvents(int id, String name, String description, String address, String city, double price, String ticketLink) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EVENT_ID, id);
        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_DESCRIPTION, description);
        contentValues.put(KEY_CITY, city);
        contentValues.put(KEY_PRICE, price);
        contentValues.put(KEY_TICKET_LINK, ticketLink);

        long result = db.insert(TABLE_EVENTS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllEvents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_EVENTS, null);
        return res;
    }

    public Cursor getAllCities() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_CITIES, null);
        return res;
    }
}

