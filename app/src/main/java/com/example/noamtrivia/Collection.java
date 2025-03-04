package com.example.noamtrivia;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Question> arr;

    //זו רשימה שבה ניתן לאחסן אלמנטים מסוג כלשהו (במקרה שלך, אלמנטים מסוג Question), והיא מאפשרת גישה, הוספה, ומחיקה של אלמנטים בקלות. בניגוד למערך רגיל (Array), ArrayList יכולה לשנות את גודלה בזמן ריצה, כלומר אפשר להוסיף ולמחוק אלמנטים מבלי להגדיר מראש את גודל הרשימה.
    private int index; // מספר השאלה הבאה בתור

    //הקוד הזה מגדיר מחלקה בשם Collection שנועדה לשמור רשימה של שאלות ולהחזיר את השאלות אחת אחרי השנייה. הנה מה כל פונקציה עושה:
    public Collection()
    {
        Question q1 = new Question("1+10","7", "11", "3","100", 2);
        Question q2 = new Question("1+2", "8", "2", "3","100", 3);
        Question q3 = new Question("1+3", "6", "2", "4","100", 3);
        Question q4 = new Question("1+4", "5", "2", "3","100", 1);
        Question q5 = new Question("1+0", "1", "2", "3","100", 1);

        arr = new ArrayList<>();
        arr.add (q1);
        arr.add (q2);
        arr.add (q3);
        arr.add (q4);
        arr.add (q5);
    }

    public void initQuestions()
    {
        index = 0;
    } //מאתחלת את המשתנה לאפס

    public Question getNextQuestion()
    {
        // הפעולה מחזירה הפניה לשאלה הבאה
        Question q = arr.get(index);
        index++;
        return q;
    }

    public boolean isNotLastQuestion() {
        // הפעולה מחזירה אמת אם אנו בשאלה האחרונה
        return (index < arr.size()); // if not at the end of the ArrayList
        // }
    }

    public int getIndex() {
        return index;
    }
}
