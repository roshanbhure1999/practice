package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        Main main =new Main();
////        main.add(120);
////        main.add(11);
////        main.add(2);
////        main.add(4);
////        main.add(4);
////       main.print();
////        System.out.println(  main.peek());

        Random random = new Random();
        random.longs().distinct().limit(10).forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 3, 5, 245, 9, 82, 652, 62, 52, 2, 83, 5, 5296, 2);
        Integer integer = integers.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(integer);
        Integer integer1 = integers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(integer1);
        List<String> list = Arrays.asList("Hello","for","for", "Interview", "Questions", "Answers", "Ram", "for");
        long count = list.stream().filter(s -> {
            if (s.length() > 3) {
                System.out.println(s);
                return true;
            }
            return false;
        }).count();
        System.out.println(count);

        list.stream().sorted(String::compareToIgnoreCase).forEach(System.out::print);
        list.stream().distinct().forEach(e->System.out.print(e+" "));

    }
}
