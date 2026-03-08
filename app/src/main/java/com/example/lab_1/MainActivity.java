package com.example.lab_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class MainActivity extends Activity {

    private static final String TAG = "LIFECYCLE";
    private static final int REQUEST_CODE = 1;
    private int currentColor = Color.GRAY;

    private Button colorBtn;
    private EditText switchCaseEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        colorBtn = findViewById(R.id.colorBtn);
        Button sendColorBtn = findViewById(R.id.sendColorBtn);
        switchCaseEdit = findViewById(R.id.switchCaseEdit);
        Button sendTextBtn = findViewById(R.id.sendTextBtn);
        Button openLinkBtn = findViewById(R.id.openLinkBtn);

        if (savedInstanceState != null) {
            currentColor = savedInstanceState.getInt("savedColor", Color.GRAY);
            String savedText = savedInstanceState.getString("savedText", "");

            colorBtn.setBackgroundColor(currentColor);
            switchCaseEdit.setText(savedText);

            Log.d(TAG, "Состояние восстановлено: " +
                    "цвет=" + currentColor + " текст=" + savedText);
        }


        colorBtn.setOnClickListener(v -> {
            Random random = new Random();
            currentColor = Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
            );
            colorBtn.setBackgroundColor(currentColor);

            Log.d(TAG, "Установлен цвет: " + currentColor);
        });


        sendColorBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ColoredActivity.class);
            intent.putExtra("color", currentColor);
            startActivityForResult(intent, REQUEST_CODE);

            Log.d(TAG, "Цвет отправлен");
        });


        sendTextBtn.setOnClickListener(v -> {
            String text = switchCaseEdit.getText().toString();
            Intent intent = new Intent(MainActivity.this, SwitchCaseActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);

            Log.d(TAG, "Текст отправлен");
        });


        openLinkBtn.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://oreluniver.ru");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);

            Log.d(TAG, "Ссылка отправлена");
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            Toast.makeText(this, "Ответ: " + result, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Получен ответ от ColoredActivity: " + result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("savedColor", currentColor);
        outState.putString("savedText", switchCaseEdit.getText().toString());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
