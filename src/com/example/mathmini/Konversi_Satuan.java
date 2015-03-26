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
public class Konversi_Satuan extends Activity {
Spinner spData,spData2;
TextView t3;
EditText etHasil,etNilai1;
Button btnHelp;
double der,gr,rad,Input;
public static final int TOT_PARTS = 6;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
SoundPool sp;
String[] data = {"Derajat","πRad","Grad"};
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.konversi_satuan_sudut);
	        btnHelp = (Button) findViewById(R.id.btnHelp);
	        
	        etNilai1 = (EditText) findViewById(R.id.etNilai1);
	        etHasil = (EditText) findViewById(R.id.etHasil);
	        spData = (Spinner) findViewById(R.id.spNilai1);
	        spData2 = (Spinner) findViewById(R.id.spNilai2);
	        t3 = (TextView) findViewById(R.id.textView3);
	        ArrayAdapter<String> menu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
	        menu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spData.setAdapter(menu);
	        spData2.setAdapter(menu);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.konversisatuan, 1);
 	    }
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	 	}
	    
	    public void btnHasildiklik(View v){
	    	
	    	if(spData.getSelectedItemPosition()==0 && spData2.getSelectedItemPosition()==0) {
	    		t3.setText("(derajat=derajat) = "+"("+etNilai1.getText().toString()+"="+etNilai1.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitDerkeDer(Double.parseDouble(etNilai1.getText().toString()))));
	    		}
	    		
	    	} else if(spData.getSelectedItemPosition()==0 && spData2.getSelectedItemPosition()==1) {
	    		t3.setText("(derajat*2)/360) = "+"("+etNilai1.getText().toString()+"*2/360)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitDerKeRad(nilai)));
	    		}
	    	}else if(spData.getSelectedItemPosition()==0 && spData2.getSelectedItemPosition()==2) {
	    		t3.setText("(derajat*400/360) = "+"("+etNilai1.getText().toString()+"*400/360)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitDerKeGrad(nilai)));
	    		}
	    	
	    	} else if(spData.getSelectedItemPosition()==1 && spData2.getSelectedItemPosition()==0) {
	    		t3.setText("(radian*360/2) = "+"("+etNilai1.getText().toString()+"*360/2)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitRadkeDer(nilai)));
	    		}
	    	
	    	} else if(spData.getSelectedItemPosition()==1 && spData2.getSelectedItemPosition()==1) {
	    		t3.setText("(radian=radian) = "+"("+etNilai1.getText().toString()+"="+etNilai1.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitRadkeRad(nilai)));
	    		}
	    	
	    	} else if(spData.getSelectedItemPosition()==1 && spData2.getSelectedItemPosition()==2) {
	    		t3.setText("(radian*400/2) = "+"("+etNilai1.getText().toString()+"*400/2)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitRadkeGrad(nilai)));
	    		}
	    	
	    	} else if(spData.getSelectedItemPosition()==2 && spData2.getSelectedItemPosition()==0) {
	    		t3.setText("(grad*360/400) = "+"("+etNilai1.getText().toString()+"*360/400)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitGradkeDer(nilai)));
	    		}
	    	
	    	} else if(spData.getSelectedItemPosition()==2 && spData2.getSelectedItemPosition()==1) {
	    		t3.setText("(grad*2/400) = "+"("+etNilai1.getText().toString()+"*2/400)");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitGradkeRad(nilai)));
	    		}
	    		
	    	} else if(spData.getSelectedItemPosition()==2 && spData2.getSelectedItemPosition()==2) {
	    		t3.setText("(grad=grad) = "+"("+etNilai1.getText().toString()+"="+etNilai1.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double nilai = Double.parseDouble(etNilai1.getText().toString());
	    		if(etNilai1.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitGradkeGrad(nilai)));
	    		}
	    	} 
	    }
	    
	    public double hitDerKeRad(double derajat) {
	    	double rad;
	    	rad = (double) (derajat*2)/360;
	    	return rad;
	    }
	    
	    public double hitDerKeGrad(double derajat) {
	    	double grad;
	    	grad = (double) (derajat*400)/360;
	    	return grad;
	    }
	    
	    public double hitDerkeDer(double derajat) {
	    	double der;
	    	der = (double) derajat;
	    	return der;
	    }
	    
	    public double hitRadkeDer(double radian) {
	    	double rad;
	    	rad = (double) (radian*360)/2;
	    	return rad;
	    }
	    
	    public double hitRadkeGrad(double radian) {
	    	double rad;
	    	rad = (double) (radian*400)/2;
	    	return rad;
	    }
	    
	    public double hitRadkeRad(double radian) {
	    	double rad;
	    	rad = (double) radian;
	    	return rad;
	    }
	    
	    public double hitGradkeDer(double grad) {
	    	double gr;
	    	gr = (double) (grad*360)/400;
	    	return gr;
	    }
	    
	    public void stopSuara (int index) {
	    	sp.stop(streamIds[index]);
	    }
	    
	    public double hitGradkeRad(double grad) {
	    	double gr;
	    	gr = (double) (grad*2)/400;
	    	return gr;
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
	    
	    public double hitGradkeGrad(double grad) {
	    	double gr;
	    	gr = (double) grad;
	    	return gr;
	    }
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(Konversi_Satuan.this, Math_Main.class);
	    	Konversi_Satuan.this.startActivity(intent);
	    	Konversi_Satuan.this.finish();
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(Konversi_Satuan.this, Math_Main.class);
	    	Konversi_Satuan.this.startActivity(intent);
	    	Konversi_Satuan.this.finish();
	    }
    
}
