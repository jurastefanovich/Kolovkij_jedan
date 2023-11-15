package org.example;

import java.util.function.Function;

public class FunctionDemo implements Function<Integer, String> {
    @Override
    public String apply(Integer integer) {
        return integer * 10 + " data multiplied by 10";
    }

    @Override
    public <V> Function<V, String> compose(Function<? super V, ? extends Integer> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Integer, V> andThen(Function<? super String, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
