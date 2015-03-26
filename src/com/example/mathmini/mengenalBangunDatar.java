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
public class mengenalBangunDatar extends Activity {
TextView etHasil;
public static final int TOT_PARTS = 7;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
SoundPool sp;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mengenal_bangun_datar);
	        
	        etHasil = (TextView) findViewById(R.id.etHasil);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.persegipanjangs, 1);
	        soundIds[1] = sp.load(this, R.drawable.persegis, 1);
	        soundIds[2] = sp.load(this, R.drawable.segitigas, 1);
	        soundIds[3] = sp.load(this, R.drawable.jajargenjangs, 1);
	        soundIds[4] = sp.load(this, R.drawable.trapesiums, 1);
	        soundIds[5] = sp.load(this, R.drawable.lingkarans, 1);
	        soundIds[6] = sp.load(this, R.drawable.belahketupats, 1);
 	    }
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	 	}
	    
	    public void btnPersegi(View v) {
	    	etHasil.setText("Persegi");
	    	putarSuara(1);
	    }
	    
	    public void btnPersegiPanjang(View v) {
	    	etHasil.setText("Persegi Panjang");
	    	putarSuara(0);
	    }
	    
	    public void btnSegitiga(View v) {
	    	etHasil.setText("Segitiga");
	    	putarSuara(2);
	    }
	    
	    public void btnJajarGenjang(View v) {
	    	etHasil.setText("Jajar Genjang");
	    	putarSuara(3);
	    }
	    
	    public void btnTrapesium(View v) {
	    	etHasil.setText("Trapesium");
	    	putarSuara(4);
	    }
	    
	    public void btnBelahKetupat(View v) {
	    	etHasil.setText("Belah Ketupat");
	    	putarSuara(6);
	    }
	    
	    public void btnLingkaran(View v) {
	    	etHasil.setText("Lingkaran");
	    	putarSuara(5);
	    }
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(mengenalBangunDatar.this, Math_Main.class);
	    	mengenalBangunDatar.this.startActivity(intent);
	    	mengenalBangunDatar.this.finish();
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(mengenalBangunDatar.this, Math_Main.class);
	    	mengenalBangunDatar.this.startActivity(intent);
	    	mengenalBangunDatar.this.finish();
	    }
    
}
