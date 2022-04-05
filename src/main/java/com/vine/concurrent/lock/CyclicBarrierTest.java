package com.vine.concurrent.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author 阿季
 * @date 2022-04-05 3:09 PM
 */

public class CyclicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
//        cyclicBarrierTest.test();

        cyclicBarrierTest.test3();


    }

    private void test3() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("^^^");
        });
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random() * 2000));

                        int i1 = new Random().nextInt(500);
                        System.out.println("----" + i1);
                        cyclicBarrier.await();

                        System.out.println("++++" + i1);
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }


    private void test2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random() * 2000));

                        int i1 = new Random().nextInt(500);
                        System.out.println("----" + i1);
                        cyclicBarrier.await();

                        System.out.println("++++" + i1);
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }


    private void test() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("----");
                    cyclicBarrier.await();

                    System.out.println("++++");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
