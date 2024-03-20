package com.example.twiggy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.textfield.TextInputEditText;

public class NextActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        getWindow().setStatusBarColor(ContextCompat.getColor(NextActivity.this, R.color.lightorange));

        button = findViewById(R.id.otp);
        imageView = findViewById(R.id.back_arrow);
        textInputEditText = findViewById(R.id.text_input_edit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = textInputEditText.getText().toString();
                Intent intent = new Intent(NextActivity.this, FinalPage.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finish current activity
            }
        });
    }
}
