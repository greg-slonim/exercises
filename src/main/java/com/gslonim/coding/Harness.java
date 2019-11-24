package com.gslonim.coding;

import java.util.function.Function;

public interface Harness<T, R> {
    Function<T, R> solution();
}
