package com.example.lab_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ColoredActivity extends Activity {

    private static final String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ColoredActivity: onCreate");

        int color = getIntent().getIntExtra("color", Color.GRAY);
        Log.d(TAG, "ColoredActivity: получен цвет = " + color);

        int invertColor = Color.rgb(
                255 - Color.red(color),
                255 - Color.green(color),
                255 - Color.blue(color)
        );
        Log.d(TAG, "ColoredActivity: инвертированный цвет = " + invertColor);


        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(color);
        layout.setGravity(android.view.Gravity.CENTER);

        Button btn = new Button(this);
        btn.setText("Назад");
        btn.setTextSize(18);
        btn.setBackgroundColor(invertColor);
        btn.setTextColor(color);


        btn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("result", "Ок");
            setResult(RESULT_OK, intent);
            finish();
        });

        layout.addView(btn);
        setContentView(layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ColoredActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ColoredActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ColoredActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ColoredActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ColoredActivity: onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ColoredActivity: onRestart");
    }
}
