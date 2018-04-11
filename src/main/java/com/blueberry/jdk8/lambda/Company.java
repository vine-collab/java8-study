package com.blueberry.jdk8.lambda;

import lombok.Data;

import java.util.List;

/**
 * @author hekai
 * @create 2018-04-11 上午11:48
 */
@Data
public class Company {

    private String name;

    private List<Employee> employees;
}
