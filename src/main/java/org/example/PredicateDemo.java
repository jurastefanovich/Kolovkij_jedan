package org.example;

import java.util.function.Predicate;

public class PredicateDemo implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
    @Override
    public Predicate<Integer> and(Predicate<? super Integer> other) {
        return Predicate.super.and(other);
    }
    @Override
    public Predicate<Integer> negate() {
        return Predicate.super.negate();
    }
    @Override
    public Predicate<Integer> or(Predicate<? super Integer> other) {
        return Predicate.super.or(other);
    }
}
