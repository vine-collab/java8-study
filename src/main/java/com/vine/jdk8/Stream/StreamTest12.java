package com.vine.jdk8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alman
 * @date 2018-04-15 下午5:54
 */

public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "Hi", "Are you ok");
        List<String> list1 = Arrays.asList("Bob", "Tom", "Jack", "Abby");

        List<String> collect = list.stream().flatMap(item -> list1.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        System.out.println(collect);


    }

}
