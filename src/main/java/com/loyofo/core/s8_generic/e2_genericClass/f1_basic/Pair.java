package com.loyofo.core.s8_generic.e2_genericClass.f1_basic;

import java.time.LocalDate;

public class Pair<T> {
    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void update () {
        T t =  getFirst();
    }
}