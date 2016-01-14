package com.example.csci522exam1;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText CircleInput; //Holds input value for circle radius
	// The Textviews to hold the results
	TextView textViewCircleAreaResult, textViewCircleCircumResult;
	
	//Output result format
	DecimalFormat df = new DecimalFormat("#.000");
	//Buttons
	Button buttonCircleCalc, buttonCircleClear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// **** This was missing *** //
		textViewCircleAreaResult = (TextView)findViewById(R.id.textViewCircleAreaResult);
	    textViewCircleCircumResult = (TextView)findViewById(R.id.textViewCircleCircumResult);;
	    // *** End of - This was missing *** //
	    
	    CircleInput = (EditText)findViewById(R.id.editTextCircleInput);
		buttonCircleCalc = (Button)findViewById(R.id.buttonCircleCalc);
		buttonCircleCalc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double cArea = 0;
				double cCircum = 0;
				double rIn = Double.parseDouble(CircleInput.getText().toString());
				if(rIn > 0){
					cArea = 3.14 * (rIn * rIn);
					cCircum = 3.14 * 2 * rIn;
					
					textViewCircleAreaResult.setText(String.valueOf(df.format(cArea)));
					textViewCircleCircumResult.setText(String.valueOf(df.format(cCircum)));
				}
				
			}
		});
		
		buttonCircleClear = (Button)findViewById(R.id.buttonCirlceClear);
		buttonCircleClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textViewCircleAreaResult.setText("0.00");
				textViewCircleCircumResult.setText("0.00");
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// **** This was missing *** //
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    
	    Intent intentSquareActivity = new Intent(this,SquareActivity.class);
	    Intent intentCircleActivity  = new Intent(this,MainActivity.class);
	    
	    switch (item.getItemId()) {
	        case R.id.menuSquareCalc: 
                startActivity(intentSquareActivity);
	            return true;
	        case R.id.menuCircleCalc:
                startActivity(intentCircleActivity);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	// **** End of - This was missing *** //
	
}
