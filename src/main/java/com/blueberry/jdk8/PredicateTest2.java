package com.blueberry.jdk8;

import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author hekai
 * @create 2018-04-10 下午5:10
 */

public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 test2 = new PredicateTest2();
        test2.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("--------------");
        test2.conditionFilter(list, item -> true);
        System.out.println("--------------");
        test2.conditionFilter(list, item -> false);

        System.out.println("--------------");
        test2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);

        System.out.println("--------------");
        System.out.println(test2.isEqual("test").test("test"));
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2){
        for (Integer integer : list){
            if(predicate.and(predicate2).negate().test(integer)){
                System.out.println(integer);
            }
        }
    }

    public Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }

}
