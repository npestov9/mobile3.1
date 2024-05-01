package com.example.a31;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button[] buttons = new Button[4];
    private ProgressBar progressBar;
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setupQuiz();
    }

    private void setupQuiz() {
        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttons[0] = findViewById(R.id.buttonAnswer1);
        buttons[1] = findViewById(R.id.buttonAnswer2);
        buttons[2] = findViewById(R.id.buttonAnswer3);
        buttons[3] = findViewById(R.id.buttonAnswer4);
        progressBar = findViewById(R.id.progressBar);

        initializeQuestions();
        currentQuestionIndex = 0; // Reset the question index
        score = 0; // Reset the score
        displayQuestion();

        for (int i = 0; i < buttons.length; i++) {
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(buttons[finalI].getText().toString(), buttons[finalI]);
                }
            });
        }
    }

    private void initializeQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}, "Paris"));
        questions.add(new Question("Which country has the largest area?", new String[]{"Russia", "Canada", "China", "United States"}, "Russia"));
        questions.add(new Question("Which river is the longest in the world?", new String[]{"Amazon", "Nile", "Yangtze", "Mississippi"}, "Nile"));
        questions.add(new Question("What is the smallest country in the world?", new String[]{"Monaco", "Nauru", "Vatican City", "Malta"}, "Vatican City"));
        questions.add(new Question("Which desert is the largest in the world?", new String[]{"Sahara", "Arabian", "Gobi", "Kalahari"}, "Sahara"));
        progressBar.setMax(questions.size());
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            textViewQuestion.setText(currentQuestion.getQuestionText());
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setText(currentQuestion.getOptions()[i]);
                buttons[i].setBackgroundColor(Color.LTGRAY); // Reset the color for new question
            }
            progressBar.setProgress(currentQuestionIndex + 1);
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        int finalScore = score; // Assuming 'score' is the variable that holds the final score count
        Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
        intent.putExtra("SCORE", finalScore); // Use a simple and clear key, typically a constant
        startActivity(intent);
        finish(); // Close the QuizActivity
    }

    private void checkAnswer(String selectedAnswer, Button selectedButton) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        boolean isCorrect = selectedAnswer.equals(currentQuestion.getCorrectAnswer());
        selectedButton.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);

        if (isCorrect){
            score += 1;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectedButton.setBackgroundColor(Color.LTGRAY); // Reset color after display
                currentQuestionIndex++;
                displayQuestion();
            }
        }, 1000); // Delay of 1 second to show color before moving to the next question
    }
}
