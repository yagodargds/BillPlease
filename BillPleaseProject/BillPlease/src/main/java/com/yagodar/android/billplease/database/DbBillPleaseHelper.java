package com.yagodar.android.billplease.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yagodar.android.database.sqlite.DbBaseHelper;
import com.yagodar.android.database.sqlite.DbTableBaseManager;

/**
 * Created by Yagodar on 19.08.13.
 */
public class DbBillPleaseHelper extends DbBaseHelper<DbBillPleaseManager> {
    protected DbBillPleaseHelper(Context context, String dbName, SQLiteDatabase.CursorFactory csFactory, int dbVersion) {
        super(context, dbName, csFactory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (DbTableBaseManager dbTableManager : getDbManager().getAllDbTableManagers()) {
            db.execSQL(dbTableManager.getSQLExprCreateDbTable());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (DbTableBaseManager dbTableManager : getDbManager().getAllDbTableManagers()) {
            db.execSQL(dbTableManager.getSQLExprDeleteDbTable());
        }

        onCreate(db);
    }
}