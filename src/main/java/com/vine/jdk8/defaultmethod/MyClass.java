package com.vine.jdk8.defaultmethod;

/**
 * @author hekai
 * @create 2018-04-11 下午5:29
 */

public class MyClass extends MyInterface1Impl implements MyInterface2 {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

}
