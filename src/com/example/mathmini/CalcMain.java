package com.example.mathmini;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CalcMain extends Activity {
public String str ="";
Character op = 'q';
int i;
double num,numtemp;
Button btnHelp;
SoundPool sp;
public static final int TOT_PARTS = 6;
int[] soundIds = new int[TOT_PARTS];
int[] streamIds = new int[TOT_PARTS];
EditText tampilHasil;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_calc_main);
	        tampilHasil = (EditText)findViewById(R.id.editText2);
	        btnHelp = (Button) findViewById(R.id.btnHelp);
	        sp = new SoundPool(TOT_PARTS, AudioManager.STREAM_MUSIC, 0);
	        soundIds[0] = sp.load(this, R.drawable.calculator, 1);
	    }
	    
	    @Override
	    public void onBackPressed() {
	    	Intent intent = new Intent(CalcMain.this, Math_Main.class);
	    	CalcMain.this.startActivity(intent);
	    	CalcMain.this.finish();
	    } 
	    
	    public void putarSuara (int index) {
	    	streamIds[index] = sp.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
	    }
	    
	    public void stopSuara (int index) {
	    	sp.stop(streamIds[index]);
	    }
	    
	    public void btnBack(View v) {
	    	Intent intent = new Intent(CalcMain.this, Math_Main.class);
	    	CalcMain.this.startActivity(intent);
	    	CalcMain.this.finish();
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
	    
	      public void btn1(View v){
	    	  masukan("1");
	        
	      }
	       
	      public void btn2(View v){
			 masukan("2");
		        
	      }
	      public void btn3(View v){
	    	  masukan("3");
	        
	      }
	      public void btn4(View v){
	    	  masukan("4");
	        
	      }
	      public void btn5(View v){
	    	  masukan("5");
	        
	      }
	      public void btn6(View v){
	    	  masukan("6");
	      }
	      public void btn7(View v){
	    	  masukan("7");
	        
	      }
	      public void btn8(View v){
	    	  masukan("8");
	        
	      }
	      public void btn9(View v){
	    	  masukan("9");
	        
	      }
	      public void btn0(View v){
	    	  masukan("0");
		        
		  }
	      public void btnkoma(View v){
	    	  if(tampilHasil.getText().toString().contains(".")) {
	    		  Toast.makeText(getApplicationContext(), "Tidak bisa memasukkan tanda '.' lebih dari 1 kali", Toast.LENGTH_SHORT).show();
	    	  } else {
	    		  masukan(".");
	    	  }
		  }
	      public void btnPlus(View v){
	       perform();
	       op = '+';
	      }
	       
	      public void btnKurang(View v){
	    	 perform();
	         op = '-';
	      }
	      public void btnBagi(View v){
	       perform();
	       op = '/';
	      }
	      public void btnKali(View v){
		       perform();
		       op = '*';
	      }
	      public void btnHasildiklik(View v){
	    	 hitung();
	      }
	       
	      public void btnClear(View v){
	       reset();
	      }
	      private void reset() {
		  // TODO Auto-generated method stub
		   str ="";
		   op ='q';
		   num = 0;
		   numtemp = 0;
		   tampilHasil.setText("");
		 }
	      
		 private void masukan(String j) {
		    // TODO Auto-generated method stub
		       str = str+j;
		       if(j==".") {
		    	   tampilHasil.setText(str);
		       } else {
			       num = Double.valueOf(str).doubleValue();
			       tampilHasil.setText(str);
		       }
		   }
		 
	      private void perform() {
		    // TODO Auto-generated method stub
		    str = "";
		    numtemp = num;
		    tampilHasil.setText("");
		   }
	      
	      private void hitung() {
		    // TODO Auto-generated method stub
		    if(op == '+')
		     num = numtemp+num;
		    else if(op == '-')
		     num = numtemp-num;
		    else if(op == '/')
		     num = numtemp/num;
		    else if(op == '*')
		     num = numtemp*num;
		    tampilHasil.setText(""+num);
		   }
    
}
