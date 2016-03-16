package com.adarshjayakumar.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomValue;
    public void startGenerate()
    {
        Random randomGenerator = new Random();
        randomValue = randomGenerator.nextInt(21);
    }
    public void textFieldEmpty(EditText value)
    {
       // value.getText().toString()="";
    }
    public void checkNumber(View view)
    {
        EditText valueText = (EditText) findViewById(R.id.valueText);
       // String insertedValue = valueText.getText().toString();

        if(checkEmpty(valueText))
        {
            Log.i("Error:","Its empty");
           Toast.makeText(this, "Please Enter a Number", Toast.LENGTH_SHORT).show();
        }
        else
        {

            Integer enteredValue = Integer.parseInt(valueText.getText().toString());
            Log.i("Value ",enteredValue.toString());
            if(enteredValue >= 0 && enteredValue <=20)
            {
                Log.i("All","All");
                if(randomValue == enteredValue)
                {
                    Toast.makeText(getApplicationContext(),"Congratulation , Your Right !!",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Lets Play again",Toast.LENGTH_SHORT).show();
                    startGenerate();
                }
                else if(randomValue > enteredValue)
                {
                    Toast.makeText(getApplicationContext(),"Oops , Your Too Low !!",Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(getApplicationContext(),"Oops , Your too High !!",Toast.LENGTH_SHORT).show();
                }
            }
            else
                Toast.makeText(this,"Enter between 0 and 20",Toast.LENGTH_SHORT).show();

        }

    }
    private boolean checkEmpty(EditText value)
    {
        int textLength =value.getText().toString().trim().length();
        if( textLength == 0 )
             return true;
        else
            return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGenerate();

    }
}
