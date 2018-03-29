package com.example.max.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by administrator on 3/27/18.
 */

public class Welcome extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.enterButton) {
            Intent i = new Intent(Welcome.this, EnteredValues.class);
            startActivity(i);
        } else if(v.getId() == R.id.findButton) {
            EditText word = findViewById(R.id.userInput);
            String wordstr = word.getText().toString();
            String ant = helper.searchPair(wordstr);

            Intent i = new Intent(Welcome.this, Results.class);
            i.putExtra("word", wordstr);
            i.putExtra("ant", ant);
            startActivity(i);
        }
    }

}
