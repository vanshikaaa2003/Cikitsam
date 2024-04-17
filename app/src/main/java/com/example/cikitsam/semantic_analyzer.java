package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
// MainActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class semantic_analyzer extends AppCompatActivity {

    Button ana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semantic_analyzer);
        ana = findViewById(R.id.buttonana);
        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                analyzeSentiment();
            }
        });

    }
    public void analyzeSentiment() {
        EditText inputEditText = findViewById(R.id.inputEditText);
        TextView sentimentTextView = findViewById(R.id.sentimentTextView);
        TextView emotionTextView = findViewById(R.id.emotionTextView);

        String userInput = inputEditText.getText().toString();

        // Perform sentiment analysis
        double sentimentScore = analyzeSentiment(userInput);

        // Recognize emotion
        String dominantEmotion = recognizeEmotion(userInput);

        // Update UI with results
        sentimentTextView.setText("Sentiment Score: " + sentimentScore);
        emotionTextView.setText("Dominant Emotion: " + dominantEmotion);
    }

    private double analyzeSentiment(String text) {
        // Placeholder method for sentiment analysis
        // Analyze sentiment based on the presence of positive and negative keywords
        int positiveCount = countKeywords(text, new String[]{"happy", "joy", "excited", "content"});
        int negativeCount = countKeywords(text, new String[]{"sad", "depressed", "unhappy", "gloomy"});
        // Calculate sentiment score based on keyword counts
        return (double) (positiveCount - negativeCount) / text.split("\\s+").length;
    }

    private String recognizeEmotion(String text) {
        // Placeholder method for emotional recognition
        // Determine emotion based on sentiment score
        double sentimentScore = analyzeSentiment(text);
        if (sentimentScore >= 0.2) {
            return "Positive";
        } else if (sentimentScore >= -0.2) {
            return "Neutral";
        } else {
            return "Negative";
        }
    }

    private int countKeywords(String text, String[] keywords) {
        int count = 0;
        for (String keyword : keywords) {
            if (text.toLowerCase().contains(keyword)) {
                count++;
            }
        }
        return count;
    }
}

