package com.vine.jdk8.methodreference;

/**
 * @author hekai
 * @create 2018-04-11 下午3:14
 */

public class StudentComparator {

    public int compareStudentByScore(Student s1, Student s2){
        return s1.getScore() - s2.getScore();
    }
    public int compareStudentByName(Student s1, Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
