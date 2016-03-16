package com.adarshjayakumar.buttonclick;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView myTextview;
    private Button myButton;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myTextview = (TextView) findViewById(R.id.textView);
        myButton = (Button) findViewById(R.id.button);
        View.OnClickListener ourOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+= 1;
                myTextview.setText("The button was tapped "+count);

            }
        };
        myButton.setOnClickListener(ourOnClickListner);
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
            Toast toastMessage = Toast.makeText(this,"The button was clicked "+myTextview.getText(),Toast.LENGTH_LONG);
            toastMessage.show();
            count = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
