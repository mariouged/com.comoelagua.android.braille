package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import java.util.ArrayList;
import java.util.HashSet;

public class WordsDao implements WordsDaoInterface {

    protected Resources res;
    protected ArrayList wordsListAll = null;

    public WordsDao(Resources res) {
        this.res = res;
    }

    public ArrayList<Word> readRandom(int length) {
        ArrayList<Word> wordsList = readAll();
        ArrayList<Word> randomWordsList = new ArrayList<Word>();
        int size = wordsList.size();
        HashSet<Integer> randomsNums = new HashSet<>(size);
        for(int i = 0; i < length; i++) {

            int randomNum = getRandom(size);
            while (randomsNums.contains(new Integer(randomNum))) {
                randomNum = getRandom(size);
            }
            randomsNums.add(new Integer(randomNum));

            randomWordsList.add( wordsList.get(randomNum) );
        }
        return randomWordsList;
    }

    protected int getRandom(int size) {
        return (int) (Math.random() * size);
    }

    public ArrayList<Word> readAll() {
        if (wordsListAll != null) {
            return wordsListAll;
        }
        ArrayList wordsListAll = new ArrayList<Word>();
        String[] wordsArray = getStringArray();
        for (int i = 0; i < wordsArray.length; i++) {
            wordsListAll.add( new Word(1 + i, wordsArray[i]) );
        }

        return wordsListAll;
    }

    public String[] getStringArray() {
        return res.getStringArray(R.array.words);
    }
}
