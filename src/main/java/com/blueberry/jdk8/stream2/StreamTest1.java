package com.blueberry.jdk8.stream2;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author Alman
 * @date 2018-04-16 下午4:46
 */

public class StreamTest1 {
    public static void main(String[] args) {
        Student bob = new Student("Bob", 10);
        Student abby = new Student("Abby", 18);
        Student tom = new Student("Tom", 12);
        Student jack = new Student("Jack", 9);
        Student yilia = new Student("Yilia", 18);
        List<Student> students = Arrays.asList(bob, abby, tom, jack);
        System.out.println(students.stream().collect(counting()));
        System.out.println(students.stream().count());

        students.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students.stream().collect(averagingInt(Student::getScore)));
        System.out.println(students.stream().collect(summarizingInt(Student::getScore)));
        System.out.println("-----------");

        System.out.println(students.stream().map(Student::getName).collect(joining()));
        System.out.println(students.stream().map(Student::getName).collect(joining(",")));
        System.out.println(students.stream().map(Student::getName).collect(joining(",", "<begin>", "<end>")));
        System.out.println("----------");

        Map<Integer, Map<String, List<Student>>> map = students.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);

        System.out.println(students.stream().collect(partitioningBy(s -> s.getScore() > 10)));

        Map<Boolean, Map<Boolean, List<Student>>> collect = students.stream().collect(partitioningBy(s -> s.getScore() > 10, partitioningBy(s1 -> s1.getScore() > 15)));
        System.out.println(collect);

        System.out.println("---------------");

        Map<Boolean, Long> collect1 = students.stream().collect(partitioningBy(s -> s.getScore() > 10, counting()));
        System.out.println(collect1);

        Map<String, Student> collect2 = students.stream().collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(collect2);
    }

}
