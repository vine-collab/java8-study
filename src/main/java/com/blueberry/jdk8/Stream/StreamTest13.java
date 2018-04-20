package com.blueberry.jdk8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alman
 * @date 2018-04-15 下午9:01
 */

public class StreamTest13 {
    public static void main(String[] args) {

        Student bob = new Student("Bob", 10, 20);
        Student abby = new Student("Abby", 18, 21);
        Student tom = new Student("Tom", 18, 22);
        Student jack = new Student("Jack", 18, 23);

        List<Student> students = Arrays.asList(bob, abby, tom, jack);

        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(collect);
        Map<String, Long> collect1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(collect1);
        Map<String, Double> collect2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(collect2);
        Map<Boolean, List<Student>> collect3 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 15));
        System.out.println(collect3);

    }

}
