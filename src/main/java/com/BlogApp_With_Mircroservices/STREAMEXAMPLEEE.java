package com.blogapp12;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class STREAMEXAMPLEEE {
    public static void main(String[] args) {
        //STREAM & TYPES OF FUNCTIONAL INTERFACE
//Integer
//      Predicate<Integer> result = n->n%2==0;
//     boolean vale =result.test(101);
//       System.out.println(vale);

        //STRING
//         Predicate<String> result  =  str->str.startsWith("D");
//         boolean val =  result.test("evansh");
//       System.out.println(val);

//     Predicate<String> reuslt = str->str.endsWith("h");
//     boolean val =reuslt.test("Devansh");
//        System.out.println(val);
//
//        Predicate<String> reuslt = str->str.equalsIgnoreCase("devansh");
//        boolean val =reuslt.test("Devansh");
//        System.out.println(val);


        //  FIRST EXAMPLE OF STREAM API
//        List<Integer> data = Arrays.asList(10,21,24,30);
//        List<Integer>newData=data.stream().filter(n->n%2==0).collect(Collectors.toList());
//        System.out.println(newData);

//List<String > data =Arrays.asList("deh","dddd");
 //  List<String> new =data.stream().map(str -> str.substring(1)).collect(Collectors.toList());
//        System.out.println(newData);
//    }
//

  //      List<String> data = Arrays.asList("Devansh","Megha","Ashu");
//
//       List<String> d = data.stream().filter(str -> str.startsWith("D")).collect(Collectors.toList());
//        System.out.println(d);

//       List<String> data = Arrays.asList("devansh","pratap","singh","devansh");
//        List<String> dh = data.stream().filter(str -> str.equalsIgnoreCase("devansh")).collect(Collectors.toList());
//        System.out.println(dh.size());


        //Remove duplicate using distinct
//        List<String> data = Arrays.asList("Devansh","Devansh","pratap","Singh");
//        List<String> val = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(val);

//        List<Integer> data = Arrays.asList(10,23,2,23,4,3,1,3,45,5);
//
//        List<Integer> dl = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(dl);

        //Function Functional Interface
//      Function<Integer,Integer> val = n-> n+10;
//        Integer value = val.apply(11);
//        System.out.println(value);

//        Function<Integer, String> val = n->"To The Principle" + n;
//        String apply = val.apply(10);
//        System.out.println(apply);

//
    //  List<Integer> data = Arrays.asList(10,20,30,50);
//
    //  List<Integer> collect = data.stream().map(n -> n * n).collect(Collectors.toList());
        //   System.out.println(collect);
//
//        List<String> val = Arrays.asList("devansh","thakur");
//        List<String> coll = val.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
//        System.out.println(coll);

        //<19 feb>
      //  Consumer functional Interface
       // Integer
//        Consumer<Integer> val = n-> System.out.println(n);
//        val.accept(10);

        //String
//        Consumer<String> data = n-> System.out.println(n);
//        data.accept("Devansh");

        //ForEach
//        Consumer<Integer> printConsumer = item -> System.out.println(item) ;
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.forEach(printConsumer);

        //Supplier
//        Supplier<Double> data  = ()->Math.random();
//        Double result = data.get();
//        System.out.println(result);

//
//        List<Employee> data = Arrays.asList(
//                new Employee(1,"Devansh",2500),
//                new Employee(2,"Ashu",6000),
//                new Employee(3,"Megha",6000)
//        );
//        List<Employee> newData = data.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
//        for(Employee emp:newData){
//            System.out.println(emp.getId());
//            System.out.println(emp.getName());
//            System.out.println(emp.getSalary());
//

        //Reduce everyone  salary by 500
//        List<Employee> data = Arrays.asList(
//                new Employee(1,"Devansh",2500),
//                new Employee(2,"Ashu",6000),
//                new Employee(3,"Megha",6000)
//        );
//        List<Integer> newData = data.stream().map(e -> e.getSalary() - 500).collect(Collectors.toList());
//        System.out.println(newData);


        //Covert into uppercase
//        List<Employee> data = Arrays.asList(
//                new Employee(1,"Devansh",2500),
//                new Employee(2,"Ashu",6000),
//                new Employee(3,"Megha",6000)
//        );
//        List<String> newData = data.stream().map(e -> e.getName().toUpperCase()).collect(Collectors.toList());
//        System.out.println(newData);


        //Method Reference
//        List<Streamexample.Employee> data = Arrays.asList(
//                new Streamexample.Employee(1,"Devansh",2500),
//                new Streamexample.Employee(2,"Ashu",6000),
//                new Streamexample.Employee(3,"Megha",6000)
//        );
//        List<String> newData = data.stream().map(Streamexample.Employee::getName).collect(Collectors.toList());
//        System.out.println(newData);

        //Finding the sum of all elements in a list of integers:
//                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        int sum = numbers.stream().mapToInt(n -> n).sum();
//        System.out.println("Sum of numbers: " + sum);

//        List<String> sentences = Arrays.asList("This is a sentence.",
//                "Another sentence here.", "The longest sentence in this list.");
//        String longestSentence = sentences.stream()
//                .max(Comparator.comparingInt(String::length))
//                .orElse("");
//        System.out.println("Longest sentence: " + longestSentence);





        //STREAM QUESTION
        //1-
//        List<String> names = Arrays.asList("John", "Sarah", "Tom", "Emily");
//        List<Integer> nameLengths = names.stream().map(String::length).collect(Collectors.toList());
//        System.out.println("Q2. "+nameLengths);

        //2
//        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6);
//        Optional<Integer> reduce = list3.stream().reduce(Integer::sum);
//        System.out.println("Q3. "+reduce.get());
//        System.out.println("Q5. "+reduce);

        //3
//        List<Integer> list4 = Arrays.asList(1,2,3,8);
//        int sum = list4.parallelStream().mapToInt(e -> e.intValue()).sum();
//        System.out.println("Q7. "+sum);

        //4
//        List<String> sentences = Arrays.asList("This is a sentence.", "Another sentence here.", "The longest sentence in this list.");
//        String longestSentence = sentences.stream()
//                .max(Comparator.comparingInt(String::length))
//                .orElse("");
//        System.out.println("Longest sentence: " + longestSentence);

        //5 Filtering out invalid email addresses from a list of strings:
        List<String> emailAddresses = Arrays.asList("john@example.com", "alice@domain", "invalid_email", "bob@example.com");
        List<String> validEmails = emailAddresses.stream()
                .filter(email -> email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
                .collect(Collectors.toList());
        System.out.println("Valid email addresses: " + validEmails);




    }
        }


