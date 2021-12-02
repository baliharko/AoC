package com.baliharko.adventofcode.twentyone.day1;

import com.baliharko.adventofcode.twentyone.util.Util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1a {

    public static void main(String[] args) throws IOException {
        List<String> input = Util.readFile("/day1/input.txt");

        AtomicInteger last = new AtomicInteger(0);
        AtomicInteger times = new AtomicInteger(0);

        input.stream().mapToInt(Integer::parseInt)
                .forEach(value -> {
                    if (value > last.get()) {

                        if (!(last.get() == 0))
                            times.incrementAndGet();
                    }

                    last.set(value);
                });

        System.out.println(times.get());
    }
}
