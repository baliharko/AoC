package com.baliharko.adventofcode.twentyone.day1;

import com.baliharko.adventofcode.twentyone.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1b {

    public static void main(String[] args) throws IOException {
        List<Integer> input = Util.readFile("src/resources/twentyone/day1/input.txt")
                .stream().mapToInt(Integer::parseInt).boxed().toList();

        List<Integer> windows = new ArrayList<>();

        for (int i = 2; i < input.size(); i++) {
            int a = input.get(i - 2);
            int b = input.get(i - 1);
            int c = input.get(i);

            windows.add(a + b + c);
        }

        int times = 0;

        for (int i = 1; i < windows.size(); i++) {
            if (windows.get(i - 1) < windows.get(i))
                times++;
        }

        System.out.println("\n" + times);
    }
}
