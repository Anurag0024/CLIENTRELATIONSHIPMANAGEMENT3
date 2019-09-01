package com.example.clientrelationshipmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CRM.db";
    public static final String TABLE_NAME = "admin";
    public static final String TABLE_NAME2 = "addcontact";
    public static final String TABLE_NAME3 = "leads";
    public static final String TABLE_NAME4 = "opportunity";
    public static final String TABLE_NAME5 = "company";

    public LoginHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,repassword TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ldname TEXT,mob TEXT,email TEXT,company_name TEXT,contact TEXT,note TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ldid TEXT,ldname TEXT,mob TEXT,email TEXT,company_name TEXT,contact TEXT,note TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME4 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ldid TEXT,name TEXT,mob TEXT,email TEXT,company_name TEXT,contact TEXT,note TEXT )");
        db.execSQL("CREATE TABLE " + TABLE_NAME5 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,companyname TEXT,email TEXT,contact TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IFEXIXTS" + TABLE_NAME);
        db.execSQL("DROP TABLE IFEXIXTS" + TABLE_NAME2);
        db.execSQL("DROP TABLE IFEXIXTS" + TABLE_NAME3);
        db.execSQL("DROP TABLE IFEXISTS" + TABLE_NAME4);
        db.execSQL("DROP TABLE IFEXISTS" + TABLE_NAME5);
        onCreate(db);
    }

    public boolean saveContact(String ldname, String mob, String email, String company_name, String contact, String note) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ldname", ldname);
        contentValues.put("mob", mob);
        contentValues.put("email", email);
        contentValues.put("company_name", company_name);
        contentValues.put("contact", contact);
        contentValues.put("note", note);
        long result;
        result = sqLiteDatabase.insert(TABLE_NAME2, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public boolean saveLeads(String ldid, String ldname, String mob, String email, String company_name, String contact, String note) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ldid", ldid);
        contentValues.put("ldname", ldname);
        contentValues.put("mob", mob);
        contentValues.put("email", email);
        contentValues.put("company_name", company_name);
        contentValues.put("contact", contact);
        contentValues.put("note", note);
        long result;
        result = sqLiteDatabase.insert(TABLE_NAME3, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public boolean saveopportunity (String ldid, String ldname, String mob, String email, String company_name, String contact, String note)
        {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("ldid", ldid);
            contentValues.put("name", ldname);
            contentValues.put("mob", mob);
            contentValues.put("email", email);
            contentValues.put("company_name", company_name);
            contentValues.put("contact", contact);
            contentValues.put("note", note);
            long result;
            result = sqLiteDatabase.insert(TABLE_NAME4, null, contentValues);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

    public boolean savecompany(String companyname, String email, String contact) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("companyname", companyname);
        contentValues.put("email", email);
        contentValues.put("contact", contact);
        long result;
        result = sqLiteDatabase.insert(TABLE_NAME5, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean saveData(String email, String password, String repassword) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", email);
        contentValues.put("password", password);
        contentValues.put("password", repassword);
        long result;
        result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public Cursor ViewData(String tbname) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tbname, null);
        return cursor;
    }


    public Cursor ViewDataBy(String tbname,String by,String byValue) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tbname+" where "+by+"='"+byValue+"'", null);
        return cursor;
    }

    public Cursor LoginValid(String getuser, String getpass, String getrepass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from admin where username=" + getuser + " and password=" + getpass + " and repass=" + getrepass, null);
        return cursor;
    }

    public Boolean chkmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from admin  where username=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;


    }

    public Boolean chkpass(String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from admin  where password=?", new String[]{pass});
        if (cursor.getCount() > 0) return false;
        else return true;


    }

    public Boolean chkrepass(String repass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from admin  where repassword=?", new String[]{repass});
        if (cursor.getCount() > 0) return false;
        else return true;
    }
}



