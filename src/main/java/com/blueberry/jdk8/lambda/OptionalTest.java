package com.blueberry.jdk8.lambda;

import java.util.Optional;

/**
 * @author hekai
 * @create 2018-04-11 上午11:21
 */

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> opt = Optional.empty();
        if(opt.isPresent()){
            System.out.println(opt.get());
        }
        opt.ifPresent(System.out::print);

        System.out.println("----------------");
        System.out.println(opt.orElse("Tom"));
        System.out.println(opt.orElseGet(() -> "java"));


    }

}
