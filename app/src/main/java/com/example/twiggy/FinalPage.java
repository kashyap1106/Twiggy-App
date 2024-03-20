package com.example.twiggy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class FinalPage extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    PinView pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(FinalPage.this,R.color.lightorange));
        setContentView(R.layout.activity_final_page);
        pinView=findViewById(R.id.verify_otp);
        pinView.requestFocus();
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().length()==4){
                    Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imageView=findViewById(R.id.back_arrow_last);
        textView = findViewById(R.id.textView_otp);
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        textView.setText("Verify with OTP sent to " + phoneNumber);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
