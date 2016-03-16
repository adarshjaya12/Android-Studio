package com.adarshjayakumar.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    EditText operanda1;
    EditText operanda2;
    Button add;
    Button subtract;
    Button multiply;
    Button division;
    double variable1;
    double variable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        resultText = (TextView) findViewById(R.id.textView2);
        resultText.setVisibility(View.GONE);
        operanda1 = (EditText) findViewById(R.id.editText);
        operanda2 = (EditText) findViewById(R.id.editText2);
        add = (Button) findViewById(R.id.button);
        subtract = (Button) findViewById(R.id.button2);
        multiply = (Button) findViewById(R.id.button3);
        division = (Button) findViewById(R.id.button4);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable1 = Integer.parseInt(operanda1.getText().toString());
                variable2 = Integer.parseInt(operanda2.getText().toString());
                double sum = variable1 + variable2;
                resultText.setText(""+sum);
                resultText.setVisibility(View.VISIBLE);

            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable1 = Integer.parseInt(operanda1.getText().toString());
                variable2 = Integer.parseInt(operanda2.getText().toString());
                double subtract = variable1 - variable2;
                resultText.setText(""+subtract);
                resultText.setVisibility(View.VISIBLE);

            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable1 = Integer.parseInt(operanda1.getText().toString());
                variable2 = Integer.parseInt(operanda2.getText().toString());
                double multiply = variable1 * variable2;
                resultText.setText(""+multiply);
                resultText.setVisibility(View.VISIBLE);

            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable1 = Double.parseDouble(operanda1.getText().toString());
                variable2 = Integer.parseInt(operanda2.getText().toString());
                double division = variable1 / variable2;

                resultText.setText(""+division);
                resultText.setVisibility(View.VISIBLE);

            }
        });
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
