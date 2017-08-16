package com.example.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adityad on 8/14/17.
 */

public class Favourite {

    private Map<Class<?>, Object> mFavourites = new HashMap<>();

    public <T> void putFavourite(Class<T> key, T object) {
        mFavourites.put(key, object);
    }

    public <T> T getFavourite(Class<T> key) {
        return key.cast(mFavourites.get(key));
    }
}
