package com.example.teleperformance;

//import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
//import android.app.Activity;
//import android.app.ListActivity;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

//public class MainActivity extends Activity {
//public class MainActivity extends ListActivity {
public class MainActivity extends ActionBarActivity implements OnClickListener,OnLongClickListener,OnTouchListener  {

	//private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        ListView list1 = (ListView) findViewById(R.id.listView1);
        clsAdapter objAdapter = new clsAdapter(this);
        list1.setAdapter(objAdapter);
        
        list1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Intent actividad = new Intent();
				switch (position) {
				case 0: // Opcion 1 
					actividad.setClass(getApplicationContext(), informacion.class);
					actividad.putExtra("informacion", getApplicationContext().getResources().getString(R.string.informacion));
					actividad.putExtra("foto", R.drawable.ic_teleperformance);
					startActivity(actividad);
					//Toast.makeText(getApplicationContext(),"Pantalla Informaci�n", Toast.LENGTH_LONG).show();
					break;
				case 1: // opcion 2
					//Toast.makeText(getApplicationContext(),"Pantalla Contactenos", Toast.LENGTH_LONG).show();
					actividad.setClass(getApplicationContext(), contactenos.class);
					startActivity(actividad);
					break;
				default:
					finish();
					break;
				}
			}
        });
        
        list1.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {

            	String[] opc = new String[] { "Editar", "Copiar", "Eliminar"};

                Log.v("long clicked","pos"+" "+pos);
                
                Toast.makeText(getApplicationContext(), "pos: " + pos, Toast.LENGTH_SHORT).show();
                
                AlertDialog opciones = new AlertDialog.Builder(
        			MainActivity.this)
        				.setTitle("Opciones")
        				.setItems(opc,
        						new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog, int selected) {
        								if (selected == 0) {
        									//fotoCamara();
        								} else if (selected == 1) {
        									//fotoGaleria();
        								}
        							}
        						}).create();

        		opciones.show();
                return true;
            }
        }); 
        
        //Mostrar un mensaje por pantalla con la libreria Toast
        Toast.makeText(MainActivity.this, "YISELA", Toast.LENGTH_LONG).show();
        
        Button btnEnviarRapido;
        btnEnviarRapido = (Button) findViewById(R.id.button1);
        
        Button btnEnviarLento;
        btnEnviarLento = (Button) findViewById(R.id.button2);
        
        //Agregar evento del boton
        btnEnviarRapido.setOnClickListener(this);
        btnEnviarLento.setOnLongClickListener(this);
        
    	TextView lblValoracion;
    	lblValoracion = (TextView) findViewById(R.id.textView3);
    	lblValoracion.setOnTouchListener(this);
    	
    }
    
    public void mLlenarLista(){
    	  String[] array = new String[]{
          		"Informaci�n",
          		"Contactenos",
          		"Salir"
          };
          ListAdapter objAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
          ListView list1 = (ListView) findViewById(R.id.listView1);
          list1.setAdapter(objAdapter);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	 //MenuInflater inflater = getMenuInflater();
    	 //inflater.inflate(R.menu.main_activity_actions, menu);
    	 //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	Intent actividad = new Intent();
    	switch(item.getItemId()){
    	case R.id.informacion:
    		//Toast.makeText(this,"Pantalla Informaci�n", Toast.LENGTH_SHORT).show();
    		actividad.setClass(this, informacion.class);
			actividad.putExtra("informacion", this.getResources().getString(R.string.informacion));
			actividad.putExtra("foto", R.drawable.ic_teleperformance);
    		startActivity(actividad);
    		return true;
    	case R.id.contactenos:
    		//Toast.makeText(this,"Pantalla Contactenos", Toast.LENGTH_SHORT).show();
    		actividad.setClass(this, contactenos.class);
    		startActivity(actividad);
    		return true;
    	case R.id.salir:
    		finish();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    @Override
    public void onClick(View v){
    	EditText txtEdad;
    	txtEdad = (EditText) findViewById(R.id.editText1);
    	String edad = txtEdad.getText().toString();
    	
    	TextView lblMensaje;
    	lblMensaje = (TextView) findViewById(R.id.textView2);
    	lblMensaje.setText(edad);
    	
    	Toast.makeText(getBaseContext(),"Boton Rapido", Toast.LENGTH_SHORT).show();
    	//getApplicationContext()
    }
    
    @Override
    public boolean onLongClick(View v){
    	Toast.makeText(getBaseContext(),"Boton Lento", Toast.LENGTH_SHORT).show();
    	return false;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent event){
    	switch(v.getId()){
    	case R.id.textView3:
    		Dialog d = new Dialog(this);
    		d.setTitle("Valarame");
    		d.setContentView(R.layout.mensaje);
    		d.show();
    		break;
    	}
    	return false;
    }
      
}
