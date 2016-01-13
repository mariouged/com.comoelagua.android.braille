package com.comoelagua.android.braille.model.beans;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Word {

    protected int id;
    protected String word;
    protected List<Integer> errorsList;

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean checkEquals(String answer) {
        if (this.word.equals(answer)) {
            return true;
        }

        errorsList = new ArrayList<>();
        for(int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != word.charAt(i)) {
                errorsList.add(new Integer(i));
            }
        }

        return false;
    }

    public List<Integer> getErrorsList() {
        return errorsList;
    }
}
