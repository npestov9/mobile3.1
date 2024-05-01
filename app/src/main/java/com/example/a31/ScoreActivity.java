package com.example.a31;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewFinalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textViewFinalScore = findViewById(R.id.textViewFinalScore);
        Button buttonTakeNewQuiz = findViewById(R.id.buttonTakeNewQuiz);
        Button buttonFinish = findViewById(R.id.buttonFinish);

        int score = getIntent().getIntExtra("SCORE", 0);
        textViewFinalScore.setText("Score: " + score + "/5");

        buttonTakeNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to restart the MainActivity for a new quiz
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();  // Finish ScoreActivity to clear it from the back stack
            }
        });

        buttonTakeNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear the activity stack
                startActivity(intent);
                finish();
            }
        });

    }
}
