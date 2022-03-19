package com.vine.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alman
 * @date 2018-04-20 下午6:29
 */

public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "welcome");
//        Collections.sort(list);
//        Collections.sort(list, (a, b) -> a.length() - b.length());
//        Collections.sort(list, (a, b) -> b.length() - a.length());
        Collections.sort(list, Comparator.comparingInt(String::length));

        System.out.println(list);
    }
}
