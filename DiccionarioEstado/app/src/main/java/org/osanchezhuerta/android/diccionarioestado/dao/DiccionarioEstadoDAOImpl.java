package org.osanchezhuerta.android.diccionarioestado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import org.osanchezhuerta.android.diccionarioestado.vo.Estado;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by sanchezocth on 25/08/2016.
 */
public class DiccionarioEstadoDAOImpl extends DiccionarioEstadoDAO {
    private static final String WHERE_ID_EQUALS = DatabaseHandler.ID_COLUMN
            + " =?";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.ENGLISH);

    public DiccionarioEstadoDAOImpl(Context context) {
        super(context);
    }

    public ArrayList<Estado> obtenerEstados() {
        ArrayList<Estado> lstEstado = new ArrayList<Estado>();

        Cursor cursor = database.query(DatabaseHandler.STATE_TABLE,
                new String[] { DatabaseHandler.ID_COLUMN,
                        DatabaseHandler.NAME_COLUMN,
                        DatabaseHandler.DESCRIPTION_COLUMN}, null, null, null,
                null, null);
        while (cursor.moveToNext()) {
            Estado estado = new Estado();
            estado.setId(cursor.getInt(0));
            estado.setName(cursor.getString(1));
            estado.setDescription(cursor.getString(2));
            lstEstado.add(estado);
        }
        cursor.close();
        return lstEstado;
    }

    public ArrayList<Estado> obtenerEstados(long id) {
        ArrayList<Estado> lstEstado = new ArrayList<Estado>();

        String sql = "SELECT * FROM " + DatabaseHandler.STATE_TABLE
                + " WHERE " + DatabaseHandler.ID_COLUMN + " like ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + "%" });

        while (cursor.moveToNext()) {
            Estado estado = new Estado();
            estado.setId(cursor.getInt(0));
            estado.setName(cursor.getString(1));
            estado.setDescription(cursor.getString(2));
            lstEstado.add(estado);
        }
        cursor.close();
        return lstEstado;
    }

    public long save(Estado employee) {
        long resultado=0;

            ContentValues values = new ContentValues();
            values.put(DatabaseHandler.ID_COLUMN, employee.getId());
            values.put(DatabaseHandler.NAME_COLUMN, employee.getName());
            values.put(DatabaseHandler.DESCRIPTION_COLUMN, employee.getDescription());
            resultado =  database.insert(DatabaseHandler.STATE_TABLE, null, values);

        return resultado;
    }

    public Estado selectEstado(long id) {
        Estado estado = null;

        String sql = "SELECT * FROM " + DatabaseHandler.STATE_TABLE
                + " WHERE " + DatabaseHandler.ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + "" });

        if (cursor.moveToNext()) {
            estado = new Estado();
            estado.setId(cursor.getInt(0));
            estado.setName(cursor.getString(1));
            estado.setDescription(cursor.getString(2));
        }
        cursor.close();
        return estado;
    }


    public int delete(int id) {
        return database.delete(DatabaseHandler.STATE_TABLE, WHERE_ID_EQUALS,
                new String[] { id + "" });
    }
}
