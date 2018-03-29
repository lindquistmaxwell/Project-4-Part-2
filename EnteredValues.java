package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by administrator on 3/20/18.
 */

public class EnteredValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entervalues);
    }

    public void onAddClick(View v) {
        if(v.getId() == R.id.AddToList) {
            EditText word = (EditText)findViewById(R.id.ETword);
            EditText ant = (EditText)findViewById(R.id.ETantonym);

            String wordstr = word.getText().toString();
            String antstr = ant.getText().toString();

            Pairs p = new Pairs();
            p.setWord(wordstr);
            p.setAnt(antstr);
            helper.insertPair(p);

            Intent i = new Intent(EnteredValues.this, Welcome.class);
            startActivity(i);
        }
    }

}
