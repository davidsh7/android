package com.example.teleperformance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import util.TextChangedListener;

/**
 * Created by 1017198087 on 08/01/2015.
 */
public class contacto extends Activity {

    private EditText txtNombre, txtTelefono, txtEmail, txtDireccion;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);
        mInicializarComponentes();
    }

    private void mInicializarComponentes(){
        txtNombre = (EditText) findViewById(R.id.cmpNombre);
        txtTelefono = (EditText) findViewById(R.id.cmpTelefono);
        txtEmail = (EditText) findViewById(R.id.cmpEmail);
        txtDireccion = (EditText) findViewById(R.id.cmpDireccion);
        //Llamamos clase anonima
        txtNombre.addTextChangedListener(new TextChangedListener(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                //Verificar sequencia de caracteres
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });
    }

    //No hacer uso demasiado del operador de concatenacion
    public void onClick(View view) {
        String message = String.format("%s Ha sido agregado a la lista!", txtNombre.getText());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        btnAgregar.setEnabled(false);
        mLimpiarCampos();
    }

    private void mLimpiarCampos() {
        txtNombre.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        txtNombre.requestFocus();
    }
}
