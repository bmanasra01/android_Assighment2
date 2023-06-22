package com.example.assighment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course2);

        TextView textViewGreeting = findViewById(R.id.hello);
        String name = getIntent().getStringExtra("name");
        textViewGreeting.setText("Hi " + name + ", let's start with some questions.");

        Button mathButton = findViewById(R.id.mathbt);
        Button englishButton = findViewById(R.id.englishbt);
        Button scienceButton = findViewById(R.id.scincebt);

        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionsActivity("Mathematics");
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionsActivity("English");
            }
        });

        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionsActivity("Science");
            }
        });




    }

    private void openQuestionsActivity(String subject) {
        Intent intent = new Intent(this, questionsActivity.class);
        intent.putExtra("subject", subject);
        startActivity(intent);
    }
}