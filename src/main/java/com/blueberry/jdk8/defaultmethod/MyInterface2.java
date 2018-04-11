package com.blueberry.jdk8.defaultmethod;

/**
 * @author hekai
 * @create 2018-04-11 下午5:30
 */

public interface MyInterface2 {

    default void myMethod(){
        System.out.println("MyInrterface2");
    }

}
