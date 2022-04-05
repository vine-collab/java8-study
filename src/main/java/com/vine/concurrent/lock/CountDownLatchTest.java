package com.vine.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author 阿季
 * @date 2022-04-05 1:25 PM
 */

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("xxx");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start());
        System.out.println("----");
        countDownLatch.await();
        System.out.println("****");

    }

}
