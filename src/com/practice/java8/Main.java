package com.practice.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] array = {"A", "B", "C"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(array));

        Stream.of(array).forEach(System.out::println);

        List<Student> students = Arrays.asList(
                new Student("Alice", 85.5),
                new Student("Bob", 90.0),
                new Student("Charlie", 78.0),
                new Student("David", 92.0),
                new Student("Eva", 88.5)
        );
        List<String> topStudents = students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .limit(3)
                .map(Student::getName)
                .collect(Collectors.toList());

        topStudents.forEach(System.out::println);

        Map<String, Double> stuMap = students.stream().collect(Collectors.toMap(Student::getName, Student::getGrade));

        stuMap.forEach((name, percetage) -> System.out.println("\nName : " +name +", percentage : " +percetage ));

        DoubleSummaryStatistics studentstats = students.stream()
                .collect(Collectors.summarizingDouble(Student::getGrade));
        System.out.println(studentstats.getMax());

        System.out.println("Count number of students " +students.stream().count());

        //group by subjects
        Map<String, List<Student>> studentsGroupedBySubject = students.stream().collect(Collectors.groupingBy(Student::getName));

        studentsGroupedBySubject.forEach((subject, studentlst) -> {
            System.out.println("Subject: " + subject);
            studentlst.forEach(student -> System.out.println("  com.practice.java8.Student Name: " + student.getName()));
        });

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "John Doe", 25, "Male", "HR", 2015, 50000),
                new Employee(2, "Jane Smith", 30, "Female", "Finance", 2013, 60000),
                new Employee(3, "Mike Johnson", 35, "Male", "IT", 2010, 70000),
                new Employee(4, "Emily Davis", 28, "Female", "Sales", 2016, 55000),
                new Employee(5, "Robert Wilson", 40, "Male", "Sales", 2008, 80000),
                new Employee(2, "Kanchan K", 35, "Female", "Finance", 2013, 900000),
                new Employee(3, "Sayali S", 38, "Male", "IT", 2010, 40000),
                new Employee(4, "Sona Em", 28, "Female", "Sales", 2016, 85000),
                new Employee(5, "Sudesh D", 60, "Male", "Sales", 2008, 30000)
        );

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getSalary)));

        employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(1).forEach(System.out::println);

        System.out.println("Sales ppls below");
        employeeList.stream().filter(emo -> emo.getDepartment()
                .equalsIgnoreCase("sales")).forEach(System.out::println);

        //print maximum salary for each department
        System.out.println("\nprint maximum salary for each department **** \n");
        Map<String, Optional<Double>> maxSalaryByDept =
                employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getSalary,
                                Collectors.maxBy(Comparator.naturalOrder()))
                ));

        maxSalaryByDept.forEach((empName, salary) ->
                System.out.println("Department Name :" +empName
                        +"  Salary  " +salary.orElse(0.00)));
    }
}