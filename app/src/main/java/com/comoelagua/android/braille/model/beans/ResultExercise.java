package com.comoelagua.android.braille.model.beans;

import java.io.Serializable;

public class ResultExercise implements Serializable {

    protected int okCount;
    protected int failCount;

    public ResultExercise(int okCount, int failCount) {
        this.okCount = okCount;
        this.failCount = failCount;
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

}
