package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView secondTextView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        secondTextView = findViewById(R.id.secondTextView);
        secondTextView.setText("En app för att titta på fina öar i grekiska cycladerna. " +
                "Från unga till gamla, leta semestermål eller se lite information om öarna." +
                "\n\nMöjligheter för att skala upp applikationen, exempelvis med med omfattande information" +
                " samt att utöka till alla grekiska ögrupper.");

    }
}