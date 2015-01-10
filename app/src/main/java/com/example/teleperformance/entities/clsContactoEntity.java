package com.example.teleperformance.entities;

import android.net.Uri;

/**
 * Created by 1017198087 on 09/01/2015.
 */
public class clsContactoEntity {

    private String strNombre, strTelefono, strEmail, strDireccion;
    private Uri imageUri;

    public clsContactoEntity(String strNombre, String strTelefono, String strEmail, String strDireccion, Uri imageUri) {
        this.strNombre = strNombre;
        this.strTelefono = strTelefono;
        this.strEmail = strEmail;
        this.strDireccion = strDireccion;
        this.imageUri = imageUri;
    }

    //<editor-fold desc="GET METHODS">
    public String getStrNombre() {
        return strNombre;
    }

    public String getStrTelefono() {
        return strTelefono;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public String getStrDireccion() {
        return strDireccion;
    }

    public Uri getImageUri() {
        return imageUri;
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
}