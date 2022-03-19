package com.vine.concurrent;


/**
 * @author 阿季
 * @date 2022-03-19 15:08
 */

public class Test1 {

    private int count;


    private synchronized void increase() throws InterruptedException {

        // if(count !=0) {
        while(count !=0) {
            wait();
        }
        count++;
        System.out.println(count);
        notifyAll();

    }


    private synchronized void decrease() throws InterruptedException {
        // if (count != 1) {
        while(count != 1) {
            wait();
        }
        count--;
        System.out.println(count);
        notifyAll();
    }


    public static void main(String[] args) {
        Test1 test = new Test1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    test.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    test.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    test.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    test.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



}
