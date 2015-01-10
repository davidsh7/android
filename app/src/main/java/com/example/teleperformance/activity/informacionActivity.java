package com.example.teleperformance.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleperformance.R;

public class informacionActivity extends Activity  {

	TextView informacion;
	ImageView foto;
	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.informacion);
	    
	    informacion = (TextView) findViewById(R.id.textView2);
	    foto = (ImageView) findViewById(R.id.imageView1);
	    
	    Bundle extras = this.getIntent().getExtras();
	    informacion.setText(extras.getString("informacionActivity"));
	    foto.setImageResource(extras.getInt("foto"));
	    //foto.setImageDrawable(getResources().getDrawable(extras.getInt("foto")));
	 }
	
	 public void volver(View view) {
		 finish();
	 }

}
