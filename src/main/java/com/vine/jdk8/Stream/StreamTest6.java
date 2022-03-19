package com.vine.jdk8.Stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Alman
 * @date 2018-04-12 下午5:16
 */

public class StreamTest6 {

    public static void main(String[] args) {
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        generate.findFirst().ifPresent(System.out::println);

        Integer reduce = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
        System.out.println(reduce);

        Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        System.out.println("--------------");

        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics);
        System.out.println("--------------");
    }

}
