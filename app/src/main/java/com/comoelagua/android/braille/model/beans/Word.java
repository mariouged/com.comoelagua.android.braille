package com.comoelagua.android.braille.model.beans;

import com.comoelagua.android.braille.model.beans.interfaces.WordInterface;

public class Word extends WordAbstract {

    public Word() {}

    public WordInterface setWord(String word) {
        this.word = word.toLowerCase();
        return this;
    }

}
