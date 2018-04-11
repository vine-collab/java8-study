package com.blueberry.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @author hekai
 * @create 2018-04-11 下午2:51
 */

public class StudentTest {
    public static void main(String[] args) {
        Student bob = new Student("Bob", 10);
        Student abby = new Student("Abby", 18);
        Student tom = new Student("Tom", 18);
        Student jack = new Student("Jack", 18);

        List<Student> students = Arrays.asList(bob, abby, tom, jack);
        students.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
        System.out.println(students);
        System.out.println("------静态方法引用-------");
        students.sort(Student::compareStudentByName);
        System.out.println(students);

        System.out.println("------实例方法引用-------");
        StudentComparator studentComparator = new StudentComparator();

        students.sort((s1, s2) -> studentComparator.compareStudentByScore(s1, s2));
        students.sort(studentComparator::compareStudentByName);
        System.out.println(students);
    }
}
