package com.example.cikitsam;

import android.graphics.Bitmap;
import android.graphics.Color;

public class FaceMoodReader {
    // Enum to represent different mood categories
    public enum Mood {
        HAPPY, SAD, ANGRY, NEUTRAL
    }

    // Method to analyze facial image and determine mood
    public static Mood analyzeMood(Bitmap facialImage) {
        // Convert bitmap to array of pixels
        int width = facialImage.getWidth();
        int height = facialImage.getHeight();
        int[] pixels = new int[width * height];
        facialImage.getPixels(pixels, 0, width, 0, 0, width, height);

        // Variables to count color occurrences
        int totalPixels = width * height;
        int redCount = 0, greenCount = 0, blueCount = 0;

        // Iterate through pixels and calculate average color values
        for (int pixel : pixels) {
            redCount += Color.red(pixel);
            greenCount += Color.green(pixel);
            blueCount += Color.blue(pixel);
        }

        // Calculate average color values
        int avgRed = redCount / totalPixels;
        int avgGreen = greenCount / totalPixels;
        int avgBlue = blueCount / totalPixels;

        // Determine mood based on average color values
        if (avgRed > avgGreen && avgRed > avgBlue) {
            // Reddish tones dominate (e.g., angry)
            return Mood.ANGRY;
        } else if (avgGreen > avgRed && avgGreen > avgBlue) {
            // Greenish tones dominate (e.g., happy)
            return Mood.HAPPY;
        } else if (avgBlue > avgRed && avgBlue > avgGreen) {
            // Bluish tones dominate (e.g., sad)
            return Mood.SAD;
        } else {
            // No dominant color (e.g., neutral)
            return Mood.NEUTRAL;
        }
    }
}
