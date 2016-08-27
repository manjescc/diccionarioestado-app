package org.osanchezhuerta.android.diccionarioestado.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;

import org.osanchezhuerta.android.diccionarioestado.R;

/**
 * Created by sanchezocth on 25/08/2016.
 */
public class SelectEstadoDialogFragment extends DialogFragment  {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder myDialog =new AlertDialog.Builder(getActivity());

                // Set Dialog Icon
        myDialog.setIcon(R.drawable.androidhappy);
                // Set Dialog Title
        myDialog.setTitle("Alert DialogFragment");
                // Set Dialog Message
        myDialog.setMessage("Alert DialogFragment Tutorial");

                // Positive button
        myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // Negative Button
        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                        // Do something else
                    }
                });
        return myDialog.create();
    }
}
