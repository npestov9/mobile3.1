package com.example.a31;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttons[0] = findViewById(R.id.buttonAnswer1);
        buttons[1] = findViewById(R.id.buttonAnswer2);
        buttons[2] = findViewById(R.id.buttonAnswer3);
        buttons[3] = findViewById(R.id.buttonAnswer4);
        progressBar = findViewById(R.id.progressBar);

        initializeQuestions();
        displayQuestion();

        for (int i = 0; i < buttons.length; i++) {
            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(buttons[finalI].getText().toString());
                    loadNextQuestion();
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
        Question currentQuestion = questions.get(currentQuestionIndex);
        textViewQuestion.setText(currentQuestion.getQuestionText());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(currentQuestion.getOptions()[i]);
        }
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            // Correct answer logic
        } else {
            // Wrong answer logic
        }
    }

    private void loadNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            // Finish quiz and go to score activity
        }
    }
}
