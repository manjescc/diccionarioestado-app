package org.osanchezhuerta.android.diccionarioestado;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.osanchezhuerta.android.diccionarioestado.adapter.EstadoArrayAdapter;
import org.osanchezhuerta.android.diccionarioestado.fragment.EstadoDialogFragment;
import org.osanchezhuerta.android.diccionarioestado.service.DiccionarioEstadoServiceImpl;
import org.osanchezhuerta.android.diccionarioestado.vo.Estado;

import java.util.ArrayList;

public class DiccionarioEstadoMainActivity extends AppCompatActivity {
    //String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
    private static ArrayList<Estado> lstEstado = new ArrayList<Estado>();
    static{
        lstEstado.add(new Estado(2001,"A1","Movimiento A1"));
        lstEstado.add(new Estado(2002,"A2","Movimiento A2"));
        lstEstado.add(new Estado(2003,"A3","Movimiento A3"));
        lstEstado.add(new Estado(2004,"B1","Procesamiento B1"));
        lstEstado.add(new Estado(2005,"B2","Procesamiento B2"));
        lstEstado.add(new Estado(2006,"B3","Procesamiento B2"));
        lstEstado.add(new Estado(2007,"V1","Validacion V1"));
        lstEstado.add(new Estado(2008,"V2","Validacion V2"));
        lstEstado.add(new Estado(2009,"V3","Validacion V3"));

    }

    private DiccionarioEstadoServiceImpl diccionarioEstadoService;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario_estado_main);
        diccionarioEstadoService = new DiccionarioEstadoServiceImpl(this);
        for(Estado estado:lstEstado) {
            diccionarioEstadoService.guardarEstado(estado);
        }
        ArrayList<Estado> lstEstado =  diccionarioEstadoService.obtenerEstados();

        Log.d("lstEstado","cantidad="+lstEstado.size());
        //mobileArray[7]=lstEstado.size()+"-";

       // ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, mobileArray);
        fillEstados(lstEstado);
/*
        final Button btnAceptar = (Button) findViewById(R.id.btnBuscar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("test","test");
                TextView tvwEstadoBuscar=  (TextView)view.findViewById(R.id.txtIdEstadoBuscar);
                CharSequence idEstado = tvwEstadoBuscar.getText();
                final StringBuilder sb = new StringBuilder(idEstado.length());
                sb.append(idEstado);
                Log.d("onBuscarClick=",sb.toString());
                //  Intent i = new Intent(getBaseContext(), SecondScreen.class);
                //  startActivity(i);
            }
        });
        //adapter.notifyDataSetChanged();
*/
    }

    public void fillEstados(ArrayList<Estado> lstEstadoTemp){
        EstadoArrayAdapter adapter = new EstadoArrayAdapter(this,lstEstadoTemp.toArray(new Estado[lstEstadoTemp.size()]));
        ListView listView = (ListView) findViewById(R.id.lvwEstados);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                //TextView tvwName=  (TextView)view.findViewById(R.id.lblName);
                //Toast.makeText(getApplicationContext(),
                //        tvwName.getText(), Toast.LENGTH_SHORT).show();

                //SelectEstadoDialogFragment alertdFragment = new SelectEstadoDialogFragment();
                //alertdFragment.show(fragmentManager, "Alert Dialog Fragment");
                TextView tvwId=  (TextView)view.findViewById(R.id.lblId);
                TextView tvwNombre=  (TextView)view.findViewById(R.id.lblName);
                TextView tvwDescripcion=  (TextView)view.findViewById(R.id.lblDescription);
                Estado estadoSeleccionado = new Estado();

                estadoSeleccionado.setId(Integer.valueOf(new StringBuilder().append(tvwId.getText()).toString()));
                estadoSeleccionado.setName(new StringBuilder().append(tvwNombre.getText()).toString());
                estadoSeleccionado.setDescription(new StringBuilder().append(tvwDescripcion.getText()).toString());
                EstadoDialogFragment estadoDialogFragment = new EstadoDialogFragment();
                estadoDialogFragment.setEstadoSeleccionado(estadoSeleccionado);
                estadoDialogFragment.show(getFragmentManager(), "Alert Dialog Fragment");
            }
        });
        adapter.notifyDataSetChanged();
    }
    public void onClick(View view) {
       // ArrayAdapter<Estado> adapter = (ArrayAdapter<Estado>) getListAdapter();
        TextView tvwEstadoBuscar=  (TextView)findViewById(R.id.txtIdEstadoBuscar);
        CharSequence idEstado = tvwEstadoBuscar.getText();
        final StringBuilder sb = new StringBuilder(idEstado.length()).append(idEstado);
        Log.d("onBuscarClick=",sb.toString());

        ArrayList<Estado> lstEstado = new ArrayList<Estado>(0);
        if(!sb.toString().trim().isEmpty()) {
            int iidBuscar = Integer.valueOf(sb.toString());
            lstEstado = diccionarioEstadoService.obtenerEstados(iidBuscar);
        }else{
            lstEstado =  diccionarioEstadoService.obtenerEstados();
        }
        if (!lstEstado.isEmpty()) {
            Toast.makeText(getApplicationContext(), lstEstado.size()+" registros", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No se encontraron resultados", Toast.LENGTH_SHORT).show();
        }

        fillEstados(lstEstado);

    }
    @Override
    protected void onResume() {
        super.onResume();
        //diccionarioEstadoDAO.open();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public DiccionarioEstadoServiceImpl getDiccionarioEstadoService() {
        return diccionarioEstadoService;
    }

    public void setDiccionarioEstadoService(DiccionarioEstadoServiceImpl diccionarioEstadoService) {
        this.diccionarioEstadoService = diccionarioEstadoService;
    }
}
