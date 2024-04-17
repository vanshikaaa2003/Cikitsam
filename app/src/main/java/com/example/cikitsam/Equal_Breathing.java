package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Equal_Breathing extends AppCompatActivity {

    private TextView timerTextView;
    private TextView breathInTimerTextView;
    private CountDownTimer breathInTimer;
    private CountDownTimer holdTimer;
    private CountDownTimer breathOutTimer;
    private TextView breathOutTimerTextView;
    private Button startButton;
    private CountDownTimer countDownTimer;
    int i=0;
    private long breathInTime = 4000; // 4 seconds breath in time
    private long breathOutTime = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equal_breathing);

        breathInTimerTextView = findViewById(R.id.breathInT);
        breathOutTimerTextView = findViewById(R.id.breathOutT);
        timerTextView = findViewById(R.id.timertv);
        startButton = findViewById(R.id.startB);
    }

    public void startBreathingExercise(View view) {
     startButton.setEnabled(false);

    countDownTimer = new CountDownTimer(60000, 1000) {

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
                if(i!=7)
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
