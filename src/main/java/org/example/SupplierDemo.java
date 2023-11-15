package org.example;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {
    @Override
    public String get() {
        return "Hello this is string from " + SupplierDemo.class;
    }
}
