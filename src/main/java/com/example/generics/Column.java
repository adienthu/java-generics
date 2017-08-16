package com.example.generics;

/**
 * Created by adityad on 8/14/17.
 */
public class Column<T> {

    private Class<T> mType;

    public Column(Class<T> type) {
        mType = type;
    }

    public T cast(Object obj) {
        return mType.cast(obj);
    }

}
