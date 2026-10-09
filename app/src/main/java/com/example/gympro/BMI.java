package com.example.gympro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMI extends AppCompatActivity {

    // Declare variables for views
    EditText etHeight, etWeight;
    Button btnCalculate, btnAbout, btnHome;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // Link XML views to Java variables
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnAbout = findViewById(R.id.btnAbout);
        btnHome = findViewById(R.id.btnHome);
        tvResult = findViewById(R.id.tvResult);

        // Calculate BMI
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etHeight.getText().toString().isEmpty() ||
                        etWeight.getText().toString().isEmpty()) {

                    Toast.makeText(BMI.this, "Enter height and weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                double height = Double.parseDouble(etHeight.getText().toString()) / 100;
                double weight = Double.parseDouble(etWeight.getText().toString());

                double bmi = weight / (height * height);

                tvResult.setText(String.format(
                        java.util.Locale.getDefault(),
                        "Your BMI: %.2f", bmi));
            }
        });

        // Go to About page
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(BMI.this, AboutPage.class);
            startActivity(intent);
        });

        // Back to Home page
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(BMI.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
