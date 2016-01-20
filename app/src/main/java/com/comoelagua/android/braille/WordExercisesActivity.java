/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.WordsDao;

import java.util.ArrayList;
import java.util.List;

public class WordExercisesActivity extends AppCompatActivity {

    protected TextView wordLabel;
    protected TextView askNumberTextView;
    protected TextView askTextView;
    protected EditText answerEditText;
    protected Button nextButton;
    protected String wordType;
    protected ArrayList<Word> wordsList;
    protected Word currentWord;
    protected int askNumber = 0;
    protected int maxSize = 10;
    protected int ok = 0;
    protected int fail = 0;
    protected boolean hasError = false;
    protected ResultExercise resultExercise;

    public final static String RESULT_EXERCISE = "com.comoelagua.android.braille.WordExercisesActivity.RESULT_EXERCISE";

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

        resultExercise = new ResultExercise();

        setWordType();

        loadWordsList();

        showAsk(wordsList.get(askNumber));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_exercises, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAlphabet) {
            startActivity(new Intent(this, AlphabetActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setWordType() {
        resultExercise.setWordType("word");
        Intent intent = getIntent();
        wordType = intent.getStringExtra(MainActivity.WORD_TYPE);
        if ("phrase".equals(wordType)) {
            resultExercise.setWordType("phrase");
            setTitle(R.string.title_activity_phrase_exercises);
            wordLabel.setText(R.string.phrase);
        } else if ("debug".equals(wordType)) {
            maxSize = 2;
        }
    }

    protected void loadWordsList() {
        WordsDao wordsDao = ((BrailleApplication) getApplicationContext()).getWordsDao();
        if ("phrase".equals(wordType)) {
            wordsList = wordsDao.readPhrasesRandom( maxSize );
        } else {
            wordsList = wordsDao.readRandom(maxSize);
        }
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
        Intent intent = new Intent(this, ResultsExercisesActivity.class);
        resultExercise.finish(ok, fail);
        intent.putExtra(RESULT_EXERCISE, resultExercise);
        startActivity(intent);
    }

    protected void answerFail(View view) {
        List<Integer> errorsList = currentWord.getErrorsList();
        Spannable answerSpannable = (Spannable) answerEditText.getText();
        for(Integer positionError : errorsList) {
            answerSpannable.setSpan( new ForegroundColorSpan(Color.RED), positionError.intValue(), 1 + positionError.intValue(), Spannable.SPAN_COMPOSING);
        }
        resultExercise.addAllcharactersErrorsList(currentWord.getCharactersErrorsList());

    }
}
