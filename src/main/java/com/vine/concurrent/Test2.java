package com.vine.concurrent;

/**
 * @author 阿季
 * @date 2022-03-19 16:33
 */

public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();

        Thread thread = new Thread(() -> {
            try {
                myClass.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                myClass.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        Thread.sleep(700);
        thread1.start();
    }
}


class MyClass {
    public synchronized void  sayHello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("hello");
    }


    public synchronized void  sayWorld() throws InterruptedException {
        System.out.println("world");
    }
}