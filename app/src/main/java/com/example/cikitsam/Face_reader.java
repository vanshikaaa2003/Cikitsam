package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class Face_reader extends AppCompatActivity implements SurfaceHolder.Callback, Camera.PictureCallback {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_reader);
        surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

        imageView = findViewById(R.id.imageView);

        Button captureButton = findViewById(R.id.captureButton);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
        } else {
            startCameraPreview();
        }
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCameraPreview();
            } else {
                Toast.makeText(this, "Camera permission is required to use the camera", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startCameraPreview() {
        try {
            camera = Camera.open();
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (IOException e) {
            Log.e("CameraActivity", "Error setting camera preview: " + e.getMessage());
        }
    }

    private void captureImage() {
        if (camera != null) {
            camera.takePicture(null, null, this);
        }
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        imageView.setImageBitmap(bitmap);

        // Analyze mood based on image
        FaceMoodReader.Mood mood = analyzeMood(bitmap);
        Toast.makeText(this, "Detected Mood: " + mood.name(), Toast.LENGTH_SHORT).show();

        camera.startPreview();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        // Not implemented in this example
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        releaseCamera();
    }

    private void releaseCamera() {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    private FaceMoodReader.Mood analyzeMood(Bitmap facialImage) {
        int width = facialImage.getWidth();
        int height = facialImage.getHeight();
        int[] pixels = new int[width * height];
        facialImage.getPixels(pixels, 0, width, 0, 0, width, height);

        // Perform color analysis or use a more advanced facial recognition algorithm
        // For simplicity, we'll just check if the average color is predominantly red, green, or blue
        int totalPixels = width * height;
        int redCount = 0, greenCount = 0, blueCount = 0;

        for (int pixel : pixels) {
            redCount += Color.red(pixel);
            greenCount += Color.green(pixel);
            blueCount += Color.blue(pixel);
        }

        int avgRed = redCount / totalPixels;
        int avgGreen = greenCount / totalPixels;
        int avgBlue = blueCount / totalPixels;

        if (avgRed > avgGreen && avgRed > avgBlue) {
            return FaceMoodReader.Mood.ANGRY;
        } else if (avgGreen > avgRed && avgGreen > avgBlue) {
            return FaceMoodReader.Mood.HAPPY;
        } else if (avgBlue > avgRed && avgBlue > avgGreen) {
            return FaceMoodReader.Mood.SAD;
        } else {
            return FaceMoodReader.Mood.NEUTRAL;
        }
    }
}
