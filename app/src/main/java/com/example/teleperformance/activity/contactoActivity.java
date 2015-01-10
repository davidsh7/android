package com.example.teleperformance.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.teleperformance.R;
import com.example.teleperformance.rules.clsContacto;
import com.example.teleperformance.util.TextChangedListener;

/**
 * Created by 1017198087 on 08/01/2015.
 */
public class contactoActivity extends Activity {

    private EditText txtNombre, txtTelefono, txtEmail, txtDireccion;
    private Button btnAgregar;
    private ImageView imgContacto;
    private ListView ltsContacto;

    private int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);
        mInicializarComponentes();
        mInicializarTabs();
    }

    private void mInicializarTabs() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        tabHost.addTab(spec);
    }

    private void mInicializarComponentes(){
        txtNombre = (EditText) findViewById(R.id.cmpNombre);
        txtTelefono = (EditText) findViewById(R.id.cmpTelefono);
        txtEmail = (EditText) findViewById(R.id.cmpEmail);
        txtDireccion = (EditText) findViewById(R.id.cmpDireccion);
        imgContacto = (ImageView) findViewById(R.id.imgContacto);
        //Llamamos clase anonima
        txtNombre.addTextChangedListener(new TextChangedListener(){
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                //Verificar sequencia de caracteres
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });
    }

    public void onClick(View view) {

        if ((Uri) imgContacto.getTag() == null){
            Toast.makeText(this, "Imagen quedo nula", Toast.LENGTH_SHORT).show();
        }


        mAgregarContacto(
                txtNombre.getText().toString(),
                txtTelefono.getText().toString(),
                txtEmail.getText().toString(),
                txtDireccion.getText().toString(),
                (Uri) imgContacto.getTag()
        );
        String message = String.format("%s Ha sido agregado a la lista!", txtNombre.getText());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        btnAgregar.setEnabled(false);
        mLimpiarCampos();
    }

    private void mAgregarContacto(String strNombre, String strTelefono, String strEmail, String strDireccion, Uri imageUri) {
        clsContacto objContacto = new clsContacto(this);
        objContacto.setStrNombre(strNombre);
        objContacto.setStrTelefono(strTelefono);
        objContacto.setStrEmail(strEmail);
        objContacto.setStrDireccion(strDireccion);
        objContacto.setImageUri(imageUri);
        if (objContacto.fnCrearContacto()){
            ltsContacto = (ListView) findViewById(R.id.listView);
            ltsContacto.setAdapter(objContacto.getAdapter());
        }
    }

    private void mLimpiarCampos() {
        txtNombre.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        //Restablecer foto predeterminada
        imgContacto.setImageResource(R.drawable.ic_launcher);
        txtNombre.requestFocus();
    }

    public void onImgClick(View view) {
        Intent intent = null;
        //Verificamos la version de la plataforma
        if(Build.VERSION.SDK_INT < 19) {
            //Android JellyBean 4.3 y anteriores
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, request_code);
        }else{
            //Android KitKat 4.4 o superior
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent,request_code);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (resultCode == RESULT_OK && requestCode == request_code){
           imgContacto.setImageURI(data.getData());
           //Utilizamos el atributo TAG para almacenar la Uri
       }
    }
}
