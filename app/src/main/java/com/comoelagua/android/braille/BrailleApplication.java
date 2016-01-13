package com.comoelagua.android.braille;

import android.app.Application;

import com.comoelagua.android.braille.model.daos.WordsDao;

public class BrailleApplication extends Application {

    private WordsDao wordsDao;

    public BrailleApplication() {
        super();
    }

    public WordsDao getWordsDao() {
        if (wordsDao == null) {
            wordsDao = new WordsDao();
        }
        return wordsDao;
    }
}
