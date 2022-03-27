package com.vine.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试
 *
 * @author 阿季
 * @date 2022-03-27 7:40 PM
 */

public class Test1 {

    Lock lock = new ReentrantLock();

    private void test1() {
        try {
            lock.lock();
            System.out.println("test1 -----");

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            lock.unlock();
        }
    }

    private void test2() {
        try {
            lock.lock();
            System.out.println("test2 -----");

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test1.test1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test1.test2();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}



















