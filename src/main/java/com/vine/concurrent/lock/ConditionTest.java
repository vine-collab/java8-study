package com.vine.concurrent.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author 阿季
 * @date 2022-04-04 5:21 PM
 */

public class ConditionTest {


    public static void main(String[] args) {
        BoundedContainer boundedContainer = new BoundedContainer();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.take();
            } catch (Exception e) {

            }
        }).start());
        IntStream.range(0, 20).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.put("nb");
            } catch (Exception e) {

            }
        }).start());




    }






}

class BoundedContainer {

    private String[] elements = new String[10];

    private Lock lock = new ReentrantLock();

    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    // 数组中已有元素的个数
    private int elementCount;

    private int putIndex;

    private int takeIndex;


    public void put(String element) throws InterruptedException {
        this.lock.lock();
        try {
            while (elementCount == elements.length) {
                notFullCondition.await();
            }
            elements[putIndex] = element;
            elementCount++;
            if (++putIndex == elements.length) {
                putIndex = 0;
            }
            System.out.println("put method:" + Arrays.toString(elements));

            notEmptyCondition.signalAll();

        } finally {
            lock.unlock();
        }


    }

    public String take() throws InterruptedException {

        this.lock.lock();
        try {
            while (elementCount == 0) {
                notEmptyCondition.await();
            }

            String element = elements[takeIndex];
            elements[takeIndex] = null;
            elementCount--;
            if (++takeIndex == elements.length) {
                takeIndex = 0;
            }
            System.out.println("take method:" + Arrays.toString(elements));

            notFullCondition.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
    }
}

























