package com.vine.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author hekai
 * @create 2018-04-11 下午2:51
 */

public class StudentTest {

    public String getString(Supplier<String> supplier){
        return supplier.get() + "test";
    }

    public String getString(Function<String, String> function, String string){
        return function.apply(string);
    }

    public static void main(String[] args) {
        Student bob = new Student("Bob", 10);
        Student abby = new Student("Abby", 18);
        Student tom = new Student("Tom", 18);
        Student jack = new Student("Jack", 18);

        List<Student> students = Arrays.asList(bob, abby, tom, jack);
        students.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
        System.out.println(students);
        System.out.println("------静态方法引用【类名::静态方法名】-------");
        students.sort(Student::compareStudentByName);
        System.out.println(students);

        System.out.println("------类成员方法引用【引用名（对象名）::实例方法名】-------");
        StudentComparator studentComparator = new StudentComparator();

        students.sort((s1, s2) -> studentComparator.compareStudentByScore(s1, s2));
        students.sort(studentComparator::compareStudentByName);
        System.out.println(students);

        System.out.println("------对象方法引用【类名::实例方法名】-------");
        students.sort(Student::compareByName);
        System.out.println(students);

        List<String> cityes = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
        Collections.sort(cityes, (a, b) -> a.compareToIgnoreCase(b));
        Collections.sort(cityes, String::compareToIgnoreCase);
        System.out.println(cityes);

        System.out.println("------构造方法引用【类名::new】-------");
        StudentTest studentTest = new StudentTest();
        System.out.println(studentTest.getString(String::new));
        System.out.println(studentTest.getString(String::new, "hello"));

    }
}
