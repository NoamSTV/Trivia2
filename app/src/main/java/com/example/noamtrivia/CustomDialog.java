package com.example.noamtrivia;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnYes, btnNo;
    Context context;

    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);
        this.context = context;

        this.btnYes = findViewById(R.id.btnYes);
        this.btnNo = findViewById(R.id.btnNo);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(btnYes == view)
        {
            dismiss(); // סוגר את הדיאלוג הנוכחי
            ((GameActivity)context).reset();
        }

        //זהו סוג (Type) של האובייקט שמייצג את רכיב ה-UI שבו המשתמש לחץ. ב-Android, כל רכיב מסך, כמו כפתור, תמונה, שדה טקסט וכו', הוא אובייקט מסוג View.

        if(btnNo == view)
        {
            ((GameActivity)context).finish(); //מוציאה את השחקן מהמסך הנוכחי ומעבירה אותו למסך הקודם
        }
    }
}
