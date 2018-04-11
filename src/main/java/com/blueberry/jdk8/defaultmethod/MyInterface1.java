package com.blueberry.jdk8.defaultmethod;

/**
 * @author hekai
 * @create 2018-04-11 下午5:01
 */

public interface MyInterface1 {

    default void myMethod(){
        System.out.println("MyInterface1");
    }
}
