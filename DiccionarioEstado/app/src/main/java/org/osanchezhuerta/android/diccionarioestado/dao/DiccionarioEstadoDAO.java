package org.osanchezhuerta.android.diccionarioestado.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sanchezocth on 25/08/2016.
 */
public class DiccionarioEstadoDAO {
    protected SQLiteDatabase database;
    private DatabaseHandler dbHelper;
    private Context mContext;

    public DiccionarioEstadoDAO(Context context) {
        this.mContext = context;
        dbHelper = DatabaseHandler.getHelper(mContext);
       // open();
    }
    public void openWrite() throws SQLException {
        if(dbHelper == null) {
            dbHelper = DatabaseHandler.getHelper(mContext);
        }
        database = dbHelper.getWritableDatabase();
    }
    public void openRead() throws SQLException {
        if(dbHelper == null)
            dbHelper = DatabaseHandler.getHelper(mContext);
        database = dbHelper.getReadableDatabase();
    }
    public void deleteDatabase(){
        mContext.deleteDatabase(DatabaseHandler.DATABASE_NAME);
    }

    public void close() {
        if(dbHelper!=null) {
            dbHelper.close();
            database = null;
        }
    }


    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    public DatabaseHandler getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DatabaseHandler dbHelper) {
        this.dbHelper = dbHelper;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

}
