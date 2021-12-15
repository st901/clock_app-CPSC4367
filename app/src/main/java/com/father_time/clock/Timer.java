package com.father_time.clock;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Timer extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView timer_TextView;
    private Button timer_Start_Button;
    String StartLabel = "Start";
    String PauseLabel = "Pause";
    String ResetLabel = "Reset";

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_timer);


        timer_TextView = findViewById(R.id.timer);

        timer_Start_Button = findViewById(R.id.timerStart_button);

        timer_Start_Button.setOnClickListener(v -> {
            if (mTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        Button timer_Reset_Button = findViewById(R.id.timerReset_button);

        timer_Reset_Button.setOnClickListener(v -> resetTimer());
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                timer_Start_Button.setText(StartLabel);


            }
        }.start();

        mTimerRunning = true;
        timer_Start_Button.setText(PauseLabel);


    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        timer_Start_Button.setText(StartLabel);


    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timer_TextView.setText(timeLeftFormatted);
    }
}
