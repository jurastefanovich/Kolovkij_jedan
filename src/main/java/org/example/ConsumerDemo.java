package org.example;

import java.util.function.Consumer;

public class ConsumerDemo implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println("Printing: " + integer);
    }

    @Override
    public Consumer<Integer> andThen(Consumer<? super Integer> after) {
        return Consumer.super.andThen(after);
    }
}
