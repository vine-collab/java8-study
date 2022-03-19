package com.vine.jdk8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author hekai
 * @create 2018-04-10 下午2:17
 */

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
        System.out.println(functionTest2.compute(2, a -> a + 1, a -> a * a));// 5
        System.out.println(functionTest2.compute2(2, a -> a + 1, a -> a * a));// 9

        System.out.println("-------------------");
        System.out.println(functionTest2.compute3(1, 2, (a, b) -> a + b));

        System.out.println("-------------------");
        System.out.println(functionTest2.compute4(1, 2, (a, b) -> a + b, c -> c * c));

    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        return biFunction.andThen(function).apply(a, b);
    }
}
