package com.blogapp12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streamexample {
    public static void main(String[] args) {
//<20 Jan>
        List<Employee> data = Arrays.asList(
                new Employee(1, "Devansh", 6000),
                new Employee(2, "Megha", 7000),
                new Employee(3, "Ashu", 6000),
                new Employee(4,"Bhawesj",3000),
                new Employee(1,"Karan",7000)
        );
        Map<Integer, List<Employee>> newData = data.stream().collect(Collectors.groupingBy(e->e.getSalary()));
       // System.out.println(newData.entrySet());
        for(Map.Entry<Integer, List<Employee>> entry :newData.entrySet()){
           // System.out.println(entry);
           System.out.println(entry.getKey());//It give me the only key name from the set.
          //  System.out.println(entry.getValue());//It give me the value only.
            List<Employee> emp = entry.getValue();
            System.out.println(emp );
        }
    }

    public static class Employee {
        private  long id;
        private  String name;
        private int  salary;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public Employee(long id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }
}
