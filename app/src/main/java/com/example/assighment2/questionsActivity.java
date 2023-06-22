package com.example.assighment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class questionsActivity extends AppCompatActivity {
    private RecyclerView questionsRecyclerView;
    private QuestionAdapter questionAdapter;
    String   selectedSubject;
    public TextView questionTextView;
    public RadioButton optionATextView;
    public RadioButton optionBTextView;
    public RadioButton optionCTextView;
    public RadioButton optionDTextView;
    private int userScore = 0;
    private int currentQuestionIndex;


    private Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Intent intent = getIntent();
        if (intent != null) {
            selectedSubject = intent.getStringExtra("subject");


        }

//        questionTextView = findViewById(R.id.questionTextView);
//        optionATextView = findViewById(R.id.optionARadioButton);
//        optionBTextView = findViewById(R.id.optionBRadioButton);
//        optionCTextView = findViewById(R.id.optionCRadioButton);
//        optionDTextView = findViewById(R.id.optionDRadioButton);
//       // submitButton = findViewById(R.id.submitButton);



        List<Question> questions = getQuestionsForSubject(selectedSubject);

        questionsRecyclerView = findViewById(R.id.questionsRecyclerView);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionAdapter = new QuestionAdapter(questions);
        questionsRecyclerView.setAdapter(questionAdapter);


    }

    private List<Question> getQuestionsForSubject(String subject) {
        switch (subject) {
            case "Mathematics":
                return getMathQuestions();
            case "English":
                return getEnglishQuestions();
            case "Science":
                return getScienceQuestions();
            default:
                return new ArrayList<>();
        }
    }
    private List<Question> getMathQuestions() {
        List<Question> mathQuestions = new ArrayList<>();

        mathQuestions.add(new Question("What is 2 + 2?", "4", "3", "5", "6","4"));
        mathQuestions.add(new Question("Simplify: 3 + 7 * 2 - 4", "13", "16", "17", "18","14"));
        mathQuestions.add(new Question("What is the square root of 64?", "8", "4", "16", "10","8"));
        mathQuestions.add(new Question("What is the value of pi (π)?", "3.14159", "3.14", "3.142", "3.141","3.14159"));
        mathQuestions.add(new Question("What is 10% of 200?", "20", "2", "40", "10","20"));
        mathQuestions.add(new Question("What is the area of a square with side length 5?", "25", "10", "15", "20","25"));
        mathQuestions.add(new Question("If x + 5 = 10, what is the value of x?", "5", "10", "15", "20","5"));
        mathQuestions.add(new Question("What is the product of 7 and 9?", "86", "63", "72", "81","63"));
        mathQuestions.add(new Question("What is the perimeter of a rectangle with length 8 and width 5?", "26", "32", "40", "48","40"));
        mathQuestions.add(new Question("Solve for x: 2x + 4 = 10", "5", "4", "3", "6","3"));

        return mathQuestions;
    }

    private List<Question> getEnglishQuestions() {
        List<Question> englishQuestions = new ArrayList<>();

        englishQuestions.add(new Question("Question 1", "Option A", "Option B", "Option C", "Option D"));
        englishQuestions.add(new Question("Question 2", "Option A", "Option B", "Option C", "Option D"));

        return englishQuestions;
    }

    private List<Question> getScienceQuestions() {
        List<Question> scienceQuestions = new ArrayList<>();

        scienceQuestions.add(new Question("Question 1", "Option A", "Option B", "Option C", "Option D"));
        scienceQuestions.add(new Question("Question 2", "Option A", "Option B", "Option C", "Option D"));
        return scienceQuestions;
    }

//    public void onClick(View v) {
//        // Get the selected answer
//        RadioGroup optionRadioGroup;
//        int selectedAnswerIndex = optionRadioGroup.getCheckedRadioButtonId();
//        String selectedAnswer = getSelectedAnswer(selectedAnswerIndex);
//
//        // Get the correct answer for the current question
//        String correctAnswer = currentQuestion.getCorrectAnswer();
//
//        // Check if the selected answer is correct
//        if (selectedAnswer.equals(correctAnswer)) {
//            // Increment the user's score if the answer is correct
//            userScore++;
//        }
//
//        // Move to the next question
//        currentQuestionIndex++;
//        if (currentQuestionIndex < mathQuestions.size()) {
//            // Show the next question
//            showNextQuestion();
//        } else {
//            // All questions have been answered
//            // Show the user's score
//            showScore(userScore);
//        }
//    }
//
//    private String getSelectedAnswer(int selectedAnswerIndex) {
//
//        return null;
//    }
//    private void showScore(int score) {
//        // Display the user's score in the UI
//        Toast.makeText(this, "Your score: " + score, Toast.LENGTH_SHORT).show();
//    }
}