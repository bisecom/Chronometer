package com.e.chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.Chronometer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Chronometer mChronometer;
    private Button pause, start, reset, laps;
    private String settings = "start/pause", colors = "gray";
    private StringBuilder lapsedTime;
    private long pauseTime = 0, elapsedTime, lastLaps = 0;
    private TextView lapsTV;
    private ThemesSettings mainLtTheme;
    private LinearLayout mainLayout;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLT);
        try {
            Bundle arguments = getIntent().getExtras();
            if (arguments != null) {
                settings = arguments.getString("settings");
                colors = arguments.getString("theme");
                mainLtTheme = new ThemesSettings();
                mainLtTheme.setMainTheme(colors, mainLayout);
            }
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        start = findViewById(R.id.startBtn);
        pause = findViewById(R.id.pauseBtn);
        pause.setVisibility(View.GONE);
        reset = findViewById(R.id.resetBtn);
        reset.setVisibility(View.GONE);
        laps = findViewById(R.id.lapsBtn);
        laps.setVisibility(View.GONE);

        lapsTV = findViewById(R.id.lapsTimeTV);
        lapsTV.setMovementMethod(new ScrollingMovementMethod());
        lapsedTime = new StringBuilder();
        mChronometer = findViewById(R.id.chronometer);
        mChronometer.setTypeface(ResourcesCompat.getFont(this, R.font.new_font));

        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                elapsedTime = SystemClock.elapsedRealtime()
                        - mChronometer.getBase();
                chronometer.setText(DateFormat.format("mm:ss", elapsedTime));
            }
        });
    }

    public void buttonClickHandler(View view) {
        switch (view.getId()) {
            case R.id.pauseBtn:
                if(settings.equals("start/pause")) {
                    start.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    pause.setVisibility(View.GONE);
                }else{
                    pause.setVisibility(View.GONE);
                    laps.setVisibility(View.GONE);
                    start.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                }
                    mChronometer.stop();
                    pauseTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
                break;
            case R.id.startBtn:
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
                start.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                if(!settings.equals("start/pause")) {
                    laps.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.GONE);
                }
                if(pauseTime == 0) {
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }else{
                    mChronometer.setBase(SystemClock.elapsedRealtime() - pauseTime);
                }
                mChronometer.start();
                break;
            case R.id.resetBtn:
                reset.setVisibility(View.GONE);
                pause.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.stop();
                pauseTime = 0; counter = 1;
                lapsTV.setText("");
                lapsedTime.setLength(0);
                break;
            case R.id.lapsBtn:
                long diffTime = elapsedTime - lastLaps;
                if(lapsTV.getText().toString().equals("") || lapsTV == null){
                    lapsTV.append(counter + ". " + DateFormat.format("mm:ss", elapsedTime).toString() + "\n");
                }else{
                    lapsTV.append(counter + ". "
                            + DateFormat.format("mm:ss", diffTime).toString()  + " ("
                            + DateFormat.format("mm:ss", elapsedTime).toString() + ")" + "\n");
                }
                lastLaps = elapsedTime;
                counter++;
                break;
            default:
                throw new RuntimeException("Unknown button ID");

        }
    }

    public void setupOptionsClick(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
