package com.example.generics;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by adityad on 8/9/17.
 */

public class Stack<E> {
    private E[] mElements;
    private int mSize = 0;
    private final static int DEFAULT_INITIAL_CAPACITY = 16;

    // Since the array is of type Object[] and only instances of type E will be pushed,
    // this cast is safe.
    @SuppressWarnings("unchecked")
    public Stack() {
        mElements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        mElements[mSize++] = e;
    }

    public E pop() {
        if (mSize == 0)
            throw new EmptyStackException();
        E e = mElements[--mSize];
        mElements[mSize] = null;
        return e;
    }

    public boolean isEmpty() {
        return mSize == 0;
    }

    private void ensureCapacity() {
        if (mSize == mElements.length)
            mElements = Arrays.copyOf(mElements, 2 * mSize + 1);
    }

    public void forEach(Consumer<E> f) {
        int top = mSize-1;
        while (top >= 0)
            f.accept(mElements[top--]);
    }

    public void pushAll(List<? extends E> list) {
        for (E e: list)
            push(e);
    }

    public void popAll(List<? super E> list) {
        while (mSize > 0)
            list.add(pop());
    }
}
