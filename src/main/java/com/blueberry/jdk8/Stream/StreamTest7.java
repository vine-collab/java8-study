package com.blueberry.jdk8.Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alman
 * @date 2018-04-12 下午7:49
 */

public class StreamTest7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;

        }).forEach(System.out::println);
    }

}
