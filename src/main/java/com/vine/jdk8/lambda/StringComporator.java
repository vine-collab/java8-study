package com.vine.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hekai
 * @create 2018-04-09 下午6:12
 */

public class StringComporator {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("x", "b", "a", "c");
        Collections.sort(strings, (a, b) -> a.compareTo(b));
        System.out.println(strings);

    }
}
