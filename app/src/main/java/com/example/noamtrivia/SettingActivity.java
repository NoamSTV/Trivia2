package com.example.noamtrivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //implements – מגדיר שהמחלקה SettingActivity מיישמת (implements) ממשקים (interfaces).
    //View.OnClickListener – ממשק שמאפשר למחלקה להאזין ללחיצות על כפתורים או אלמנטים אחרים במסך.
    //AdapterView.OnItemSelectedListener – ממשק שמאפשר למחלקה להאזין לשינויים בפריטים שנבחרים בתוך Spinner (רשימה נפתחת) או רכיבים דומים.
    private Spinner spinner;
    private Button btnColorSetting;
    private String[] arrColor = { "Red", "Blue", "Pink", "Yellow"};
    private String chooseColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnColorSetting = findViewById(R.id.btnColorSetting);
        btnColorSetting.setOnClickListener(this);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrColor);
        //this – הקונטקסט (ה-Activity הנוכחי).
        //android.R.layout.simple_spinner_item – תבנית עיצוב מוכנה.
        //arrColor – המערך שממנו תילקח הרשימה.
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //השורה הזו קובעת איך ייראה הפריט בתוך הרשימה הנפתחת (dropdown) של ה-Spinner.
        spinner.setAdapter(aa); //מחברת את המידע (שהכנו מראש באמצעות ArrayAdapter aa) ל-Spinner, כך שה-Spinner יוכל להציג את המידע על המסך.


        //ל-Spinner אין נתונים משלו – צריך לספק לו רשימה של אפשרויות.
        //ArrayAdapter (aa) מחבר בין הרשימה של הצבעים (arrColor) לבין ה-Spinner.
        //setAdapter(...) אומר ל-Spinner:
        // "תשתמש במידע שב-aa כדי להציג את הפריטים שלך."
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.putExtra("color", chooseColor);
        setResult(RESULT_OK,i);
        finish();  // close the activity
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { //מתבצע כאשר השחקן בוחר פריט אחר מהספינר
        chooseColor = arrColor[position];
    }

    //AdapterView<?> parent:
    //זהו הרכיב (view) שמכיל את הפריט הנבחר. במקרה של Spinner, מדובר ב-Spinner עצמו.
    //
    //View view:
    //זהו הפריט שנבחר. במקרה של Spinner, זהו ה-View של הפריט הספציפי שנבחר על ידי המשתמש.
    //
    //int position:
    //זהו המיקום (אינדקס) של הפריט שנבחר בתוך הרכיב. לדוגמה, אם המשתמש בחר את הצבע "Blue", position יהיה 1 (אם הצבעים במערך arrColor הם לפי הסדר הזה: ["Red", "Blue", "Pink", "Yellow"]).
    //
    //long id:
    //זהו מזהה ייחודי של הפריט שנבחר. בדרך כלל לא משתמשים בו כל כך בתרחיש זה, אבל הוא יכול להיות שימושי במקרים אחרים, במיוחד כאשר מדובר ברשימות שהפריטים בהם הם אובייקטים ייחודיים.

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}