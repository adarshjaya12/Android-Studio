package com.adarshjayakumar.triangularorsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class Square {



    public boolean checkSquare(double number)
    {
        double variable1 = Math.sqrt(number);
        double variable2= (int) Math.sqrt(number);
        if( variable1 == variable2)
            return true;
        else
            return false;
    }

}

class Triangular {
    public boolean checkTriangular (int number)
    {
        int i=1;
        int triangularNumber=1;
        while(triangularNumber < number)
        {
            i++;
            triangularNumber = triangularNumber+i;

        }
        if(triangularNumber == number)
            return true;
        else
            return false;
    }
}

public class MainActivity extends AppCompatActivity {

    public boolean checkEmpty(EditText value)
    {
        if (value.getText().toString().trim().length() == 0)
            return true;
        else
            return false;
    }

    public void checkValue(View view)
    {
        EditText inputValue =(EditText) findViewById(R.id.valueText);
        if(checkEmpty(inputValue))
            Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();
        else {
            int inputConvertedValue = Integer.parseInt(inputValue.getText().toString());
            Triangular triangular = new Triangular();
            Square square = new Square();
            if ((triangular.checkTriangular(inputConvertedValue)) && square.checkSquare(inputConvertedValue))
                Toast.makeText(getApplicationContext(), "The number is a Triangualar and Square", Toast.LENGTH_LONG).show();
            else if ((triangular.checkTriangular(inputConvertedValue)))
                Toast.makeText(getApplicationContext(), "The number is a Triangualar but not Square", Toast.LENGTH_SHORT).show();
            else if (square.checkSquare(inputConvertedValue))
                Toast.makeText(getApplicationContext(), "The number is a Square but not Triangular", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "The number is  not  Triangualar or Square", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

