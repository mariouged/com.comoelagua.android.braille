package com.comoelagua.android.braille.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Word {

    protected int id;
    protected String word;
    protected List<Integer> errorsList;
    protected List<String> charactersErrorsList;

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
        charactersErrorsList = new ArrayList<>();
        for(int i = 0; i < answerLower.length(); i++) {
            if (i < word.length() && answerLower.charAt(i) != word.charAt(i)) {
                errorsList.add(new Integer(i));
                charactersErrorsList.add(word.substring(i, 1 + i));
            } else if(i >= word.length()) {
                errorsList.add(new Integer(i));
                charactersErrorsList.add(answerLower.substring(i, 1 + i));
            }
        }

        return false;
    }

    public List<Integer> getErrorsList() {
        return errorsList;
    }

    public List<String> getCharactersErrorsList() {
        return charactersErrorsList;
    }
}
