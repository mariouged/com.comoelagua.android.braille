package com.comoelagua.android.braille.model.daos;

import java.util.ArrayList;

public interface CrudDao {

    public Object create(Object obj);

    public Object update(Object obj);

    public <T> ArrayList<T> read(ArrayList<Criteria> criteriaList);

    public boolean delete(Object object);

}
