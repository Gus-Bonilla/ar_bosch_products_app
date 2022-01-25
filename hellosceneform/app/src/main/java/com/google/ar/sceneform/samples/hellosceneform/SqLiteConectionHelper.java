package com.google.ar.sceneform.samples.hellosceneform;

/*
The methods of this class creates and actualizes the SQLite database files.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.ar.sceneform.samples.hellosceneform.utilities.Utilities;

public class SqLiteConectionHelper extends SQLiteOpenHelper {



    public SqLiteConectionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilities.CREATE_TOOL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tools");
        onCreate(db);
    }
}
