package com.comoelagua.android.braille;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.comoelagua.android.braille.model.beans.ResultExercise;
import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;
import com.comoelagua.android.braille.module.exercises.ExercisesActivity;

public class NumbersExercisesActivity extends ExercisesActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_numbers_exercises;
    }

    @Override
    public void setWordType() {
        wordLabel.setText(R.string.number);
        resultExercise.setWordType(ResultExercise.NUMBER_TYPE);
    }

    @Override
    public void loadWordsList() {
        WordsDaoInterface numbersDao = ((BrailleApplication) getApplicationContext()).getWordsDao(DaosContainer.NUMBERS_DAO_TYPE);
        wordsList = numbersDao.readRandom(maxSize);
    }

    public void showAsk(Word word) {
        super.showAsk(word);

        Resources res = getResources();
        String[] numbersArray = res.getStringArray(R.array.numbers);
        String[] numbersBraille = res.getStringArray(R.array.numbersBraille);
        String w = word.getWord();
        String askReFormat = "";
        for (int i = 0; i < numbersArray.length; i++) {
            if (w.equals(numbersArray[i])) {
                askReFormat = numbersBraille[i];
                break;
            }
        }
        askTextView.setText(askReFormat);

    }
}
