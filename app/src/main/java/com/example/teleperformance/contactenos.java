package com.example.teleperformance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class contactenos extends Activity  {
	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.contactenos);
	 }
	
	 public void irtwiter(View view) {
		 goToUrl("http://www.twitter.com");
	 }
	 
	 public void irfacebook(View view) {
		 goToUrl("http://www.facebook.com");
	 }
	 
	 public void volver(View view) {
		 finish();
	 }
	 
	 private void goToUrl(String uriString) {
		 Uri uriUrl = Uri.parse(uriString);
		 Intent launBrowser = new Intent(Intent.ACTION_VIEW,uriUrl);
		 startActivity(launBrowser);
	 }

}
