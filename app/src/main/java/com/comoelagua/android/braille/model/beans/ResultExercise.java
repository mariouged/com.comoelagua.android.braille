package com.comoelagua.android.braille.model.beans;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

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
    protected long bestTimeValue;

    public final static String WORD_BEST_TIME_VALUE = "wordBestTimeValue";
    public final static String PHRASE_BEST_TIME_VALUE = "phraseBestTimeValue";
    public final static String CHARACTER_BEST_TIME_VALUE = "characterBestTimeValue";

    public ResultExercise() {
        setWordType("word");
        this.okCount = 0;
        this.failCount = 0;
        charactersErrorsList = new ArrayList<>();
        begin = new Date();
    }

    public void finish(int okCount, int failCount, AppCompatActivity appCompatActivity) {
        this.okCount = okCount;
        this.failCount = failCount;
        end = new Date();
        bestTimeValue = saveBestTime(appCompatActivity);
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

    protected long saveBestTime(AppCompatActivity appCompatActivity) {
        String namePreference = WORD_BEST_TIME_VALUE;
        if ("phrase".equals(getWordType())) {
            namePreference = PHRASE_BEST_TIME_VALUE;
        } else if ("character".equals(getWordType())) {
            namePreference = CHARACTER_BEST_TIME_VALUE;
        }
        SharedPreferences preferences = appCompatActivity.getSharedPreferences(namePreference, 0);
        long bestTimeValue = preferences.getLong(namePreference, 9999999);
        if (bestTimeValue > getTime()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(namePreference, getTime());
            editor.commit();
            bestTimeValue = getTime();
        }
        return bestTimeValue;
    }

    public long getBestTimeValue() {
        return bestTimeValue;
    }
}
