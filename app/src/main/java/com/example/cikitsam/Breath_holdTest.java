package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Breath_holdTest extends AppCompatActivity {

    private TextView countdownTextView;
    private TextView breathInTimerTextView;
    private TextView holdTimerTextView;
    private TextView breathOutTimerTextView;
    private Button startButton;
    private Button stopButton;

    private CountDownTimer countdownTimer;
    private CountDownTimer breathInTimer;
    private CountDownTimer holdTimer;
    private CountDownTimer breathOutTimer;

    private long countdownTime = 10000; // 10 seconds countdown
    private long breathInTime = 5000; // 5 seconds breath in time
    private long holdTime = 5000; // 5 seconds hold time
    private long breathOutTime = 5000; // 5 seconds breath out time

    private long breathInElapsedTime;
    private long holdElapsedTime;
    private long holdtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath_hold_test);
        countdownTextView = findViewById(R.id.countdownTextView);
        breathInTimerTextView = findViewById(R.id.breathInTimerTextView);
        holdTimerTextView = findViewById(R.id.holdTimerTextView);
        breathOutTimerTextView = findViewById(R.id.breathOutTimerTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBreathHoldingTest();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBreathHoldingTest();
            }
        });
    }
    private void startBreathHoldingTest() {
        countdownTimer = new CountDownTimer(countdownTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                countdownTextView.setText("Countdown: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                countdownTextView.setText("Countdown: 0");
                startBreathInTimer();
            }
        }.start();

        startButton.setVisibility(View.GONE);
        stopButton.setVisibility(View.VISIBLE);
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
                breathInTimerTextView.setText("Breath In Timer: 0");
                holdElapsedTime = 0; // Reset hold timer
                startHoldTimer();
            }
        }.start();
    }

    private void startHoldTimer() {
        breathInTimerTextView.setVisibility(View.GONE);
        holdTimerTextView.setVisibility(View.VISIBLE);
        holdTimer = new CountDownTimer(Long.MAX_VALUE, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                holdElapsedTime += 1000;
                long secondsElapsed = holdElapsedTime / 1000;
                holdTimerTextView.setText("Hold Timer: " + secondsElapsed);
            }

            @Override
            public void onFinish() {
                // This won't be called as the timer is infinite
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
                breathOutTimerTextView.setText("Breath Out Timer: 0");
                breathOutTimerTextView.setVisibility(View.GONE);

                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.GONE);
                // Test completed, you can record the timers here
                displayRecordedTimers(breathInElapsedTime, holdElapsedTime, breathOutTime);
            }
        }.start();
    }

    private void stopBreathHoldingTest() {

        startBreathOutTimer();
        if (countdownTimer != null) {
            countdownTimer.cancel();
        }

        if (breathInTimer != null) {
            breathInTimer.cancel();
        }

        if (holdTimer != null) {
            holdTimer.cancel();
        }

        holdtime = holdElapsedTime/1000;
        Toast.makeText(this, "HOLD TIME : " + holdtime, Toast.LENGTH_SHORT).show();

        // Record the breath-out timer
        long breathOutElapsedTime = holdElapsedTime + breathOutTime;

        // Reset visibility and text
        countdownTextView.setText("Countdown: 0");
        breathInTimerTextView.setText("Breath In Timer: 0");
        breathInTimerTextView.setVisibility(View.GONE);
        holdTimerTextView.setText("Hold Timer: 0");
        holdTimerTextView.setVisibility(View.GONE);
        breathOutTimerTextView.setText("Breath Out Timer: 0");




        // Display the recorded timers
        displayRecordedTimers(breathInElapsedTime, holdElapsedTime, breathOutElapsedTime);

    }

    private void displayRecordedTimers(long breathInTime, long holdTime, long breathOutTime) {
        // Display or process the recorded timers as needed
        // For now, let's print them to the log
        System.out.println("Breath In Timer: " + breathInTime + " milliseconds");
        System.out.println("Hold Timer: " + holdTime + " milliseconds");
        System.out.println("Breath Out Timer: " + breathOutTime + " milliseconds");
    }

}