package com.vine.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @author Alman
 * @date 2018-04-23 上午10:27
 */

public class MySetCollector3<T> implements Collector<T, Set<T>, Map<T, T>> {


    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (set, item) -> {
            System.out.println("accumulator: " + set + "," + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (s1, s2) -> {
            System.out.println("combiner s1:" + s1);
            System.out.println("combiner s2:" + s2);
            s1.addAll(s2);
            return s1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "welcome", "a", "b", "c", "d", "e", "f");
        Set<String> set = new HashSet<>(list);
        Map<String, String> collect = set.parallelStream().collect(new MySetCollector3<>());
        System.out.println(collect);
    }
}
































