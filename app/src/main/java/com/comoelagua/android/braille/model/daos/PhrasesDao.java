package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import java.util.ArrayList;

public class PhrasesDao extends WordsDao implements CrudDao {

    public PhrasesDao(Resources res) {
        super(res);
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public <T> ArrayList<T> read(ArrayList<Criteria> criteriaList) {
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }


}
