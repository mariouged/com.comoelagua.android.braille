package com.comoelagua.android.braille.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ResultExercise implements Serializable {

    protected int okCount;
    protected int failCount;
    protected List<String> charactersErrorsList;

    public ResultExercise() {
        this.okCount = 0;
        this.failCount = 0;
        charactersErrorsList = new ArrayList<>();
    }

    public int getOkCount() {
        return okCount;
    }

    public void setOkCount(int okCount) {
        this.okCount = okCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public void addCharacterError(String character) {
        charactersErrorsList.add(character);
    }

    public void addAllcharactersErrorsList(List charactersErrorsList) {
        this.charactersErrorsList.addAll(charactersErrorsList);
    }

    public List<String> getCharactersErrorsList() {
        return charactersErrorsList;
    }

}
