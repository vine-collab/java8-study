package com.blueberry.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author hekai
 * @create 2018-04-10 下午7:58
 */

public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        binaryOperatorTest.compute(1, 23, Integer::sum);
        System.out.println("--------------");

        System.out.println(binaryOperatorTest.getShot("xxx", "yyyy", (a, b) -> a.length() - b.length()));
        System.out.println(binaryOperatorTest.getShot("xxx", "yyyy", (a, b) -> a.charAt(0) - b.charAt(0)));
    }


    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a, b);
    }

    public String getShot(String a, String b, Comparator<String> comparator){
        return BinaryOperator.maxBy(comparator).apply(a, b);
    }
}
