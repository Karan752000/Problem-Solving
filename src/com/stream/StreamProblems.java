package com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProblems {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2,6, 3, 4, 5);

        //sum
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);

        //max
        int max = numbers.stream().max((o1, o2) -> o1 - o2).get();
        OptionalInt max1 = numbers.stream().mapToInt(Integer::intValue).max();
//        System.out.println(max);
//        System.out.println(max1.getAsInt());

        //given a string , write a program to get count that starts with specific character
        List<String> names = List.of("karan", "kiran", "ram");
        long k = names.stream().filter(x -> x.startsWith("k")).count();
//        System.out.println(k);

        //convert strings into upper character
        List<String> list = names.stream().map(String::toUpperCase).toList();
//        System.out.println(list);

        //avg of floating point number
        List<Double> doubles = List.of(1.1, 2.2, 3.3);
        double asDouble = doubles.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println("sdsd"+asDouble);

        //concatinate all string
        String collect = names.stream().collect(Collectors.joining("-", "(", ")"));
//        System.out.println(collect);

        //write a program to remove duplicate
        List<Integer> list1 = List.of(1, 1, 1, 2, 3, 3, 4);
        List<Integer> list2 = list1.stream().distinct().toList();
        Set<Integer> list3 = list1.stream().collect(Collectors.toSet());
//        System.out.println(list3);

        //sort based on attribute
//        List<Person> list4 = Stream.of(new Person(24, "karan"),
//                new Person(22, "sana"),
//                new Person(25, "pavan")).toList();

//        list4.stream()
//                .sorted(Comparator.comparing(Person::getAge))
//                .forEach(System.out::println);

        //given a sentence print the frequency of each word
        String sentence = "hello there hello";
        Map<String, Long> collect1 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//        System.out.println(collect1);

        //get all the numbers start with 1
        List<Integer> list5 = List.of(1, 12, 3, 4, 2, 19);
        List<Integer> list6 = list5.stream().filter(n -> String.valueOf(n).startsWith("1")).toList();
//        System.out.println(list6);

        //group string based on 1st character and get the count
        String[] demo = {"hi", "hello", "apple", "banana"};
        Map<Character, Long> collect2 = Arrays.stream(demo).collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
//        System.out.println(collect2);

        //find the duplicate numbers in array if it  contains multiple duplicates
        int[] arr = {1, 2, 1, 3, 3, 4, 5, 5};
//        Arrays.stream(arr).boxed()
//                .collect(Collectors
//                        .groupingBy( n -> n,Collectors.counting()))
//                .entrySet().stream()
//                .filter( m -> m.getValue()>1)
//                .forEach( v -> System.out.print(v.getKey()+" "));

        System.out.println();
        //collect palindrome string
        String[] str = {"madam", "mam", "sir"};
        List<String> list7 = Arrays.stream(str).filter(s -> s.equals(new StringBuffer(s).reverse().toString())).toList();
//        System.out.println(list7);

        //merge two sorted array
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
//        IntStream.concat(Arrays.stream(a1),Arrays.stream(a2))
//                .sorted().forEach( n -> System.out.print(n + " "));

        //given two list concat and remove duplicates
        List<String> apple = List.of("apple", "banana", "kiwi");
        List<String> apple1 = List.of("apple", "j", "hey");
        List<String> collect3 = Stream.concat(apple1.stream(), apple.stream()).distinct().collect(Collectors.toList());
//        System.out.println("\n"+collect3);
    }

}
