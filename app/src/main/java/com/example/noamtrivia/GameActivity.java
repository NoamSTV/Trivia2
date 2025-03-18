package com.example.noamtrivia;
import android.graphics.Color; // ספריית הצבעים


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1,btna2,btna3,btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber,tvPoints, tvGameOver;

    private Collection2 collection2;
    private Question q;
    private int points = 0;

    private LinearLayout ll;
    private String color;  // משתנה לשמירת הצבע



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String color = getIntent().getStringExtra("backgroundColor");  // מקבל את הצבע כ-String
        if (color == null) {
            color = "White";  // ברירת מחדל אם לא הועבר צבע
        }



        // אתחול רכיבי ה-UI
        tvQuestion = findViewById(R.id.tvQuestion);
        btna1 = findViewById(R.id.btna1);
        btna2 = findViewById(R.id.btna2);
        btna3 = findViewById(R.id.btna3);
        btna4 = findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvPoints = findViewById(R.id.tvPoints);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvGameOver = findViewById(R.id.tvGameOver);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection2 = new Collection2();
        collection2.initQuestions();

        // אתחול ה-LinearLayout (ll) שצפוי לשנות את צבע הרקע
        ll = findViewById(R.id.activity_game);  // ודא שה-id תואם לרכיב המתאים ב-XML שלך
        setBackgroundColor(color);  // שינוי צבע הרקע לפי הצבע שהתקבל

        // קבלת הצבע שהעברנו מ-Intent


        nextQuestion();  // הצגת שאלה ראשונה
    }

    private void nextQuestion() {
        if(collection2.isNotLastQuestion())
        {
            q = collection2.getNextQuestion();

            tvQuestion.setText(q.getQuestion());
            btna1.setText(q.getA1());
            btna2.setText(q.getA2());
            btna3.setText(q.getA3());
            btna4.setText(q.getA4());
        }
        else
        {
            tvGameOver.setVisibility(View.VISIBLE); //הופך את הרכיב לגלוי על המסך
            createDialog();
        }

    }

    private void createDialog() {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == btna1)
        {
            if(q.getCorrect() == 1)
                points++;
        }
        if(v == btna2)
        {
            if(q.getCorrect() == 2)
                points++;
        }
        if(v == btna3)
        {
            if(q.getCorrect() == 3)
                points++;
        }
        if(v == btna4)
        {
            if(q.getCorrect() == 4)
                points++;
        }

        tvPoints.setText("points: " + points);
        if(collection2.isNotLastQuestion())
        {
            tvQuestionNumber.setText("Question number: " + (collection2.getIndex() + 1));
        }

        nextQuestion();
    }

    public void setBackgroundColor(String color) {
        switch (color) {
            case "Red":
                ll.setBackgroundColor(Color.RED);
                break;
            case "Blue":
                ll.setBackgroundColor(Color.BLUE);
                break;
            case "Pink":
                ll.setBackgroundColor(Color.argb(255, 255, 192, 203));
                break;
            case "Yellow":
                ll.setBackgroundColor(Color.YELLOW);
                break;
            default:
                ll.setBackgroundColor(Color.WHITE);
                break;
        }
    }

    public void reset() {
        this.points = 0;
        collection2.initQuestions();
        tvPoints.setText("Points: " + 0);
        tvQuestionNumber.setText("Question number: " + 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }


}