package com.blueberry.jdk8.lambda;

/**
 * @author Alman
 * @date 2018-04-22 下午5:55
 */

public class Test {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        new Thread(() -> System.out.println("hello")).start();

        System.out.println(thread.getClass());

    }

}
