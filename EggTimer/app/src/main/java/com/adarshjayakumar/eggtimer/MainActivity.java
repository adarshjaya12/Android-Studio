package com.adarshjayakumar.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Boolean counterActive = false;
    Button button;
    CountDownTimer countDownTimer;


   public void updateTimer(int secondsLeft)
    {
        int minutes =  secondsLeft/60;
        int seconds = secondsLeft - minutes*60;
        String secondString = Integer.toString(seconds);
        if(secondString.length() <2)
            secondString = "0"+ secondString;

        textView.setText(Integer.toString(minutes) + ":" + secondString);


    }
    public void reset()
    {
        textView.setText("0:00");
        seekBar.setEnabled(true);
        seekBar.setProgress(0);
        countDownTimer.cancel();
        button.setText("Go");
        counterActive = false;
    }

    public void controlTimer ( View view)
    {
        if(!counterActive)
        {
        counterActive = true;
        seekBar.setEnabled(false);
        button.setText("Stop");
        countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 +100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("0:00");
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);
                mediaPlayer.start();
                reset();
            }
            }.start();
        }
        else
        {
            reset();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.timerBar);
        textView = (TextView) findViewById(R.id.timerValue);
        button = (Button) findViewById(R.id.controllerButton);
        seekBar.setMax(600);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
                      }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
