package com.example.mathmini;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class mengenalAngka extends Activity {
TextView etHasil;
public static final int TOT_PARTS = 10;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
SoundPool sp;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mengenal_angka);
	        
	        etHasil = (TextView) findViewById(R.id.etHasil);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.no0, 1);
	        soundIds[1] = sp.load(this, R.drawable.no1, 1);
	        soundIds[2] = sp.load(this, R.drawable.no2, 1);
	        soundIds[3] = sp.load(this, R.drawable.no3, 1);
	        soundIds[4] = sp.load(this, R.drawable.no4, 1);
	        soundIds[5] = sp.load(this, R.drawable.no5, 1);
	        soundIds[6] = sp.load(this, R.drawable.no6, 1);
	        soundIds[7] = sp.load(this, R.drawable.no7, 1);
	        soundIds[8] = sp.load(this, R.drawable.no8, 1);
	        soundIds[9] = sp.load(this, R.drawable.no9, 1);
 	    }
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	 	}
	    
	    public void btnSatu(View v) {
	    	etHasil.setText("Satu");
	    	putarSuara(1);
	    }
	    
	    public void btnDua(View v) {
	    	etHasil.setText("Dua");
	    	putarSuara(2);
	    }
	    
	    public void btnTiga(View v) {
	    	etHasil.setText("Tiga");
	    	putarSuara(3);
	    }
	    
	    public void btnEmpat(View v) {
	    	etHasil.setText("Empat");
	    	putarSuara(4);
	    }
	    
	    public void btnLima(View v) {
	    	etHasil.setText("Lima");
	    	putarSuara(5);
	    }
	    
	    public void btnEnam(View v) {
	    	etHasil.setText("Enam");
	    	putarSuara(6);
	    }
	    
	    public void btnTujuh(View v) {
	    	etHasil.setText("Tujuh");
	    	putarSuara(7);
	    }
	    
	    public void btnDelapan(View v) {
	    	etHasil.setText("Delapan");
	    	putarSuara(8);
	    }
	    
	    public void btnSembilan(View v) {
	    	etHasil.setText("Sembilan");
	    	putarSuara(9);
	    }
	    
	    public void btnNol(View v) {
	    	etHasil.setText("Nol");
	    	putarSuara(0);
	    }
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(mengenalAngka.this, Math_Main.class);
	    	mengenalAngka.this.startActivity(intent);
	    	mengenalAngka.this.finish();
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(mengenalAngka.this, Math_Main.class);
	    	mengenalAngka.this.startActivity(intent);
	    	mengenalAngka.this.finish();
	    }
    
}
