package com.loyofo.core.s8_generic.e2_genericClass.f1_basic;

import org.junit.Test;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {

    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    @Test
    public void test() {

    }
}
