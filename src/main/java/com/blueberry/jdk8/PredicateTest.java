package com.blueberry.jdk8;

import java.util.function.Predicate;

/**
 * @author hekai
 * @create 2018-04-10 下午5:10
 */

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("xxxx"));
    }

}
