package com.blueberry.jdk8.Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alman
 * @date 2018-04-15 下午1:58
 */

public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");

        list.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(length -> length >= 5).findFirst().ifPresent(System.out::println);
    }

}
