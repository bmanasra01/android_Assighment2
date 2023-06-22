package com.example.assighment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner agespinner = findViewById(R.id.spinnerAge);
        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonNext = findViewById(R.id.nextbt);

        PreferenceUtils preferenceUtils = new PreferenceUtils(this);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(agespinner.getSelectedItem().toString());

                User user = new User(name, age);
                preferenceUtils.saveUser(user);

                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
        User savedUser = preferenceUtils.getUser();
        if (savedUser != null) {
            editTextName.setText(savedUser.getName());
            int ageIndex = savedUser.getAge() - 6;
            agespinner.setSelection(ageIndex);
        }



    }
}