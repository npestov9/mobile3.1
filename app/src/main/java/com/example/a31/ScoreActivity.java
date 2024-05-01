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

        // Assuming the score is passed as an Intent extra
        int score = getIntent().getIntExtra("SCORE", 0);
        textViewFinalScore.setText("Your final score:" + score);

        buttonTakeNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to restart the MainActivity
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the app
                finishAffinity();  // Closes all activities in the stack
            }
        });
    }
}
