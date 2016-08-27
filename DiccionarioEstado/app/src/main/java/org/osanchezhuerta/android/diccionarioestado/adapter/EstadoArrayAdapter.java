package org.osanchezhuerta.android.diccionarioestado.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.osanchezhuerta.android.diccionarioestado.R;
import org.osanchezhuerta.android.diccionarioestado.vo.Estado;

/**
 * Created by sanchezocth on 25/08/2016.
 */
public class EstadoArrayAdapter extends ArrayAdapter<Estado> {

    private final Context context;
    private final Estado[] objects;

    public EstadoArrayAdapter(Context context, Estado[] objects) {
        super(context, R.layout.activity_listview, objects);
        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_listview, parent, false);
        TextView txtId = (TextView) rowView.findViewById(R.id.lblId);
        TextView txtName = (TextView) rowView.findViewById(R.id.lblName);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.lblDescription);
        final StringBuilder sbId= new StringBuilder();
        sbId.append(objects[position].getId());
        txtId.setText(sbId.toString());

        Log.d("T1=","position="+position+",objects[position].getId()="+objects[position].getId());
        txtName.setText(objects[position].getName());
        txtDescription.setText(objects[position].getDescription());

        return rowView;
    }
}
