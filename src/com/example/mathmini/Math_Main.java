package com.example.mathmini;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Math_Main extends Activity {
String basic[] = {"Mengenal Angka","Mengenal Bangun Datar","Calculator"};
String lanjut[] = {"Keliling dan Luas Bangun Datar","Trigonometri","Konversi Satuan Sudut"};
ListView lvBasic,lvLanjut;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_math__main);
		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
	    if (firstrun){
	    	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    	   alertDialog.setTitle("First Run");
	    	   alertDialog.setMessage("Selamat Datang di MathMini!\n\n" +
	    	   						  "MathMini adalah sebuah Apps untuk membantu pengguna dalam pengoperasian Matematika\n" +
	    	   						  "Mulai dari Dasar hingga Tingkat Lanjut.\n\n" +
	    	   						  "1. Tingkat Dasar\n" +
	    	   						  "Dapat digunakan sebagai saran edukasi kepada Anak\n\n" +
	    	   						  "2. Tingkat Lanjut\n" +
	    	   						  "Dapat digunakan untuk siswa SMP - SMA/K sesuai dengan fitur yang tersedia\n\n" +
	    	   						  "Terimakasih\n" +
	    	   						  "Regards - Arrival Dwi Sentosa");
	    	   alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int which) {
		    	   // here you can add functions
		    	   }
		    	   });
	    	   alertDialog.setIcon(R.drawable.ic_launcher);
	    	   alertDialog.show();
	    getSharedPreferences("PREFERENCE", MODE_PRIVATE)
	        .edit()
	        .putBoolean("firstrun", false)
	        .commit();
	    }
		lvBasic = (ListView) findViewById(R.id.lvBasic);
		lvLanjut = (ListView) findViewById(R.id.lvLanjut);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,basic);
	    lvBasic.setAdapter(adapter);
	    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lanjut);
	    lvLanjut.setAdapter(adapter2);
	    
	    lvBasic.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
		        Object o = lvBasic.getAdapter().getItem(arg2);
		        String pilihan = o.toString();
		        tampilkanPilihan(pilihan);
			}

	    });
	    
	    lvLanjut.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
		        Object o = lvLanjut.getAdapter().getItem(arg2);
		        String pilihan = o.toString();
		        tampilkanPilihan(pilihan);
			}

	    });
	}

	protected void tampilkanPilihan(String pilihan) {
        try {
            Intent i = null;
            if (pilihan.equals("Calculator")) {
                i = new Intent(this, CalcMain.class);
                Math_Main.this.finish();
            } else if (pilihan.equals("Keliling dan Luas Bangun Datar")) {
                i = new Intent(this, KeLuas.class);
                Math_Main.this.finish();
            } else if (pilihan.equals("Trigonometri")) {
                i = new Intent(this, trigonometri.class);
                Math_Main.this.finish();
            } else if (pilihan.equals("Konversi Satuan Sudut")) {
                i = new Intent(this, Konversi_Satuan.class);
                Math_Main.this.finish();
            } else if(pilihan.equals("Mengenal Angka")) {
            	i = new Intent(this, mengenalAngka.class);
            	Math_Main.this.finish();
            } else if(pilihan.equals("Mengenal Bangun Datar")) {
            	i = new Intent(this, mengenalBangunDatar.class);
            	Math_Main.this.finish();
            } else {
            
                Toast.makeText(this,"Anda Memilih: " + pilihan + " , " +
                        "Fitur belum dibuat", Toast.LENGTH_LONG).show();
            }
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void btnCalc(View v){
		Intent intent = new Intent(Math_Main.this, CalcMain.class);
		Math_Main.this.startActivity(intent);
		Math_Main.this.finish();
    }
	
	public void btnKeluas(View v){
		Intent intent = new Intent(Math_Main.this, KeLuas.class);
		Math_Main.this.startActivity(intent);
		Math_Main.this.finish();
    }
	
	public void btnTrigonometri(View v) {
		Intent intent = new Intent(Math_Main.this, trigonometri.class);
		Math_Main.this.startActivity(intent);
		Math_Main.this.finish();	
	}
	
	public void btnkss(View v) {
		Intent intent = new Intent(Math_Main.this, Konversi_Satuan.class);
		Math_Main.this.startActivity(intent);
		Math_Main.this.finish();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	   switch (item.getItemId()) {
	       case R.id.action_settings:
	    	   AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    	   alertDialog.setTitle("ABOUT");
	    	   alertDialog.setMessage("MathMini v.1\n\nArrival Dwi Sentosa\nORBIT COMMUNITY\n\nSend any Feedback or Bug to:\narrivaldwisentosa@gmail.com");
	    	   alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int which) {
		    	   // here you can add functions
		    	   }
		    	   });
	    	   alertDialog.setIcon(R.drawable.ic_launcher);
	    	   alertDialog.show();
	    	   break;
	       case R.id.sendEmail:
	    	   final Dialog dialog = new Dialog(this);

               dialog.setContentView(R.layout.dialog);
               dialog.setTitle("Send Feedback");

               final EditText editTextKeywordToBlock=(EditText)dialog.findViewById(R.id.editTextKeywordsToBlock);
               final EditText etJudul=(EditText)dialog.findViewById(R.id.etJudul);
               Button btnBlock=(Button)dialog.findViewById(R.id.buttonBlockByKeyword);
               Button btnCancel=(Button)dialog.findViewById(R.id.buttonCancelBlockKeyword);
               dialog.show();
               btnBlock.setOnClickListener(new View.OnClickListener() {
                   
                   @Override
                   public void onClick(View v) 
                   {
                	   String input =  editTextKeywordToBlock.getText().toString();
                	   String judul =  etJudul.getText().toString();
                	   Intent i = new Intent(Intent.ACTION_SEND);
                       i.setType("message/rfc822");
                       i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"arrivaldwisentosa@gmail.com"});
                       i.putExtra(Intent.EXTRA_SUBJECT, judul);
                       i.putExtra(Intent.EXTRA_TEXT   , input);
                       try {
                                 startActivity(Intent.createChooser(i, "Sending To.."));
                                
                         } 
                       finally {}
                   }
                   
           });
               
               btnCancel.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
               break;
	   }
	return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.math__main, menu);
		return true;
	}

}
