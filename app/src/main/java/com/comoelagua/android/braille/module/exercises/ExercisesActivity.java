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
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.comoelagua.android.braille.AlphabetActivity;
import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.ResultsExercisesActivity;
import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.beans.actions.WordCompare;
import com.comoelagua.android.braille.model.beans.interfaces.WordInterface;
import com.comoelagua.android.braille.module.exercises.listener.AnswerOnEditorActionListener;
import com.comoelagua.android.braille.module.exercises.listener.NextAskOnClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public abstract class ExercisesActivity extends AppCompatActivity implements ExercisesInterface {

    protected TextView wordLabel;
    protected TextView askNumberTextView;
    protected TextView askTextView;
    protected EditText answerEditText;
    protected Button nextButton;
    protected TextToSpeech textToSpeech;
    protected HashMap<String, String> hashAlarm;
    protected ArrayList<WordInterface> wordsList;
    protected WordInterface currentWord;
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
        answerEditText.setOnEditorActionListener(new AnswerOnEditorActionListener(this));

        nextButton = (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(new NextAskOnClickListener(this));

        Typeface typeFace = Typeface.createFromAsset(getAssets(), getString(R.string.brailleFont));
        askTextView.setTypeface(typeFace);

        initTextToSpeech();

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

    public WordInterface getCurrentWord() { return currentWord; }

    public int getContentView() {
        return R.layout.activity_word_exercises;
    }

    public void showAsk(WordInterface word) {
        currentWord = word;
        askNumberTextView.setText(" " + (1 + askNumber) );
        askTextView.setText(word.getWordToView());
        answerEditText.setText("");
        //answerEditText.setEnabled(true);
        nextButton.setBackgroundResource(R.color.nextButton);
        nextButton.setText(R.string.next);
    }

    public void nextAsk() {
        if (hasError) { // need two click to continue, first to check, second to continue
            hasError = false;
            continueAsk();
            return;
        }
        String answer = answerEditText.getText().toString();
        if (wordCompare.checkEquals(currentWord.getWordToCompare(), answer)) {
            ok++;
            continueAsk();
            return;
        }

        fail++;
        hasError = true;
        answerFail();
    }

    public void continueAsk() {
        askNumber++;
        if (askNumber >= wordsList.size()) {
            showResult();
            return;
        }

        showAsk(wordsList.get(askNumber));
    }

    public void answerFail() {
        List<Integer> positionsErrorsList = wordCompare.getPositionsErrorsList();
        Spannable answerSpannable = (Spannable) answerEditText.getText();
        for(Integer positionError : positionsErrorsList) {
            answerSpannable.setSpan( new ForegroundColorSpan(Color.RED), positionError.intValue(), 1 + positionError.intValue(), Spannable.SPAN_COMPOSING);
        }
        resultExercise.addAllcharactersErrorsList(wordCompare.getCharactersErrorsList());
        nextButton.setBackgroundResource(R.color.nextButtonFail);
        //answerEditText.setEnabled(false); // on disabled EditText red char no show, all text color : grey
        nextButton.setText(R.string.nextContinue);
        speech(R.string.answerFail, null);

    }

    public void showResult() {
        Intent intent = new Intent(this, ResultsExercisesActivity.class);
        resultExercise.finish(ok, fail, this);
        intent.putExtra(RESULT_EXERCISE, resultExercise);
        startActivity(intent);
    }

    protected void initTextToSpeech() {
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage( Locale.getDefault() );
                }
            }
        });
        hashAlarm = new HashMap();
        hashAlarm.put(
            TextToSpeech.Engine.KEY_PARAM_STREAM,
                String.valueOf(AudioManager.STREAM_ALARM)
        );
    }

    protected void speech(int rsid, String msg) {
        msg = (rsid > 0) ? getResources().getString(rsid) : (null != msg) ? msg : "No has message";

        textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, hashAlarm);
    }

}
