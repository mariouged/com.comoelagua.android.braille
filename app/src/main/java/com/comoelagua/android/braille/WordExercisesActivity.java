package com.comoelagua.android.braille;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.WordsDao;

import java.util.ArrayList;

public class WordExercisesActivity extends AppCompatActivity {

    private ArrayList<Word> wordsList;
    private Word currentWord;
    private int askNumber = 1;
    private int maxAsk = 10;
    private int ok = 0;
    private int fail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_exercises);

        TextView askTextView = (TextView) findViewById(R.id.ask);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Braille6-ANSI.ttf");
        askTextView.setTypeface(typeFace);

        WordsDao wordsDao = ((BrailleApplication) getApplicationContext()).getWordsDao();
        wordsList = wordsDao.readRandom(maxAsk);
        setAsk(wordsList.get(0));
    }

    protected void setAsk(Word word) {
        currentWord = word;
        TextView askNumber = (TextView) findViewById(R.id.askNumber);
        askNumber.setText(" " + askNumber);
        TextView askTextView = (TextView) findViewById(R.id.ask);
        askTextView.setText(word.getWord());
        EditText answerEditText = (EditText) findViewById(R.id.answer);
        answerEditText.setText("");
    }

    public void checkEquals(View view) {
        EditText answerEditText = (EditText) findViewById(R.id.answer);
        String answer = answerEditText.getText().toString();
        if (currentWord.checkEquals(answer)) {
            ok++;
            nextAsk(view);
        }

        fail++;
        // TODO currentWord.getErrorsPosition and display spannable red char errors
    }

    public void nextAsk(View view) {
        if (askNumber >= maxAsk) {
            showResult(view);
        }
        setAsk( wordsList.get(askNumber) );
        askNumber++;
    }

    public void showResult(View view) {
        TextView wordLabel = (TextView) findViewById(R.id.wordLabel);
        wordLabel.setText(R.string.result);
        TextView askNumber = (TextView) findViewById(R.id.askNumber);
        askNumber.setText(" ok " + ok + " : fail " + fail);
        TextView askTextView = (TextView) findViewById(R.id.ask);
        askTextView.setVisibility(View.INVISIBLE);
        EditText answerEditText = (EditText) findViewById(R.id.answer);
        answerEditText.setVisibility(View.INVISIBLE);
        View checkEquals = findViewById(R.id.checkEquals);
        checkEquals.setVisibility(View.INVISIBLE);
        View next = findViewById(R.id.next);
        next.setVisibility(View.INVISIBLE);
    }
}
