package com.example.asg6_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

//    public static final int DB_VERSION = 1;
//    public static final String DB_NAME = "registration_db";
//    public static final String TABLE_NAME = "registration_table";
//    public static final String REG_ID = "regId";
//    public static final String NAME = "name";
//    public static final String MOB = "mob";

    public DbHandler(Context context) {
        super(context, "registration_db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable = "CREATE TABLE registration_table(regId INTEGER PRIMARY KEY, name TEXT, mob TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTable = "DROP TABLE if EXISTS " + "registration_table";
        sqLiteDatabase.execSQL(dropTable);
    }

    public Boolean insertData(String name, String mob) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mob", mob);

        long result = sqLiteDatabase.insert("registration_table", null, contentValues);
//        sqLiteDatabase.close();
        if (result==-1)
            return false;
        else
            return true;
    }

    public ArrayList<Registration> getAllRegistrations() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ArrayList<Registration> regList = new ArrayList<>();
        String select = "SELECT * FROM registration_table";
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);

        if(cursor.moveToFirst()) {
            do {
                Registration newReg = new Registration();
                newReg.setId(Integer.parseInt(cursor.getString(0)));
                newReg.setName(cursor.getString(1));
                newReg.setMob(cursor.getString(2));
                regList.add(newReg);
            }while(cursor.moveToNext());
        }
        return regList;
    }
}
