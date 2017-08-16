package com.example.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adityad on 8/14/17.
 */

public class DatabaseRow {

    private Map<Column<?>, Object> mValues = new HashMap<>();

    public <T> void put(Column<T> col, T val) {
        mValues.put(col, val);
    }

    public <T> T get(Column<T> col) {
        return col.cast(mValues.get(col));
    }

}
