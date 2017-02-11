package com.slidertesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SeekBar startTimeBar;
    SeekBar endTimeBar;

    ImageView minusStartTime;
    ImageView plusStartTime;
    ImageView minusEndTime;
    ImageView plusEndTime;

    TextView startTime;
    TextView endTime;
    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();
    public static SimpleDateFormat justTime = new SimpleDateFormat("h:mm aa");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimeBar = (SeekBar) findViewById(R.id.startSeek);
        endTimeBar = (SeekBar) findViewById(R.id.endSeek);

        endTime = (TextView) findViewById(R.id.endClock);
        startTime = (TextView) findViewById(R.id.startClock);

        minusEndTime = (ImageView) findViewById(R.id.minusEndTime);
        minusStartTime = (ImageView) findViewById(R.id.minusStartTime);

        plusEndTime = (ImageView) findViewById(R.id.plusEndTime);
        plusStartTime = (ImageView) findViewById(R.id.plusStartTime);

        startTimeBar.setMax(11);
        endTimeBar.setMax(11);

        startTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                startCalendar.set(Calendar.MINUTE, (11-progress)*5);
                startTime.setText(justTime.format(startCalendar.getTime()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        endTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                endCalendar.set(Calendar.MINUTE, progress*5);
                endTime.setText(justTime.format(endCalendar.getTime()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        minusStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startCalendar.add(Calendar.HOUR, -1);
                startTime.setText(justTime.format(startCalendar.getTime()));
            }
        });
        plusStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startCalendar.add(Calendar.HOUR, 1);
                startTime.setText(justTime.format(startCalendar.getTime()));
            }
        });

        minusEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                endCalendar.add(Calendar.HOUR, -1);
                endTime.setText(justTime.format(endCalendar.getTime()));
            }
        });

        plusEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endCalendar.add(Calendar.HOUR, 1);
                endTime.setText(justTime.format(endCalendar.getTime()));
            }
        });
    }
}
