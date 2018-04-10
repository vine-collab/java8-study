package com.blueberry.jdk8;

import java.util.function.Supplier;

/**
 * @author hekai
 * @create 2018-04-10 下午7:47
 */

public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("--------------");
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
    }

}
