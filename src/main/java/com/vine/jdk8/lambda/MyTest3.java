package com.vine.jdk8.lambda;

import java.util.function.Function;

/**
 * @author hekai
 * @create 2018-04-09 下午4:32
 */

public class MyTest3 {

    public static void main(String[] args) {
        TheInterface theInterface = () -> {};
        System.out.println(theInterface.getClass().getInterfaces()[0]);

        TheInterface2 theInterface2 = () -> {};
        System.out.println(theInterface2.getClass().getInterfaces()[0]);

        new Thread(() -> System.out.println("runnable")).start();

        System.out.println("-------------------");

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

    }

}


@FunctionalInterface
interface TheInterface{
    void myMethod();
}

@FunctionalInterface
interface TheInterface2{
    void myMethod2();
}
