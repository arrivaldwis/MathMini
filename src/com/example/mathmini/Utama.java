package com.example.mathmini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class Utama extends ListActivity {
	@Override
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        String[] menu = { "Calculator", "Keliling dan Luas", "Trigonometri","Konversi Satuan Sudut" };
	        this.setListAdapter(new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, menu));
	    }

	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        // Get the item that was clicked
	        Object o = this.getListAdapter().getItem(position);
	        String pilihan = o.toString();
	        tampilkanPilihan(pilihan);
	    }
	    protected void tampilkanPilihan(String pilihan) {
	        try {
	            Intent i = null;
	            if (pilihan.equals("Calculator")) {
	                i = new Intent(this, CalcMain.class);
	            } else if (pilihan.equals("Keliling dan Luas")) {
	                i = new Intent(this, KeLuas.class);
	            } else if (pilihan.equals("Trigonometri")) {
	                i = new Intent(this, trigonometri.class);
	            } else if (pilihan.equals("Konversi Satuan Sudut")) {
	                i = new Intent(this, Konversi_Satuan.class);
	            } else {
	            
	                Toast.makeText(this,"Anda Memilih: " + pilihan + " , " +
	                        "Actionnya belum dibuat", Toast.LENGTH_LONG).show();
	            }
	            startActivity(i);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		   switch (item.getItemId()) {
		       case R.id.action_settings:
		    	   AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		    	   alertDialog.setTitle("ABOUT");
		    	   alertDialog.setMessage("MathMini v.1\n\nDeveloper:\nArrival Dwi Sentosa\nEmail:\narrivaldwisentosa@gmail.com\n\nSMKN 4 BANDUNG\nORBIT COMMUNITY");
		    	   alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			    	   public void onClick(DialogInterface dialog, int which) {
			    	   // here you can add functions
			    	   }
			    	   });
		    	   alertDialog.setIcon(R.drawable.ic_launcher);
		    	   alertDialog.show();
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
