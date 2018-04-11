package com.blueberry.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author hekai
 * @create 2018-04-10 下午3:52
 */

public class PersonTest {

    public static void main(String[] args) {
        Person tom = new Person("Tom", 20);
        Person bob = new Person("Bob", 19);
        Person abby = new Person("Abby", 22);
        List<Person> people = Arrays.asList(tom, bob, abby);
        PersonTest personTest = new PersonTest();
        List<Person> tom1 = personTest.getPersonsByUserName("Tom", people);
        System.out.println(tom1);
        System.out.println("------------------");
        List<Person> personsByAge = personTest.getPersonsByAge(20, people);
        System.out.println(personsByAge);
        System.out.println("------------------");

        List<Person> personsByAge2 = personTest.getPersonsByAge2(20, people, (age, personList) -> personList.stream().filter(item -> item.getAge() > age).collect(Collectors.toList()));
        System.out.println(personsByAge2);
        System.out.println("------------------");

    }

    public List<Person> getPersonsByUserName(String userName, List<Person> person) {
        return person.stream().filter(p -> p.getUserName().equals(userName)).collect(Collectors.toList());
    }


    public List<Person> getPersonsByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, psersonList) ->
             psersonList.stream().filter(item -> item.getAge() > age).collect(Collectors.toList());

        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonsByAge2(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction ) {
        return biFunction.apply(age, personList);
    }


}













