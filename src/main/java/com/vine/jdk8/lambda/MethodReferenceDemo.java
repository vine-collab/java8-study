package com.vine.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author hekai
 * @create 2018-04-11 下午2:30
 */

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(System.out::print);
    }

}
