package com.example.noamtrivia;



import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.databaset.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule {
    private Context context; //השורה יוצרת משתנה ששומר מידע על ההקשר של האפליקציה.


    public FbModule(Context context) {
        this.context = context;

        FirebaseDatabase database = FirebaseDatabase.getInstance(); //מחזירה את האובייקט של המסד נתונים כדי שנוכל לערוך בו
        DatabaseReference reference = database.getReference("color"); //יוצר הפנייה להתיב "color" במסד נתונים.
        reference.addValueEventListener(
                new ValueEventListener() {

                    //DataSnapshot הוא אובייקט שמייצג את מצב הנתונים במערכת נתונים (כמו Firebase) בזמן מסוים, ומאפשר לך לגשת ולקרוא את הערכים השונים ששמורים שם.
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String str = snapshot.getValue(String.class);
                        ((MainActivity)context).setNewColorFromFb(str);
                        //השורה הזו מפעילה את הפונקציה setNewColorFromFb במחלקת MainActivity, ומעבירה לה את הערך str (שהוא צבע) כדי לעדכן את הממשק או לבצע פעולה כלשהי עם הצבע הזה.
                    }

                    //הקוד מאזין לשינויים בנתיב "color" ב-Firebase, ומעדכן את צבע הרקע בממשק המשתמש כאשר הערך משתנה.

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    public void writeBackgroundColorToFb(String str)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //הקוד יוצר חיבור לבסיס הנתונים של Firebase ומחזיר אובייקט המייצג את ה-Database כדי לאפשר גישה ופעולות עליו.
        DatabaseReference reference = database.getReference("color");
        reference.setValue(str);
    }

    //הפעולה כותבת ערך (str) לשדה בשם "color" בבסיס הנתונים של Firebase.
}
