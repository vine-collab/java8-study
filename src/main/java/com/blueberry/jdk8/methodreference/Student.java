package com.blueberry.jdk8.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hekai
 * @create 2018-04-11 下午2:39
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;

    private int score;

    public static int compareStudentByScore(Student s1, Student s2){
        return s1.getScore() - s2.getScore();
    }
    public static int compareStudentByName(Student s1, Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
