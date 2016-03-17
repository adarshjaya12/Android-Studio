package com.adarshjayakumar.skytype;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText inputCity ;
    private Button checkWeather;
    private String fileContents;

    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView) findViewById(R.id.listView);
        inputCity = (EditText) findViewById(R.id.inputCity);
        checkWeather = (Button) findViewById(R.id.button);
        checkWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadData newData = new DownloadData();
                newData.execute("http://api.openweathermap.org/data/2.5/forecast/daily?q=DeKalb&mode=xml&units=metric&cnt=7&appid=b1b15e88fa797225412429c1c50c122a");
            }
        });


    }
    private class DownloadData extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... params) {
            fileContents = downloadXMLFile(params[0]);
            if(fileContents == null)
                Log.d("Download XML","No XML has been downloaded");
            return fileContents;

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("OnPost Execute",""+s);
        }
        private String downloadXMLFile(String urlPath)
        {
            StringBuilder resultValue = new StringBuilder();
            try {
                URL url = new URL(urlPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
                Log.d("Response :", "" + response);
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int charRead;
                char[] inputBuffer = new char[500];
                while (true) {
                    charRead = isr.read(inputBuffer);
                    if (charRead <= 0)
                        break;
                    resultValue.append(String.copyValueOf(inputBuffer, 0, charRead));


                }
                return resultValue.toString();
            }
            catch (IOException e)
            {
                Log.d("Download Data:",""+e);
                //e.printStackTrace();
            }
            catch (SecurityException e)
            {
                Log.d("Download Data:",""+e);
                //e.printStackTrace();
            }
            return null;
        }
    }

}
