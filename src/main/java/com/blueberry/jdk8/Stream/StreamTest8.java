package com.blueberry.jdk8.Stream;

import java.util.stream.IntStream;

/**
 * @author Alman
 * @date 2018-04-12 下午7:56
 */

public class StreamTest8 {

    public static void main(String[] args) {
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }

}
