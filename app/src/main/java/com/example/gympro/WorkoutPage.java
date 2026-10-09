package com.example.gympro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutPage extends AppCompatActivity {

    Spinner spinnerDay;
    ListView listWorkout;
    Button btnSaveWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_page);

        spinnerDay = findViewById(R.id.spinnerDay);
        listWorkout = findViewById(R.id.listWorkout);
        btnSaveWorkout = findViewById(R.id.btnSaveWorkout);

        // Days of workouts
        String[] days = {"Chest Day", "Back Day", "Leg Day"};

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                days
        );
        spinnerDay.setAdapter(dayAdapter);

        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] workouts;

                if (position == 0) {
                    workouts = new String[]{"Bench Press", "Incline Dumbbell Press", "Chest Fly", "Push Ups"};
                } else if (position == 1) {
                    workouts = new String[]{"Pull Ups", "Lat Pulldown", "Barbell Row", "Deadlift"};
                } else {
                    workouts = new String[]{"Squats", "Leg Press", "Lunges", "Calf Raises"};
                }

                ArrayAdapter<String> workoutAdapter = new ArrayAdapter<>(
                        WorkoutPage.this,
                        android.R.layout.simple_list_item_1,
                        workouts
                );

                listWorkout.setAdapter(workoutAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Navigate to SavedWorkoutActivity on button click
        btnSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create intent
                Intent intent = new Intent(WorkoutPage.this, SavedWorkout.class);

                // Get selected day
                String selectedDay = spinnerDay.getSelectedItem().toString();

                // Get all workouts from list view
                int count = listWorkout.getCount();
                StringBuilder workouts = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    workouts.append(listWorkout.getItemAtPosition(i).toString());
                    if (i != count - 1) workouts.append(", ");
                }

                // Pass data to next activity
                intent.putExtra("day", selectedDay);
                intent.putExtra("workouts", workouts.toString());

                startActivity(intent);
            }
        });
    }
}
