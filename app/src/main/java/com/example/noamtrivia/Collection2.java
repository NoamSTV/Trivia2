package com.example.noamtrivia;

import java.util.Random;



public class Collection2 {
    private Question[] arr = new Question[10];
    private int[] arr2 = new int[10];
    private  int index;


    public Collection2()
    {
        arr[0] = new Question("5 + 7", "12", "13", "10", "15", 1);
        arr[1] = new Question("8 - 3", "4", "6", "5", "7", 3);
        arr[2] = new Question("6 * 4", "24", "26", "20", "28", 1);
        arr[3] = new Question("12 / 4", "2", "5", "4", "3", 4);
        arr[4] = new Question("15 + 9", "25", "22", "23", "24", 4);
        arr[5] = new Question("7 * 6", "42", "44", "40", "36", 1);
        arr[6] = new Question("18 - 5", "12", "13", "14", "15", 2);
        arr[7] = new Question("9 * 8", "70", "74", "72", "75", 3);
        arr[8] = new Question("20 / 5", "4", "5", "6", "7", 1);
        arr[9] = new Question("25 - 10", "14", "16", "15", "13", 3);

        shuffleArray();  // ערבוב השאלות

    }


    private void shuffleArray() {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);  // בחר אינדקס אקראי
            // החלף את המיקום בין שני האיברים במערך
            Question temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public void initQuestions()
    {
        index = 0;
    } //מאתחלת את המשתנה לאפס

    public Question getNextQuestion()
    {
        if(index == 0){}
        // הפעולה מחזירה הפניה לשאלה הבאה
        Question q = arr[index];


        index++;
        return q;
    }

    public boolean isNotLastQuestion() {
        // הפעולה מחזירה אמת אם אנו בשאלה האחרונה
        return (index < arr.length); // if not at the end of the ArrayList
        // }
    }

    public int getIndex() {
        return index;
    }


}
