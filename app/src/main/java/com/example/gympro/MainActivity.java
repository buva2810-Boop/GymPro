package com.example.gympro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link buttons from XML
        Button btnWorkout = findViewById(R.id.btnStartWorkout);
        Button btnBMI = findViewById(R.id.btnBMI);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnBuyTools = findViewById(R.id.btnBuyTools); //

        // Start Workout Page
        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WorkoutPage.class);
                startActivity(intent);
            }
        });

        // Open BMI Page
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BMI.class);
                startActivity(intent);
            }
        });

        // Open Buy Tools Page
        btnBuyTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuyToolsActivity.class);
                startActivity(intent);
            }
        });

        // Exit App
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
