package com.vine.jdk8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author hekai
 * @create 2018-04-12 上午10:36
 */

public class StreamTest4 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
        String[] stringArray = list.stream().toArray(length -> new String[length]);
        stringArray = list.stream().toArray(String[]::new);
        Arrays.asList(stringArray).forEach(System.out::println);

        System.out.println("--------------");
        List<String> collect = list.stream().collect(Collectors.toList());
        System.out.println("--------------");
        ArrayList<Object> collect1 = list.stream().collect(ArrayList::new, List::add, List::addAll);
        ArrayList<String> collect2 = list.stream().collect(Collectors.toCollection(ArrayList::new));
        TreeSet<String> collect3 = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect3);
        String collect4 = list.stream().collect(Collectors.joining());
        System.out.println(collect4);
    }

}
