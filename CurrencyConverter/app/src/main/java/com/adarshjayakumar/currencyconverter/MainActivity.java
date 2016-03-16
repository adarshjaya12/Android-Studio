package com.adarshjayakumar.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view)
    {
        EditText myvariable = (EditText)(findViewById(R.id.dollarText));
        Double myVariable1 =Double.parseDouble(myvariable.getText().toString());
        myVariable1 *= 63.13;
        Toast.makeText(getApplicationContext(),"INR amout : "+myVariable1,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
