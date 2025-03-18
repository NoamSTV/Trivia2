package com.example.noamtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrucation extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucation); // ודא שזה מתאים

        btn = findViewById(R.id.back_button); // להפעיל קודם את ה-findViewById
        btn.setOnClickListener(this); // ואז להאזין לאירועים
    }

    @Override
    public void onClick(View v) {
        // חזרה למסך הראשי
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
