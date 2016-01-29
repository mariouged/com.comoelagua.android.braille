package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Word;

import java.util.ArrayList;

public class WordsDao implements CrudDao {

    private Resources res;

    public WordsDao(Resources res) {
        this.res = res;
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public <T> ArrayList<T> read(ArrayList<Criteria> criteriaList) {
        boolean random = false;
        int length = 0;
        for(Criteria criteria : criteriaList) {
            if ("random".equals( criteria.getParameter() )) {
                random = true;
            }
            if ("length".equals( criteria.getParameter() )) {
                length = Integer.parseInt( criteria.getValue() );
            }
        }
        if (random && length > 0) {
            ArrayList<T> wordsList = (ArrayList<T>) readRandom(length);
            return wordsList;
        }
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    public ArrayList<Word> readRandom(int length) {
        ArrayList<Word> wordsList = readAll();
        ArrayList<Word> shortWordsList = new ArrayList<Word>();
        for(int i = 0; i < length; i++) {
            int randomNum = (int) (Math.random() * wordsList.size() );
            shortWordsList.add( wordsList.get(randomNum) );
        }
        return shortWordsList;
    }

    public ArrayList<Word> readAll() {
        ArrayList wordsList = new ArrayList<Word>();
        String[] wordsArray = res.getStringArray(R.array.words);
        for (int i = 0; i < wordsArray.length; i++) {
            wordsList.add( new Word(1 + i, wordsArray[i]) );
        }

        return wordsList;
    }

}
