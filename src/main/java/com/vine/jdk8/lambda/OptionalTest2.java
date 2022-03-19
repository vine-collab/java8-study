package com.vine.jdk8.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author hekai
 * @create 2018-04-11 上午11:50
 */

public class OptionalTest2 {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Abby");
        Employee employee2 = new Employee();
        employee2.setName("Tom");

        Company company = new Company();
        company.setName("ele");
//        company.setEmployees(Arrays.asList(employee, employee2));

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        List<Employee> employees = optionalCompany.map(Company::getEmployees).orElse(Collections.emptyList());
        System.out.println(employees);


    }

    public void test(Optional opt){}


}
