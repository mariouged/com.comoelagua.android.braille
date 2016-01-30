package com.comoelagua.android.braille.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Word {

    protected int id;
    protected String word;

    public Word(int id, String word) {
        this.id = id;
        setWord(word);
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
        this.word = word.toLowerCase();
    }

}
