package com.vine.jdk8.lambda;

import java.util.function.Function;

/**
 * @author hekai
 * @create 2018-04-10 上午11:16
 */

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(1, value -> 5 + value));
        System.out.println(functionTest.convert(100, String::valueOf));
    }

    public int compute(int a, Function<Integer, Integer> function){

        return function.apply(a);
    }

    public String convert(int x, Function<Integer, String> function){
        return function.apply(x);
    }
}
