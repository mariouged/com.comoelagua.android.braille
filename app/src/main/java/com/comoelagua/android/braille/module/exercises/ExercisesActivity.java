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
package com.comoelagua.android.braille.module.exercises;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.comoelagua.android.braille.AlphabetActivity;
import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.ResultsExercisesActivity;
import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.beans.actions.WordCompare;

import java.util.ArrayList;
import java.util.List;

public abstract class ExercisesActivity extends AppCompatActivity implements ExercisesInterface {

    protected TextView wordLabel;
    protected TextView askNumberTextView;
    protected TextView askTextView;
    protected EditText answerEditText;
    protected Button nextButton;
    protected ArrayList<Word> wordsList;
    protected Word currentWord;
    protected WordCompare wordCompare;
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
        setContentView(getContentView());

        wordLabel = (TextView) findViewById(R.id.wordLabel);
        askNumberTextView = (TextView) findViewById(R.id.askNumber);
        askTextView = (TextView) findViewById(R.id.ask);
        answerEditText = (EditText) findViewById(R.id.answer);
        answerEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    nextAsk(v);
                    handled = true;
                }
                return handled;
            }
        });

        nextButton = (Button) findViewById(R.id.next);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Braille6-ANSI.ttf");
        askTextView.setTypeface(typeFace);

        wordCompare = new WordCompare();
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

    public abstract void setWordType();

    public abstract void loadWordsList();

    public int getContentView() {
        return R.layout.activity_word_exercises;
    }

    public void showAsk(Word word) {
        currentWord = word;
        askNumberTextView.setText(" " + (1 + askNumber) );
        askTextView.setText(word.getWord());
        answerEditText.setText("");
        nextButton.setBackgroundColor(getResources().getColor(R.color.nextButton));
    }

    public void nextAsk(View view) {
        if (hasError) { // need two click to continue, first to check, second to continue
            hasError = false;
            continueAsk(view);
            return;
        }
        String answer = answerEditText.getText().toString();
        if (wordCompare.checkEquals(currentWord.getWord(), answer)) {
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

    public void answerFail(View view) {
        List<Integer> positionsErrorsList = wordCompare.getPositionsErrorsList();
        Spannable answerSpannable = (Spannable) answerEditText.getText();
        for(Integer positionError : positionsErrorsList) {
            answerSpannable.setSpan( new ForegroundColorSpan(Color.RED), positionError.intValue(), 1 + positionError.intValue(), Spannable.SPAN_COMPOSING);
        }
        resultExercise.addAllcharactersErrorsList(wordCompare.getCharactersErrorsList());
        nextButton.setBackgroundColor(getResources().getColor(R.color.nextButtonFail));
    }

    public void showResult() {
        Intent intent = new Intent(this, ResultsExercisesActivity.class);
        resultExercise.finish(ok, fail, this);
        intent.putExtra(RESULT_EXERCISE, resultExercise);
        startActivity(intent);
    }

}
