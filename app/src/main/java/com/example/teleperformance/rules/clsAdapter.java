package com.example.teleperformance.rules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleperformance.R;
import com.example.teleperformance.entities.clsNodeEntity;

import java.util.ArrayList;

//import android.widget.ArrayAdapter;

//public class clsAdapter extends ArrayAdapter<Object> {
public class clsAdapter extends BaseAdapter {

	private static ArrayList<clsNodeEntity> mArray = new ArrayList<clsNodeEntity>();
	
	//Array con los Datos que se mostraran en la lista
	/*private static clsNode[] datos = new clsNode[] {
			new clsNode("Informaci�n",	"Calcula los porcentages", R.drawable.informacionActivity),
			new clsNode("Contactenos","Subtitulo largo 2", R.drawable.contactenosActivity),
			new clsNode("Salir", "Subt�tulo largo 3", R.drawable.salir),
	};*/
	
	//Constructor de la clase clsAdapter
	private Context context;
	
	//Constructor
	public clsAdapter(Context context) {
		//super(context, android.R.layout.simple_list_item_1, datos);
		//super(context,R.layout.listitem,datos);
		this.context = context;
		setData();
	}
	
	private void setData(){
		mArray.clear();
		clsNodeEntity objNode0 = new clsNodeEntity();
		objNode0.setTitulo(context.getResources().getString(R.string.titulo0));
		objNode0.setSubtitulo(context.getResources().getString(R.string.subtitulo0));
		objNode0.setImagen(R.drawable.informacion);
		mArray.add(objNode0);
		
		clsNodeEntity objNode1 = new clsNodeEntity();
		objNode1.setTitulo(context.getResources().getString(R.string.titulo1));
		objNode1.setSubtitulo(context.getResources().getString(R.string.subtitulo1));
		objNode1.setImagen(R.drawable.contactenos);
		mArray.add(objNode1);
		
		clsNodeEntity objNode2 = new clsNodeEntity();
		objNode2.setTitulo(context.getResources().getString(R.string.titulo2));
		objNode2.setSubtitulo(context.getResources().getString(R.string.subtitulo2));
		objNode2.setImagen(R.drawable.salir);
		mArray.add(objNode2);
	}
	
	public int getCount() {
		return mArray.size(); 
	}
	
	public Object getItem(int position) {
		return mArray.get(position); 
	}
	
	public long getItemId(int position) {
		return 0;
	}
	
	//Metodo para asignar cada elemento del listitem a los datos
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = null;
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			item = inflater.inflate(R.layout.listitem, null);
		}else{
			item = convertView;
		}
		//LayoutInflater inflater = context.getLayoutInflater();
		//View item = inflater.inflate(R.layout.listitem, null);
		TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
		lblTitulo.setText(mArray.get(position).getTitulo());
		
		//lblTitulo.setText(datos[position].getTitulo());
		TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
		lblSubtitulo.setText(mArray.get(position).getSubtitulo());
		
		ImageView lblImagen = (ImageView) item.findViewById(R.id.LblImagen);
		lblImagen.setImageResource(mArray.get(position).getImagen());
		return (item);
	}

}
