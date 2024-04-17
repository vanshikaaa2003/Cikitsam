package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Mood_Tracker extends AppCompatActivity {
    CardView happy,sad,neutral;
    Button savemood;
    private static final String PREF_NAME = "MoodTrackerPrefs";
    private static final String KEY_MOOD = "currentMood";

    private ImageView moodImage;
    private int currentMood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);
        happy=findViewById(R.id.happy);
        neutral = findViewById(R.id.neutral);
        sad = findViewById(R.id.sad);
        moodImage = findViewById(R.id.moodImage);
        savemood = findViewById(R.id.savemood);

        happy.setOnClickListener(v -> setMood(R.drawable.happppy, 1));
        neutral.setOnClickListener(v -> setMood(R.drawable.neutrall, 2));
        sad.setOnClickListener(v -> setMood(R.drawable.saddd, 3));
        savemood.setOnClickListener(v -> saveMood());

        loadMood();
        updateUI();
    }
    private void setMood(int moodDrawable, int moodValue) {
        currentMood = moodValue;
        moodImage.setImageResource(moodDrawable);
    }

    private void saveMood() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_MOOD, currentMood);
        editor.apply();

        Toast.makeText(this, "Mood saved!", Toast.LENGTH_SHORT).show();
    }

    private void loadMood() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        currentMood = prefs.getInt(KEY_MOOD, 2); // Default mood is neutral
    }

    private void updateUI() {
        switch (currentMood) {
            case 1:
                moodImage.setImageResource(R.drawable.happppy);
                break;
            case 2:
                moodImage.setImageResource(R.drawable.neutrall);
                break;
            case 3:
                moodImage.setImageResource(R.drawable.saddd);
                break;
        }
    }
}
