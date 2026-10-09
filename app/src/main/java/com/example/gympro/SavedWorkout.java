package com.example.gympro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SavedWorkout extends AppCompatActivity {

    TextView tvDay, tvWorkouts;
    Button btnGoBMI, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_workout);

        tvDay = findViewById(R.id.tvDay);
        tvWorkouts = findViewById(R.id.tvWorkouts);
        btnGoBMI = findViewById(R.id.btnGoBMI);
        btnHome = findViewById(R.id.btnHome);

        // Receive data from previous page
        String day = getIntent().getStringExtra("day");
        String workouts = getIntent().getStringExtra("workouts");

        tvDay.setText(day);
        tvWorkouts.setText(workouts);

        // Go to BMI page
        btnGoBMI.setOnClickListener(v -> {
            Intent intent = new Intent(SavedWorkout.this, BMI.class);
            startActivity(intent);
        });

        // Return to Home page
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(SavedWorkout.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
