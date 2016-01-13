package com.comoelagua.android.braille;

import android.os.Bundle;

import com.comoelagua.android.braille.model.daos.WordsDao;

public class PhraseExercisesActivity extends WordExercisesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void loadWordsList() {
        WordsDao wordsDao = ((BrailleApplication) getApplicationContext()).getWordsDao();
        wordsList = wordsDao.readPhrasesRandom( maxSize );
    }
}
