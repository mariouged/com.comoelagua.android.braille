package com.comoelagua.android.braille;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.comoelagua.android.braille.adapter.AlphabetAdapter;

public class AlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        ListView alphabetList = (ListView) findViewById(R.id.alphabetList);
        alphabetList.setAdapter(new AlphabetAdapter(this));
    }

}
