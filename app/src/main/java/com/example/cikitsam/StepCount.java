package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class StepCount extends AppCompatActivity implements SensorEventListener{


    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private TextView stepCountTextView;
    private int stepCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_count);

        stepCountTextView = findViewById(R.id.stepCountTextView);

        // Initialize the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Check if the device supports the accelerometer sensor
        if (sensorManager != null) {
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }
        @Override
        protected void onResume() {
            super.onResume();

            // Register the sensor listener
            if (accelerometerSensor != null) {
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        @Override
        protected void onPause() {
            super.onPause();

            // Unregister the sensor listener to save battery
            sensorManager.unregisterListener(this);
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event != null && event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                // Implement your step detection logic here
                // For a simple example, you can count steps whenever there is significant acceleration change
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                double acceleration = Math.sqrt(x * x + y * y + z * z);

                if (acceleration > 50) {  // Adjust this threshold as needed
                    stepCount++;
                }

                // Update the step count in the TextView
                stepCountTextView.setText("Step Count: " + stepCount);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Not needed for this example
        }
    }

