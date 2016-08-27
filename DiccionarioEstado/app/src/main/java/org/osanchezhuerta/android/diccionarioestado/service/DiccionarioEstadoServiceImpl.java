package org.osanchezhuerta.android.diccionarioestado.service;

import android.content.Context;
import android.util.Log;

import org.osanchezhuerta.android.diccionarioestado.dao.DiccionarioEstadoDAOImpl;
import org.osanchezhuerta.android.diccionarioestado.vo.Estado;

import java.util.ArrayList;

/**
 * Created by sanchezocth on 26/08/2016.
 */
public class DiccionarioEstadoServiceImpl {

    private DiccionarioEstadoDAOImpl diccionarioEstadoDAO;

    public DiccionarioEstadoServiceImpl(Context context) {
        diccionarioEstadoDAO = new DiccionarioEstadoDAOImpl(context);
    }

    public ArrayList<Estado> obtenerEstados() {
        ArrayList<Estado> lstEstado = new ArrayList<Estado>(0);
        diccionarioEstadoDAO.openRead();
        try {
            diccionarioEstadoDAO.getDatabase().beginTransaction();
            lstEstado.addAll(diccionarioEstadoDAO.obtenerEstados());
            diccionarioEstadoDAO.getDatabase().setTransactionSuccessful();
        }catch(Exception exception) {
            Log.e("obtenerEstados",exception.getMessage(),exception);
        }finally {
            diccionarioEstadoDAO.getDatabase().endTransaction();
            diccionarioEstadoDAO.close();
        }
        return lstEstado;
    }

    public ArrayList<Estado> obtenerEstados(long id) {
        ArrayList<Estado> lstEstado = new ArrayList<Estado>(0);
        diccionarioEstadoDAO.openRead();
        try {
            diccionarioEstadoDAO.getDatabase().beginTransaction();
            lstEstado.addAll(diccionarioEstadoDAO.obtenerEstados(id));
            diccionarioEstadoDAO.getDatabase().setTransactionSuccessful();
        }catch(Exception exception) {
            Log.e("obtenerEstados",exception.getMessage(),exception);
        }finally {
            diccionarioEstadoDAO.getDatabase().endTransaction();
            diccionarioEstadoDAO.close();
        }
        return lstEstado;
    }

    public void guardarEstado(Estado estado){
        diccionarioEstadoDAO.openWrite();
        try {
            diccionarioEstadoDAO.getDatabase().beginTransaction();
            Estado estadodb = diccionarioEstadoDAO.selectEstado(estado.getId());
            if(estadodb==null) {
                diccionarioEstadoDAO.save(estado);
            }
            diccionarioEstadoDAO.getDatabase().setTransactionSuccessful();
        }catch(Exception exception) {
            Log.e("guardarEstado",exception.getMessage(),exception);
        }finally {
            diccionarioEstadoDAO.getDatabase().endTransaction();
            diccionarioEstadoDAO.close();
        }
    }

    public int delete(int id){
        diccionarioEstadoDAO.openWrite();
        int resultado =0;
        try {
            diccionarioEstadoDAO.getDatabase().beginTransaction();
            resultado = diccionarioEstadoDAO.delete(id);
            diccionarioEstadoDAO.getDatabase().setTransactionSuccessful();
        }catch(Exception exception) {
            Log.e("delete",exception.getMessage(),exception);
        }finally {
            diccionarioEstadoDAO.getDatabase().endTransaction();
            diccionarioEstadoDAO.close();
        }
        return resultado;
    }

    public DiccionarioEstadoDAOImpl getDiccionarioEstadoDAO() {
        return diccionarioEstadoDAO;
    }

    public void setDiccionarioEstadoDAO(DiccionarioEstadoDAOImpl diccionarioEstadoDAO) {
        this.diccionarioEstadoDAO = diccionarioEstadoDAO;
    }
}
