package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> collect = integers.stream().map(i -> i * 3).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> integerList1 = Arrays.asList(1,2,3,4);
        List<Integer> integerList2 = Arrays.asList(5,6,7,4);
        Stream.concat(integerList1.stream(),integerList2.stream()).distinct().forEach(S->System.out.print(S+" "));


        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> collect1 = integers.stream().map(ele -> ele * ele).filter(e -> e > 30).toList();
        System.out.println(collect1);

        List<String> collect2 = integers.stream().map(ele -> ele + " ").filter(e -> e.startsWith("1")).collect(Collectors.toList());
        System.out.println(collect2);

        List<String> element=new ArrayList<>();
        element.add("Roshan");
        element.add("Nikhil");
        element.add("Sanjay");
        element.add("Rupesh");
        element.add("Akhil");
        String collect3 = element.stream().collect(Collectors.joining(","));
        System.out.println(collect3);

        StringJoiner stringJoiner=new StringJoiner(",");
        stringJoiner.add("roshan");
        stringJoiner.add("roshan");
        stringJoiner.add("roshan");
        System.out.println(stringJoiner.toString());
List<String>  list=new ArrayList<>();

        list.add("roshan");
        list.add("roshan");
        list.add("roshan");
        new HashSet<>(list).forEach(System.out::println);
    }
}
