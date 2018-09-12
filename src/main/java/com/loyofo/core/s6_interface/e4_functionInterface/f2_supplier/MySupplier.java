package com.loyofo.core.s6_interface.e4_functionInterface.f2_supplier;

import java.util.function.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 14:04
 */
public class MySupplier {

    public int getInt(IntSupplier supplier){
        return supplier.getAsInt();
    }

    public long getLong(LongSupplier supplier){
        return supplier.getAsLong();
    }

    public double getDouble(DoubleSupplier supplier){
        return supplier.getAsDouble();
    }

    public boolean getBoolean(BooleanSupplier supplier){
        return supplier.getAsBoolean();
    }

    public <T> T getInstance(Supplier<T> supplier){
        return supplier.get();
    }
}
