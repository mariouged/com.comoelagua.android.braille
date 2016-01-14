package com.comoelagua.android.braille.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Word {

    protected int id;
    protected String word;
    protected List<Integer> errorsList;

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

    public boolean checkEquals(String answer) {
        String answerLower = answer.toLowerCase();
        if (word.equals(answerLower)) {
            return true;
        }

        errorsList = new ArrayList<>();
        for(int i = 0; i < answerLower.length(); i++) {
            if (answerLower.charAt(i) != word.charAt(i)) {
                errorsList.add(new Integer(i));
            }
        }

        return false;
    }

    public List<Integer> getErrorsList() {
        return errorsList;
    }
}
