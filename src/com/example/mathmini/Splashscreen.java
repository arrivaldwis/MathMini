package com.example.mathmini;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;

public class Splashscreen extends Activity {

	private static final long SPLASH_DISPLAY_LENGHT = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Hapus Title Bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
		setTitle("MathMini");
		setContentView(R.layout.splashscreen);
		
		new Handler().postDelayed(new Runnable() {
	    	public void run() {
                Intent mainIntent = new Intent(Splashscreen.this,Math_Main.class);
                Splashscreen.this.startActivity(mainIntent);
                Splashscreen.this.finish();	
	        }
		},SPLASH_DISPLAY_LENGHT);
	}
}
