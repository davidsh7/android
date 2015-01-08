package com.example.teleperformance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class informacion extends Activity  {

	TextView informacion;
	ImageView foto;
	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.informacion);
	    
	    informacion = (TextView) findViewById(R.id.textView2);
	    foto = (ImageView) findViewById(R.id.imageView1);
	    
	    Bundle extras = this.getIntent().getExtras();
	    informacion.setText(extras.getString("informacion"));
	    foto.setImageResource(extras.getInt("foto"));
	    //foto.setImageDrawable(getResources().getDrawable(extras.getInt("foto")));
	 }
	
	 public void volver(View view) {
		 finish();
	 }

}
