package com.comoelagua.android.braille;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showAlphabet = (Button) findViewById(R.id.showAlphabet);
        showAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlphabetActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionHelp) {
            startActivity(new Intent(this, CharactersActivity.class));
            return true;
        }
        if (item.getItemId() == R.id.actionAlphabet) {
            startActivity(new Intent(this, AlphabetActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void openWordExercises(View view) {
        startActivity(new Intent(this, WordExercisesActivity.class));
    }

    public void openPhraseExercises(View view) {
        startActivity(new Intent(this, PhraseExercisesActivity.class));
    }
}
