package com.comoelagua.android.braille.model.daos;

public class Criteria {

    private String parameter;
    private String condition;
    private String value;

    public Criteria(String parameter, String condition, String value) {
        this.parameter = parameter;
        this.condition = condition;
        this.value = value;
    }

    public String getParameter() {
        return parameter;
    }

    public String getCondition() {
        return condition;
    }

    public String getValue() {
        return value;
    }
}
