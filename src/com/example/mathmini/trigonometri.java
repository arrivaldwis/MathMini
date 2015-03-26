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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class trigonometri extends Activity {
Spinner spData;
TextView etHasil;
EditText etMasukan;
double sin,cos,tan,csc,csn,ctn;
public static final int TOT_PARTS = 6;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
SoundPool sp;
Button btnHelp;
String[] data = {"Sin","Cos","Tan"};
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.trigonometri);
	        btnHelp = (Button) findViewById(R.id.btnHelp);
	        etHasil = (TextView) findViewById(R.id.etHasil);
	        etMasukan = (EditText) findViewById(R.id.etNilai1);
	        spData = (Spinner) findViewById(R.id.spNilai1);
	        ArrayAdapter<String> menu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
	        menu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spData.setAdapter(menu);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.trigonometri, 1);
 	    }
	    
	    public void onItemSelected(AdapterView<?> parent, View v, 
	            int pos, long id) {
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }
        
	    public void btnHelp(View v) {
	    	String help = btnHelp.getText().toString();
	    	if(help=="Off") {
	    		btnHelp.setText("Help");
	    		stopSuara(0);
	    	} else {
	    		btnHelp.setText("Off");
	    		putarSuara(0);
	    	}
	    }
	    
	    public void btnHasildiklik(View v){
	    	if(etMasukan.getText().toString().isEmpty()) {
			     Toast.makeText(getApplicationContext(), 
                      "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    	}
	    	if(spData.getSelectedItemPosition()==0) {
	    		sin= Math.sin(Double.parseDouble(etMasukan.getText().toString()));
	    		etHasil.setText("Sin "+sin);
	    	} else if (spData.getSelectedItemPosition()==1) {
	    		cos= Math.cos(Double.parseDouble(etMasukan.getText().toString()));
	    		etHasil.setText("Cos "+cos);	
	    	} else if (spData.getSelectedItemPosition()==2) {
	    		tan= Math.tan(Double.parseDouble(etMasukan.getText().toString()));
	    		etHasil.setText("Tan "+tan);	
	    	}
	    }
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	 	}
	    
	    public void stopSuara (int index) {
	    	sp.stop(streamIds[index]);
	    }
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(trigonometri.this, Math_Main.class);
	    	trigonometri.this.startActivity(intent);
	    	trigonometri.this.finish();
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(trigonometri.this, Math_Main.class);
	    	trigonometri.this.startActivity(intent);
	    	trigonometri.this.finish();
	    }
    
}
