package com.example.mathmini;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.app.AlertDialog;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class KeLuas extends Activity {
TextView t1,t2,t3,t4,t5;
EditText etSisi,etLebar,etHasil,etAlas,etSisiD;
RadioButton rdKel,rdLuas,rdPersegi,rdPP,rdLingkaran;
double konvert,hasil;
Spinner spMenu;
String str;
SoundPool sp;
Button btnHelp;
private final int interval = 1000; // 1 Second
private Handler handler = new Handler();
public static final int TOT_PARTS = 6;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
String[] data = {"Persegi","Persegi Panjang","Lingkaran","Segitiga","Jajar Genjang","Layang-Layang","Belah Ketupat","Trapesium"};
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.keliling_luas);
	        setTitle("MathMini");
	        btnHelp = (Button) findViewById(R.id.btnHelp);
	        t1 = (TextView) findViewById(R.id.textView1);
	        t2 = (TextView) findViewById(R.id.textView2);
	        t3 = (TextView) findViewById(R.id.textView3);
	        t4 = (TextView) findViewById(R.id.TextView01);
	        t5 = (TextView) findViewById(R.id.textView4);
	        etSisiD = (EditText) findViewById(R.id.etSisiD);
	        etSisi = (EditText) findViewById(R.id.etSisi);
	        etLebar = (EditText) findViewById(R.id.etLebar);
	        etHasil = (EditText) findViewById(R.id.etHasil);
	        etAlas = (EditText) findViewById(R.id.txtAlas);
	        rdKel = (RadioButton) findViewById(R.id.rdKel);
	        rdLuas = (RadioButton) findViewById(R.id.rdPP);
	        spMenu = (Spinner) findViewById(R.id.spNilai1);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.kelilingluas, 1);
	        
		     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
		     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		     spMenu.setAdapter(adapter);
		     
		     Handler handler = new Handler();
		     //schedule alarm here and post runnable as soon as scheduled
		     handler.post(r);
	        }
	    
	     //somewhere else in your Class
	      Runnable r = new Runnable() {
	             @Override
	             public void run() {
	            	if(spMenu.getSelectedItemPosition()==0) {
	        	    	t1.setText("Sisi");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.GONE);
	        	    	etLebar.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	            	} else if(spMenu.getSelectedItemPosition()==1) {
	            		t1.setText("Panjang");
	            		t2.setText("Lebar");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==2) {
	            		t1.setText("Jari-Jari");
	            		t4.setVisibility(View.GONE);
	            		etAlas.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.GONE);
	        	    	etLebar.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	            	} else if(spMenu.getSelectedItemPosition()==3 && rdKel.isChecked()) {
	            		t1.setText("sisiA");
	            		t2.setText("sisiB");
	            		t4.setText("sisiC");
	            		etAlas.setVisibility(View.VISIBLE);
	            		t4.setVisibility(View.VISIBLE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	            	} else if(spMenu.getSelectedItemPosition()==3 && rdLuas.isChecked()) {
	            		t1.setText("Alas");
	            		t2.setText("Tinggi");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==4 && rdKel.isChecked()) {
	            		t1.setText("sisiA");
	            		t2.setText("sisiB");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==4 && rdLuas.isChecked()) {
	            		t1.setText("Alas");
	            		t2.setText("Tinggi");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==5 && rdKel.isChecked()) {
	            		t1.setText("sisiA");
	            		t2.setText("sisiB");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==5 && rdLuas.isChecked()) {
	            		t1.setText("Diagonal 1");
	            		t2.setText("Diagonal 2");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==6 && rdKel.isChecked()) {
	            		t1.setText("Sisi");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.GONE);
	        	    	etLebar.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	            	} else if(spMenu.getSelectedItemPosition()==6 && rdLuas.isChecked()) {
	            		t1.setText("Diagonal 1");
	            		t2.setText("Diagonal 2");
	            		etAlas.setVisibility(View.GONE);
	            		t4.setVisibility(View.GONE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==7 && rdKel.isChecked()) {
	            		t1.setText("sisiA");
	            		t2.setText("sisiB");
	            		t4.setText("sisiC");
	            		t5.setText("sisiD");
	            		etAlas.setVisibility(View.VISIBLE);
	            		t4.setVisibility(View.VISIBLE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	        	    	t5.setVisibility(View.VISIBLE);
	        	    	etSisiD.setVisibility(View.VISIBLE);
	            	} else if(spMenu.getSelectedItemPosition()==7 && rdLuas.isChecked()) {
	            		t1.setText("sisiA");
	            		t2.setText("sisiB");
	            		t4.setText("Tinggi");
	            		etAlas.setVisibility(View.VISIBLE);
	            		t4.setVisibility(View.VISIBLE);
	        	    	t5.setVisibility(View.GONE);
	        	    	etSisiD.setVisibility(View.GONE);
	        	    	t2.setVisibility(View.VISIBLE);
	        	    	etLebar.setVisibility(View.VISIBLE);
	            	}
	                handler.postDelayed(this, 500);
	             }
	         };
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	 	}
	         
	    public void stopSuara (int index) {
	    	sp.stop(streamIds[index]);
	    }
	    
		public void btnHasildiklik(View v) {
	    	
	    	if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==0) {
	    		t3.setText("(4xSisi) = "+"("+etSisi.getText().toString()+"+"+etSisi.getText().toString()+
	    				"+"+etSisi.getText().toString()+"+"+etSisi.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelPersegi(Double.parseDouble(etSisi.getText().toString()))));
	    		}
	    		
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==1) {
	    		t3.setText("2*(Panjang+Lebar) = "+"2*("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double panjang = Double.parseDouble(etSisi.getText().toString());
	    		double lebar = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else if(etLebar.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelPersegiPanjang(panjang, lebar)));
	    		}
	    	}else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==2) {
	    		t3.setText("(2*π*r) = "+"(2*π*"+etSisi.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double jari = Double.parseDouble(etSisi.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelLingkaran(jari)));
	    		}
	    	
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==3) {
	    		t3.setText("(sisiA+sisiB+sisiC) = "+"("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+"+"+etAlas.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisiA = Double.parseDouble(etSisi.getText().toString());
	    		double sisiB = Double.parseDouble(etLebar.getText().toString());
	    		double sisiC = Double.parseDouble(etAlas.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelSegitiga(sisiA, sisiB, sisiC)));
	    		}
	    	
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==4) {
	    		t3.setText("2*(sisiA+sisiB) = "+"2*("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisiA = Double.parseDouble(etSisi.getText().toString());
	    		double sisiB = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelJajarGenjang(sisiA, sisiB)));
	    		}
	    	
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==5) {
	    		t3.setText("2*(sisiA+sisiB) = "+"2*("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisiA = Double.parseDouble(etSisi.getText().toString());
	    		double sisiB = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelLayangLayang(sisiA, sisiB)));
	    		}
	    	
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==6) {
	    		t3.setText("4*(sisi) = "+"4*("+etSisi.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisi = Double.parseDouble(etSisi.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelBelahKetupat(sisi)));
	    		}
	    	
	    	} else if(rdKel.isChecked() && spMenu.getSelectedItemPosition()==7) {
	    		t3.setText("(sisiA+sisiB+sisiC+sisiD) = "+"("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+"+"+etAlas.getText().toString()+"+"+etSisiD.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisiA = Double.parseDouble(etSisi.getText().toString());
	    		double sisiB = Double.parseDouble(etLebar.getText().toString());
	    		double sisiC = Double.parseDouble(etAlas.getText().toString());
	    		double sisiD = Double.parseDouble(etSisiD.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitKelTrapesium(sisiA, sisiB, sisiC, sisiD)));
	    		}
	    	
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==0) {
	    		t3.setText("(Sisi * Sisi) = "+"("+etSisi.getText().toString()+"*"+etSisi.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisi = Double.parseDouble(etSisi.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasPersegi(sisi)));
	    		}
	    		
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==1) {
	    		t3.setText("(Panjang * Lebar) = "+"("+etSisi.getText().toString()+"*"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double panjang = Double.parseDouble(etSisi.getText().toString());
	    		double lebar = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty() || etLebar.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                           "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasPersegiPanjang(panjang, lebar)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==2) {
	    		t3.setText("(π*r^2) = "+"(π*"+etSisi.getText().toString()+"^2)");
	    		t3.setVisibility(View.VISIBLE);
	    		double jari = Double.parseDouble(etSisi.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasLingkaran(jari)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==3) {
	    		t3.setText("1/2*(alas*tinggi) = "+"1/2*("+etSisi.getText().toString()+"*"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double alas = Double.parseDouble(etSisi.getText().toString());
	    		double tinggi = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasSegitiga(alas, tinggi)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==4) {
	    		t3.setText("(alas*tinggi) = "+"("+etSisi.getText().toString()+"*"+etLebar.getText().toString()+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double alas = Double.parseDouble(etSisi.getText().toString());
	    		double tinggi = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasJajarGenjang(alas, tinggi)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==5) {
	    		t3.setText("(d1*d2*1/2) = "+"("+etSisi.getText().toString()+"*"+etLebar.getText().toString()+"*1/2"+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double d1 = Double.parseDouble(etSisi.getText().toString());
	    		double d2 = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasLayangLayang(d1, d2)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==6) {
	    		t3.setText("(d1*d2*1/2) = "+"("+etSisi.getText().toString()+"*"+etLebar.getText().toString()+"*1/2"+")");
	    		t3.setVisibility(View.VISIBLE);
	    		double d1 = Double.parseDouble(etSisi.getText().toString());
	    		double d2 = Double.parseDouble(etLebar.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasBelahKetupat(d1, d2)));
	    		}
	    	} else if(rdLuas.isChecked() && spMenu.getSelectedItemPosition()==7) {
	    		t3.setText("(sisiA+sisiB)*Tinggi*1/2 = "+"("+etSisi.getText().toString()+"+"+etLebar.getText().toString()+")*"+etAlas.getText().toString()+"*1/2");
	    		t3.setVisibility(View.VISIBLE);
	    		double sisiA = Double.parseDouble(etSisi.getText().toString());
	    		double sisiB = Double.parseDouble(etLebar.getText().toString());
	    		double Tinggi = Double.parseDouble(etAlas.getText().toString());
	    		if(etSisi.getText().toString().isEmpty()) {
				     Toast.makeText(getApplicationContext(), 
                            "Lengkapi Data terlebih dahulu...", Toast.LENGTH_SHORT).show();
	    		} else {
	    		etHasil.setText(String.valueOf(hitLuasTrapesium(sisiA, sisiB, Tinggi)));
	    		}
	    	}
	    }
	    
		private double hitKelTrapesium(double sisiA,double sisiB,double sisiC,double sisiD)
	    {
	     double kel;
	     kel = (double) (sisiA+sisiB+sisiC+sisiD);
	     return kel;
	    }
		
		private double hitLuasTrapesium(double sisiA, double sisiB, double tinggi)
	    {
	     double l;
	     l = (double) (sisiA+sisiB)*tinggi*1/2;
	     return l;
	    }
		
	    private double hitKelPersegi(double sisi)
	    {
	     double kel;
	     kel = (double) (sisi+sisi+sisi+sisi);
	     return kel;
	    }
	    
	    private double hitKelBelahKetupat(double sisi)
	    {
	     double kel;
	     kel = (double) (sisi+sisi+sisi+sisi);
	     return kel;
	    }
	    
	    private double hitKelJajarGenjang(double sisiA, double sisiB)
	    {
	     double kel;
	     kel = (double) 2*(sisiA+sisiB);
	     return kel;
	    }
	    
	    private double hitKelLayangLayang(double sisiA, double sisiB)
	    {
	     double kel;
	     kel = (double) 2*(sisiA+sisiB);
	     return kel;
	    }
	    
	    private double hitKelSegitiga(double sisiA, double sisiB, double sisiC)
	    {
	     double kel;
	     kel = (double) (sisiA+sisiB+sisiC);
	     return kel;
	    }
	    
	    private double hitLuasSegitiga(double alas, double tinggi)
	    {
	     double kel;
	     kel = (double) 0.5*(alas*tinggi);
	     return kel;
	    }
	    
	    private double hitLuasBelahKetupat(double d1, double d2)
	    {
	     double kel;
	     kel = (double) (d1*d2*1/2);
	     return kel;
	    }
	    
	    private double hitKelLingkaran(double jari)
	    {
	     double kel;
	     kel = (double) (2*3.14*jari);
	     return kel;
	    }
	    
	    private double hitLuasPersegi(double sisi)
	    {
	     double l;
	     l = (double) (sisi*sisi);
	     return l;
	    }
	    
	    private double hitLuasLayangLayang(double d1, double d2)
	    {
	     double l;
	     l = (double) (d1*d2*1/2);
	     return l;
	    }
	    
	    private double hitLuasJajarGenjang(double alas, double tinggi)
	    {
	     double l;
	     l = (double) (alas*tinggi);
	     return l;
	    }
	    
	    private double hitLuasLingkaran(double jari)
	    {
	    	double l;
	     l = (double) (22/7*(jari*jari));
	     return l;
	    }
	    
	    private double hitKelPersegiPanjang(double panjang, double lebar)
	    {
	    	double kel;
	     kel = (double) 2*(panjang+lebar);
	     return kel;
	    }
	    
	    private double hitLuasPersegiPanjang(double panjang, double lebar)
	    {
	     double l;
	     l = (double) (panjang*lebar);
	     return l;
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
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(KeLuas.this, Math_Main.class);
	    	KeLuas.this.startActivity(intent);
	    	KeLuas.this.finish();
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(KeLuas.this, Math_Main.class);
	    	KeLuas.this.startActivity(intent);
	    	KeLuas.this.finish();
	    }
    
}
