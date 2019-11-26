package com.example.windows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevBtnAct();
        nextBtnAct();
    }

    public void openNewMainActivity (int i) {
        TextView textView = (TextView) findViewById(R.id.text);
        Intent intent = new Intent(this, MainActivity.class);
        String url = textView.getText().toString().
                replaceAll("\\d", "").trim();
        int number = Integer.parseInt(textView.getText().toString().
                replaceAll("\\D", "").trim());


        textView.setText(url + (number + i));
        startActivity(intent);
    }

    public void prevBtnAct () {
        Button prevBtn = (Button) findViewById(R.id.previousBtn);
        final TextView textView = (TextView) findViewById(R.id.text);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString() == "https://hey-dude.com/1") {
                    finish();
                }
                else {
                    openNewMainActivity(-1);
                }
            }
        });
    }

    public void nextBtnAct () {
        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        final TextView textView = (TextView) findViewById(R.id.text);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewMainActivity(1);
            }
        });
    }
}
