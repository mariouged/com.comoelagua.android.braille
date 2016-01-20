package com.comoelagua.android.braille.model.beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class ResultExercise implements Serializable {

    protected String wordType;
    protected int okCount;
    protected int failCount;
    protected List<String> charactersErrorsList;
    protected Date begin;
    protected Date end;

    public ResultExercise() {
        this.okCount = 0;
        this.failCount = 0;
        charactersErrorsList = new ArrayList<>();
        begin = new Date();
    }

    public void finish(int okCount, int failCount) {
        this.okCount = okCount;
        this.failCount = failCount;
        end = new Date();
    }

    public int getOkCount() {
        return okCount;
    }

    public int getFailCount() {
        return failCount;
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

    public long getTime() {
        return end.getTime() - begin.getTime();
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }
}
