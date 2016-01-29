package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Word;

import java.util.ArrayList;

public class PhrasesDao {

    private Resources res;

    public PhrasesDao(Resources res) {
        this.res = res;
    }

    public ArrayList<Word> readRandom(int length) {
        ArrayList<Word> phrasesList = readAll();
        ArrayList<Word> shortPhrasesList = new ArrayList<Word>();
        for(int i = 0; i < length; i++) {
            int randomNum = (int) (Math.random() * phrasesList.size() );
            shortPhrasesList.add(phrasesList.get(randomNum));
        }
        return shortPhrasesList;
    }

    public ArrayList<Word> readAll() {
        ArrayList phrasesList = new ArrayList<Word>();
        String[] phrases = res.getStringArray(R.array.phrases);
        for (int i = 0; i < phrases.length; i++) {
            phrasesList.add( new Word(1 + i, phrases[i]) );
        }

        return phrasesList;
    }
}
