package com.hoonyeee.android.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout layout;
    Stage stage;
    Preview preview;
    GridLayout.LayoutParams params;
    float displayWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        displayWidth = metrics.widthPixels;
        layout = findViewById(R.id.layout);

        stage = new Stage(getBaseContext(), displayWidth);
        preview = new Preview(getBaseContext(), displayWidth);

        layout.addView(stage);
        layout.addView(preview);


    }
}
