package com.example.lab_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SwitchCaseActivity extends Activity {

    private static final String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SwitchCaseActivity: onCreate");

        String text = getIntent().getStringExtra("text");
        if (text == null) {
            text = "";
        }
        Log.d(TAG, "SwitchCaseActivity: Получен текст=" + text);

        String upper = text.toUpperCase();
        Log.d(TAG, "SwitchCaseActivity: Текст в верхнем регистре=" + upper);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(android.view.Gravity.CENTER);

        layout.addView(createTextView("Было: " + text));
        layout.addView(createTextView("Стало: " + upper));

        Button btn = new Button(this);
        btn.setText("Назад");
        btn.setTextSize(18);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("result", "Ок");
            setResult(RESULT_OK, intent);
            finish();
        });

        layout.addView(btn);
        setContentView(layout);
    }

    private TextView createTextView(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(18);
        tv.setPadding(0, 20, 0, 20);
        return tv;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SwitchCaseActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SwitchCaseActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SwitchCaseActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SwitchCaseActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SwitchCaseActivity: onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SwitchCaseActivity: onRestart");
    }
}
