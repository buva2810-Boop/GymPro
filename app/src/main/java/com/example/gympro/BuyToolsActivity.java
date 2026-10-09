package com.example.gympro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class BuyToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tools);

        Button btnDumbbell = findViewById(R.id.btnDumbbell);
        Button btnBench = findViewById(R.id.btnBench);
        Button btnBack = findViewById(R.id.btnBack);

        // Open Shopee
        btnDumbbell.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://shopee.com.my"));
            startActivity(intent);
        });

        // Open Lazada
        btnBench.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.lazada.com.my"));
            startActivity(intent);
        });

        // Back to Home
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
