package com.pk.java8.stream;

import org.apache.commons.collections.collection.CompositeCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    private static List<Employee> getEmployeeList() {
        Employee employee1 = new Employee("TOM", "RD", 10000.0);
        Employee employee2 = new Employee("TOM", "RD", 15000.0);
        Employee employee3 = new Employee("TOM", "RD", 20000.0);
        Employee employee4 = new Employee("TOM", "RD", 50000.0);
        Employee employee5 = new Employee("Jerry", "QA", 13000.0);
        Employee employee6 = new Employee("Jerry", "QA", 20000.0);
        Employee employee7 = new Employee("Jone", "PM", 30000.0);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        return employeeList;
    }

    /**
     * 获得所有员工的姓名
     */
    public static List<String> getNameList() {
        List<Employee> employeeList = getEmployeeList();
        return employeeList.stream().map(Employee::getName).collect(Collectors.toList());
    }

    /**
     * 每个职位有多少人
     */
    public static Map<String, Long> getPositionCount() {
        List<Employee> employeeList = getEmployeeList();
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
    }

    /**
     * 每个职位的平均工资
     */
    public static Map<String, Double> getPositionAvgList() {
        List<Employee> employeeList = getEmployeeList();
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getPosition,
                Collectors.averagingDouble(Employee::getSalary)));
    }

    /**
     * 每个职位的最高工资
     */
    public static Map<String, Optional<Double>> getPositionMaxList() {
        List<Employee> employeeList = getEmployeeList();
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getPosition,
                Collectors.mapping(Employee::getSalary,Collectors.maxBy(Double::compare))));
    }


    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("abc");
        list.add("adc");
        list.add("aec");
    }

}
