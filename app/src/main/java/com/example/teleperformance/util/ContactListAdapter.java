package com.example.teleperformance.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleperformance.R;
import com.example.teleperformance.entities.clsContactoEntity;

import java.util.List;

/**
 * Created by 1017198087 on 09/01/2015.
 */
public class ContactListAdapter extends ArrayAdapter<clsContactoEntity> {

    private Context context;

    public ContactListAdapter(Context context, List<clsContactoEntity> contactos) {
        super(context, R.layout.listitem, contactos);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listitem, null);
        }else{
            view = convertView;
        }
        clsContactoEntity actual = this.getItem(position);
        mInicializarComponentes(view, actual);
        return view;
    }

    private void mInicializarComponentes(View view, clsContactoEntity actual) {
        TextView lblTitulo = (TextView) view.findViewById(R.id.LblTitulo);
        lblTitulo.setText(actual.getStrNombre());
        ImageView imgContacto = (ImageView) view.findViewById(R.id.lvContactImage);
        imgContacto.setImageURI(actual.getImageUri());
    }
}
