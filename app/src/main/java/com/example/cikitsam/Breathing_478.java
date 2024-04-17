package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Breathing_478 extends AppCompatActivity {
    long secondsleft;
    private TextView timerTextView;
    private TextView breathInTimerTextView;
    private TextView holdTimerTextView;
    private TextView breathOutTimerTextView;
    private CountDownTimer breathInTimer;
    private CountDownTimer holdTimer;
    private CountDownTimer breathOutTimer;
    private Button startButton;
    private CountDownTimer countDownTimer;
    private int breathPhase = 0; // 0: Inhale, 1: Hold, 2: Exhale
    private long[] phaseDurations = {4000, 7000, 8000};
    private TextView phase;
    int i=0;
    private long breathInTime = 4000; // 4 seconds breath in time
    private long holdTime = 7000; // 7 seconds hold time
    private long breathOutTime = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing478);

        breathInTimerTextView = findViewById(R.id.breathInTimer);
        holdTimerTextView = findViewById(R.id.holdTimer);
        breathOutTimerTextView = findViewById(R.id.breathOutTimer);
        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);

    }
    public void startBreathingExercise(View view) {
        startButton.setEnabled(false);

        countDownTimer = new CountDownTimer(77000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished / 1000);
                if(i==0)
                {
                    i=1;
                    startBreathInTimer();
                }

            }

            @Override
            public void onFinish() {
                updateTimerText(0);
                startButton.setEnabled(true);
            }
        };

        countDownTimer.start();
    }
    private void updateTimerText(long secondsRemaining) {
        long minutes = secondsRemaining / 60;
        long seconds = secondsRemaining % 60;
        secondsleft = secondsRemaining;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(timeString);


    }
    private void startBreathInTimer() {
        breathInTimerTextView.setVisibility(View.VISIBLE);
        breathInTimer = new CountDownTimer(breathInTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                breathInTimerTextView.setText("Breath In Timer: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                breathInTimerTextView.setVisibility(View.GONE);
                startHoldTimer();
            }
        }.start();
    }
    private void startHoldTimer() {
        holdTimerTextView.setVisibility(View.VISIBLE);
        holdTimer = new CountDownTimer(holdTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                holdTimerTextView.setText("hold Timer: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                holdTimerTextView.setVisibility(View.GONE);
                startBreathOutTimer();
            }
        }.start();
    }
    private void startBreathOutTimer() {
        breathOutTimerTextView.setVisibility(View.VISIBLE);
        breathOutTimer = new CountDownTimer(breathOutTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                breathOutTimerTextView.setText("Breath Out Timer: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                breathOutTimerTextView.setVisibility(View.GONE);
                if(i!=4)
                {
                    startBreathInTimer();
                    i++;
                }
                // Test completed, you can record the timers here
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}