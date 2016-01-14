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

public class SquareActivity extends Activity {

    EditText SquareInput; // Holds input value for circle radius
    // The Textviews to hold the results
    TextView textViewSquareAreaResult, textViewSquarePerimResult;
    // Output result format
    DecimalFormat df = new DecimalFormat("#.000");
    // Buttons
    Button buttonSquareCalc, buttonSquareClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        // **** This was missing *** //
        textViewSquareAreaResult = (TextView) findViewById(R.id.textViewSquareAreaResult);
        textViewSquarePerimResult = (TextView) findViewById(R.id.textViewSquarePerimeterResult);
        // *** End of - This was missing *** //

        SquareInput = (EditText) findViewById(R.id.editTextSquareInput);
        buttonSquareCalc = (Button) findViewById(R.id.buttonSquareCalculate);
        buttonSquareCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                double sArea = 0;
                double sPerim = 0;
                double sIn = Double.parseDouble(SquareInput.getText()
                        .toString());
                if (sIn > 0) {
                    sArea = (sIn * sIn);
                    sPerim = 4 * sIn;

                    textViewSquareAreaResult.setText(String.valueOf(df
                            .format(sArea)));
                    textViewSquarePerimResult.setText(String.valueOf(df
                            .format(sPerim)));
                }

            }
        });

        buttonSquareClear = (Button) findViewById(R.id.buttonSquareClear);
        buttonSquareClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                textViewSquareAreaResult.setText("0.00");
                textViewSquarePerimResult.setText("0.00");
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
