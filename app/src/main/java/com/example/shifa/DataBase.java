package com.example.shifa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.audiofx.DynamicsProcessing;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class DataBase extends SQLiteOpenHelper {
    // Set the Data Base Name and version
    private static final String DataBase_name = "shifa.db";
    private static final int DataBase_version = 1;
    //set the Data Base Object
    private SQLiteDatabase DataBase;


    public DataBase(Context context) {
        super(context, DataBase_name, null, DataBase_version);
    }

    @Override
    public void onCreate(SQLiteDatabase Data_base) {
        //this method allows to create tables to the data base shifa
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //this method allow to upgrade the data base i for the old version and i1
        //for the new version
    }


    public boolean openDataBase() {

        String data_base_path = this.getReadableDatabase().getPath();
        // if the data base is open return
        if(DataBase != null && DataBase.isOpen()) return true;
        DataBase = SQLiteDatabase.openDatabase(data_base_path , null , SQLiteDatabase.OPEN_READWRITE);
        return true;
    }
    public boolean closeDataBase() {
        DataBase.close();
        if(!DataBase.isOpen()) return true;
        return false;
    }
    public boolean createT(){
        DataBase = this.getWritableDatabase();
        String query = "CREATE TABLE IF NOT EXISTS Users "+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT NOT NULL,"+
                "email TEXT NOT NULL,password TEXT NOT NULL,"+
                "firstname TEXT NOT NULL,lastname TEXT NOT NULL,"+
                "gender TEXT NOT NULL,age INTEGER NOT NULL,PRIMARY KEY"+
                "(id)) ";
        DataBase.execSQL(query);
        return  true;
    }
    public boolean insertUser(String username ,String password , String email ,String last_name , String first_name , int age , String gender){

        Log.d(null,"table :"+DataBase.getPath());
        ContentValues valuse = new ContentValues();
        String sqlQuery = "INSERT INTO Users(id, username, email, password, firstname, lastname, gender, age) VALUES ( "+new Random().nextInt(1200) +" ,'"
                +username+
                "','"+email+
                "','"+password+
                "','"+first_name+
                "','"+last_name+
                "','"+gender+"',"+
                +age+")";
        DataBase.execSQL(sqlQuery);
        return  true;
    }
}
