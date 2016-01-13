package com.comoelagua.android.braille;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.WordsDao;

import java.util.ArrayList;
import java.util.List;

public class WordExercisesActivity extends AppCompatActivity {

    private TextView wordLabel;
    private TextView askNumberTextView;
    private TextView askTextView;
    private EditText answerEditText;
    private Button nextButton;

    private ArrayList<Word> wordsList;
    private Word currentWord;
    private int askNumber = 0;
    private int maxSize = 10;
    private int ok = 0;
    private int fail = 0;
    private boolean hasError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_exercises);

        wordLabel = (TextView) findViewById(R.id.wordLabel);
        askNumberTextView = (TextView) findViewById(R.id.askNumber);
        askTextView = (TextView) findViewById(R.id.ask);
        answerEditText = (EditText) findViewById(R.id.answer);
        nextButton = (Button) findViewById(R.id.next);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Braille6-ANSI.ttf");
        askTextView.setTypeface(typeFace);

        WordsDao wordsDao = ((BrailleApplication) getApplicationContext()).getWordsDao();
        wordsList = wordsDao.readRandom( maxSize );
        showAsk(wordsList.get(askNumber));
    }

    protected void showAsk(Word word) {
        currentWord = word;
        askNumberTextView.setText(" " + (1 + askNumber) );
        askTextView.setText(word.getWord());
        answerEditText.setText("");
    }

    public void nextAsk(View view) {
        if (hasError) { // need two click to continue, first to check, second to continue
            hasError = false;
            continueAsk(view);
            return;
        }
        String answer = answerEditText.getText().toString();
        if (currentWord.checkEquals(answer)) {
            ok++;
            continueAsk(view);
            return;
        }

        fail++;
        hasError = true;
        answerFail(view);
    }

    public void continueAsk(View view) {
        askNumber++;
        if (askNumber >= wordsList.size()) {
            showResult();
            return;
        }

        showAsk(wordsList.get(askNumber));
    }

    public void showResult() {
        wordLabel.setText(R.string.result);
        askNumberTextView.setText(" ok " + ok + " : fail " + fail);
        askTextView.setVisibility(View.INVISIBLE);
        answerEditText.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
    }

    private void answerFail(View view) {
        List<Integer> errorsList = currentWord.getErrorsList();
        Spannable answerSpannable = (Spannable) answerEditText.getText();
        for(Integer positionError : errorsList) {
            answerSpannable.setSpan( new ForegroundColorSpan(Color.RED), positionError.intValue(), 1 + positionError.intValue(), Spannable.SPAN_COMPOSING);
        }
    }
}
