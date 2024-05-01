package com.example.a31;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button[] buttons = new Button[4];
    private ProgressBar progressBar;
    private int questionIndex = 0;  // Assuming you have a way to track questions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        progressBar = findViewById(R.id.progressBar);
        buttons[0] = findViewById(R.id.buttonAnswer1);
        buttons[1] = findViewById(R.id.buttonAnswer2);
        buttons[2] = findViewById(R.id.buttonAnswer3);
        buttons[3] = findViewById(R.id.buttonAnswer4);

        // Set up listeners for buttons, load questions, etc.
    }
}
