package com.example.generics;

import java.util.Comparator;
import java.util.List;

/**
 * Created by adityad on 8/10/17.
 */

public final class Utils {

    public static <T extends Comparable<T>> T max(List<T> list) {
        T max = null;
        for (T elem : list) {
            if (max == null || elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    }

    // The PECS rule: producer-extends and consumer-super.
    // In this method the "list" parameter provides (produces) T objects to the loop so we bound the type parameter
    // with the "extends" wildcard.
    //
    // Comparable accepts (consumes) a T object for comparison so we use the
    // "super" wildcard type. As a thumb-rule all comparables and comparators should be considered consumers.
    public static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
        T max = null;
        for (T elem : list) {
            if (max == null || elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    }

}
