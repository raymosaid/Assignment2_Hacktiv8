package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView number_count_text;
    private Button counter_button;
    private EditText text_input;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_count_text = findViewById(R.id.number_count_text);
        counter_button = findViewById(R.id.counter_button);
        text_input = findViewById(R.id.text_input);

        counter_button.setOnClickListener(this);

        if(savedInstanceState != null){
            number = savedInstanceState.getInt("number");
            number_count_text.setText(String.valueOf(number));
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.counter_button){
            number++;
            number_count_text.setText(String.valueOf(number));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("number", number);
    }
}