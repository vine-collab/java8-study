package com.vine.jdk8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alman
 * @date 2018-04-15 下午5:31
 */

public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world hello", "world hello", "hello world");

        list.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(length -> length >= 5).findFirst().ifPresent(System.out::println);


        List<String> collect = list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);

    }
}
