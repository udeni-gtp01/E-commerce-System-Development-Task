//package com.udeni.e_commerce_system_development_task.database;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "ecommerce.db";
//    private static final int DATABASE_VERSION = 1;
//
//    // Table names
//    private static final String TABLE_CUSTOMER = "customer";
//    private static final String TABLE_ITEM = "item";
//    private static final String TABLE_ORDER = "customerOrder";
//    private static final String TABLE_ORDER_ITEM = "orderItem";
//
//    // Column names
//    private static final String COL_CUSTOMER_ID = "customerId";
//    private static final String COL_CUSTOMER_NAME = "name";
//    private static final String COL_CUSTOMER_CONTACT = "contact";
//
//    private static final String COL_ITEM_CODE = "itemCode";
//    private static final String COL_ITEM_NAME = "name";
//    private static final String COL_ITEM_PRICE = "itemPrice";
//
//    private static final String COL_ORDER_RECEIPT_NUMBER = "receiptNumber";
//    private static final String COL_ORDER_CUSTOMER_ID = "customerId";
//    private static final String COL_ORDER_DATE_TIME = "dateTime";
//
//    private static final String COL_ORDER_ITEM_RECEIPT_NUMBER = "receiptNumber";
//    private static final String COL_ORDER_ITEM_ITEM_CODE = "itemCode";
//    private static final String COL_ORDER_ITEM_QTY = "qty";
//    private static final String COL_ORDER_ITEM_PRICE = "itemPrice";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        // Create tables using SQL statements
//        db.execSQL("CREATE TABLE " + TABLE_CUSTOMER + " (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_CUSTOMER_ID + " TEXT UNIQUE," +
//                COL_CUSTOMER_NAME + " TEXT DEFAULT ''," +
//                COL_CUSTOMER_CONTACT + " TEXT DEFAULT '')");
//
//        db.execSQL("CREATE TABLE " + TABLE_ITEM + " (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_ITEM_CODE + " TEXT UNIQUE," +
//                COL_ITEM_NAME + " TEXT DEFAULT ''," +
//                COL_ITEM_PRICE + " REAL DEFAULT 0)");
//
//        db.execSQL("CREATE TABLE " + TABLE_ORDER + " (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_ORDER_RECEIPT_NUMBER + " TEXT UNIQUE," +
//                COL_ORDER_CUSTOMER_ID + " TEXT," +
//                COL_ORDER_DATE_TIME + " TEXT)"); // Consider using a LONG for timestamp
//
//        db.execSQL("CREATE TABLE " + TABLE_ORDER_ITEM + " (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_ORDER_ITEM_RECEIPT_NUMBER + " TEXT," +
//                COL_ORDER_ITEM_ITEM_CODE + " TEXT," +
//                COL_ORDER_ITEM_QTY + " INTEGER," +
//                COL_ORDER_ITEM_PRICE + " REAL," +
//                "FOREIGN KEY (" + COL_ORDER_ITEM_RECEIPT_NUMBER + ") REFERENCES " + TABLE_ORDER + "(" + COL_ORDER_RECEIPT_NUMBER + ")," +
//                "FOREIGN KEY (" + COL_ORDER_ITEM_ITEM_CODE + ") REFERENCES " + TABLE_ITEM + "(" + COL_ITEM_CODE + ")" +
//                ")");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Handle database schema upgrades
//    }
//}
