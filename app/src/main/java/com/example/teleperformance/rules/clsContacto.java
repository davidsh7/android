package com.example.teleperformance.rules;

import android.content.Context;
import android.net.Uri;
import android.widget.ArrayAdapter;

import com.example.teleperformance.entities.clsContactoEntity;
import com.example.teleperformance.util.ContactListAdapter;

import java.util.ArrayList;

/**
 * Created by 1017198087 on 09/01/2015.
 */
public class clsContacto {

    private String strNombre, strTelefono, strEmail, strDireccion;
    private Uri imageUri;
    private static ArrayList<clsContactoEntity> arrayContactos = new ArrayList<clsContactoEntity>();
    private ArrayAdapter<clsContactoEntity> adapter;

    private Context context;

    public clsContacto() {
        this.strNombre = "";
        this.strTelefono = "";
        this.strEmail = "";
        this.strDireccion = "";
    }

    //<editor-fold desc="GET METHOD">
    public ArrayAdapter<clsContactoEntity> getAdapter() {
        return adapter;
    }
    //</editor-fold>

    //<editor-fold desc="SET METHODS">
    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    //</editor-fold>

    public clsContacto(Context context) {
        this.context = context;
    }

    public boolean fnCrearContacto() {
        arrayContactos.add(new clsContactoEntity(strNombre,strTelefono,strEmail,strDireccion,imageUri));
        adapter = new ContactListAdapter(context, arrayContactos);
        return true;
    }

    public Context getContext() {
        return context;
    }

}
