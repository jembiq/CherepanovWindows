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

        TextView textView = (TextView) findViewById(R.id.text);
        String url = textView.getText().toString().
                replaceAll("\\d", "").trim();

        textView.setText(url + (Counter.getCount()));

        prevBtnAct();
        nextBtnAct();
    }


    public void prevBtnAct () {
        Button prevBtn = (Button) findViewById(R.id.previousBtn);
        final TextView textView = (TextView) findViewById(R.id.text);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reduceCount();
                finish();
            }
        });
    }

    public void nextBtnAct () {
        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        final TextView textView = (TextView) findViewById(R.id.text);
        final Intent intent = new Intent(this, MainActivity.class);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.raiseCount();
                startActivity(intent);
            }
        });
    }
}
