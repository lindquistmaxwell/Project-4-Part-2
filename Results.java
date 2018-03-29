package com.example.max.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by administrator on 3/27/18.
 */

public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String word = getIntent().getStringExtra("word");
        String ant = getIntent().getStringExtra("ant");

        TextView ETentered = findViewById(R.id.ETenteredValue);
        ETentered.setText(word);

        TextView ETreturned = findViewById(R.id.ETreturnedValue);
        ETreturned.setText(ant);

    }

}
