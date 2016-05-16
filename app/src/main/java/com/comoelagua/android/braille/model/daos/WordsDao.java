package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Word;
import com.comoelagua.android.braille.model.beans.interfaces.WordInterface;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class WordsDao implements WordsDaoInterface {

    protected Resources res;
    protected ArrayList wordsListAll = null;

    public WordsDao(Resources res) {
        this.res = res;
    }

    public ArrayList<WordInterface> readRandom(int length) {
        ArrayList<WordInterface> wordsList = readAll();
        ArrayList<WordInterface> randomWordsList = new ArrayList<>();
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

    public ArrayList<WordInterface> readAll() {
        if (wordsListAll != null) {
            return wordsListAll;
        }
        ArrayList wordsListAll = new ArrayList<>();
        String[] wordsArray = getStringArray();
        for (int i = 0; i < wordsArray.length; i++) {
            WordInterface word = new Word();
            word.setId(1 + i).setWord(wordsArray[i]);
            wordsListAll.add( word );
        }

        return wordsListAll;
    }

    public String[] getStringArray() {
        return res.getStringArray(R.array.words);
    }

    public Hashtable<String, String> getHashConverter() {
        Hashtable<String, String> hashConverter
                = new Hashtable<String, String>();
        hashConverter.put("one", "1");
        return hashConverter;
    }
}
