package com.xlix;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToggle = findViewById(R.id.btnToggle);
        btnToggle.setOnClickListener(v ->
                Toast.makeText(this, "Toggle WhatsApp clicked!", Toast.LENGTH_SHORT).show()
        );
    }
}
