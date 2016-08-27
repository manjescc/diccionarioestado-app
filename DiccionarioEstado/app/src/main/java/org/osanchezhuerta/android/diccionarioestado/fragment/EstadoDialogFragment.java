package org.osanchezhuerta.android.diccionarioestado.fragment;

/**
 * Created by sanchezocth on 26/08/2016.
 */
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.osanchezhuerta.android.diccionarioestado.R;
import org.osanchezhuerta.android.diccionarioestado.vo.Estado;

public class EstadoDialogFragment extends DialogFragment {//implements OnClickListener {

    final String LOG_TAG = "myLogs";

    private Estado estadoSeleccionado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.fragment_estadodialog, null);
        /*
        ((TextView)v.findViewById(R.id.txtDlgEstadoIdEstado)).setText(estadoSeleccionado.getId());
        ((TextView)v.findViewById(R.id.txtDlgEstadoNombre)).setText(estadoSeleccionado.getName());
        ((TextView)v.findViewById(R.id.txtDlgEstadoDescripcion)).setText(estadoSeleccionado.getDescription());
*/
        /*v.findViewById(R.id.btnYes).setOnClickListener(this);
        v.findViewById(R.id.btnNo).setOnClickListener(this);
        v.findViewById(R.id.btnMaybe).setOnClickListener(this);*/
        TextView tvwId=  (TextView) v.findViewById(R.id.txtDlgEstadoIdEstado);
        tvwId.setText(estadoSeleccionado.getId()+"");
        TextView tvwNombre=  (TextView) v.findViewById(R.id.txtDlgEstadoNombre);
        tvwNombre.setText(estadoSeleccionado.getName());
        TextView tvwDescription=  (TextView) v.findViewById(R.id.txtDlgEstadoDescripcion);
        tvwDescription.setText(estadoSeleccionado.getDescription());

        final Button btnSI = (Button) v.findViewById(R.id.btnAceptarDlgEstado);
        btnSI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("test","test123");
                dismiss();
            }
        });
        return v;
    }

    public void onSiClick(View v) {
        Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
        dismiss();
    }
    public void onNoClick(View v) {
        Log.d(LOG_TAG, "Dialog 2: " + ((Button) v).getText());
        dismiss();
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }
/*
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
*/
}