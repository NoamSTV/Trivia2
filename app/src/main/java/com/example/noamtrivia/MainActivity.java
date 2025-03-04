package com.example.noamtrivia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity { //השורה שלך מגדירה מחלקה שמייצגת מסך באפליקציה, עם תמיכה בתכונות מתקדמות של Android.
    private ActivityResultLauncher<Intent> resultLauncher; //משתנה שמאפשר לפתוח אקטיבי ולחכות לתוצאה
    private FbModule fbModule; //יציאת משתנה מסוג אובייקט
    private ConstraintLayout ll;

//המחלקה FbModule אחראית לתקשורת עם Firebase. היא קוראת נתונים מה-Firebase (כמו צבע הרקע) ומעדכנת את המידע ב-Firebase (כמו שינוי צבע הרקע).

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.main);

        fbModule = new FbModule(this); //מצביעה על כך שהמחלקה FbModule כנראה מצפה לקבל אובייקט מסוג Context בתור פרמטר.



        resultLauncher = registerForActivityResult( //מגדירים מאזין שיחכה לתוצאה ממסך אחר
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() { //מאפשר להפעיל מסך אחר (Activity) ולקבל ממנו תשובה בחזרה.

                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK) //אם המחשב מחזיר תוצאה מוצלחת
                        {
                            Intent data = o.getData();

                            String str = data.getStringExtra("color");
                            //השורה מוציאה מה-Intent את הערך של "color" (אם קיים) ושומרת אותו כמחרוזת במשתנה str.
                            fbModule.writeBackgroundColorToFb(str);
                            //קוראת לפונקציה writeBackgroundColorToFb של האובייקט fbModule, ומעבירה לה את המשתנה str.

                        }

                    }
                }
        );
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onClickSetting(View view) {
        Intent i = new Intent(this, SettingActivity.class);
        resultLauncher.launch(i);
    }

    public void onClickInstruction(View view) {
    }

    public void setNewColorFromFb(String str) {
        // הפיירבייס קורא לפעולה בפעם הראשונה
        // ואחרי כל פעם שהמשתמש משנה את הצבע
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        setBackgroundColor(str);
    }
    //מציגה הודעה (Toast) עם הצבע שהתקבל.
    //משנה את צבע הרקע באמצעות קריאה לפונקציה setBackgroundColor(str).


    public void setBackgroundColor(String color)
    {
        //היא מבנה בקרה שמאפשר לבחור בין כמה אפשרויות שונות על סמך הערך של משתנה.

        switch (color)
        {
            case "Red":
            {
                ll.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue":
            {
                ll.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Pink":
            {
                ll.setBackgroundColor(Color.argb(255,255,192,203));
                break;
            }
            case "Yellow":
            {
                ll.setBackgroundColor(Color.YELLOW);
                break;
            }

            default:
                ll.setBackgroundColor(Color.WHITE);
        }
    }

    //הפונקציה setBackgroundColor משנה את צבע הרקע של אלמנט (ll) לפי הצבע שנמסר כקלט (color):
    //היא בודקת את הערך של color באמצעות switch.
}